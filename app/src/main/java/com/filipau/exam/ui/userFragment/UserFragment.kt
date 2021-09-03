package com.filipau.exam.ui.userFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.filipau.data.NetConstants.DEFAULT_STRING
import com.filipau.data.NetConstants.HTTP
import com.filipau.data.NetConstants.HTTPS
import com.filipau.data.NetConstants.TEL
import com.filipau.domain.dto.user.AddressDto
import com.filipau.domain.dto.user.GeoDto
import com.filipau.domain.dto.user.UserDto
import com.filipau.domain.outcome.Outcome
import com.filipau.exam.Constants.ERROR
import com.filipau.exam.Constants.GEO_LAT_KEY
import com.filipau.exam.Constants.GEO_LNG_KEY
import com.filipau.exam.Constants.ID_POST_KEY
import com.filipau.exam.MainActivity
import com.filipau.exam.R
import com.filipau.exam.base.mvvm.BaseMvvmView
import com.filipau.exam.databinding.FragmentUserBinding
import com.filipau.exam.ext.showAlertDialog
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class UserFragment : ScopeFragment(R.layout.fragment_user), BaseMvvmView {

    private var binding: FragmentUserBinding? = null
    private lateinit var postId: String
    private val viewModel: UserViewModel by stateViewModel()
    private var urlWeb = DEFAULT_STRING
    private var userPhone = DEFAULT_STRING
    private var userGeoLat = DEFAULT_STRING
    private var userGeoLng = DEFAULT_STRING
    private var userInfo = UserDto(AddressDto("", GeoDto("", ""), ""), "", 0, "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = binding?.toolbar
        (requireActivity() as MainActivity).setSupportActionBar(toolbar)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        postId = arguments?.getString(ID_POST_KEY) ?: ERROR
        binding?.postId?.text = postId

        binding?.userEmail?.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_APP_EMAIL)
            requireActivity().startActivity(intent)
        }

        binding?.userWeb?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            if (!urlWeb.startsWith(HTTP) && !urlWeb.startsWith(HTTPS)) {
                urlWeb = HTTP + urlWeb
            }
            intent.data = Uri.parse(urlWeb)
            startActivity(intent)
        }

        binding?.userPhone?.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse(TEL + userPhone))
            startActivity(intent)
        }

        binding?.userCity?.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(GEO_LAT_KEY, userGeoLat)
            bundle.putString(GEO_LNG_KEY, userGeoLng)
            findNavController().navigate(
                R.id.action_userFragment_to_mapFragment,
                bundle
            )
        }

        binding?.btnSaveDb?.setOnClickListener {
            viewModel.saveToDBfromApi(userInfo)
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserFlow(postId).asLiveData(lifecycleScope.coroutineContext)
            .observe(viewLifecycleOwner, {
                when (it) {
                    is Outcome.Failure -> {
                        showError()
                    }

                    is Outcome.Progress -> {
                        if (it.loading) showProgress() else hideProgress()
                    }
                    is Outcome.Success -> {
                        showUserInfo(it.data)
                    }
                    else -> {
                        showError()
                    }
                }
            })
    }

    private fun showUserInfo(user: UserDto) {

        binding?.userId?.text = getString(R.string.contactId, user.id.toString())
        binding?.userName?.text = user.name
        binding?.nickname?.text = user.username
        binding?.userEmail?.text = user.email
        binding?.userWeb?.text = user.website
        urlWeb = user.website
        binding?.userPhone?.text = user.phone
        userPhone = user.phone
        binding?.userCity?.text = user.address.city
        userGeoLat = user.address.geo.lat
        userGeoLng = user.address.geo.lng

        userInfo = user

    }

    override fun showError() {
        hideProgress()
        activity?.showAlertDialog()
    }

    override fun showProgress() {
        binding?.progressBarUser?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding?.progressBarUser?.visibility = View.GONE
    }

}