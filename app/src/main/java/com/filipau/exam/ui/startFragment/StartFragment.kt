package com.filipau.exam.ui.startFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.outcome.Outcome
import com.filipau.exam.R
import com.filipau.exam.adapter.AdapterPosts
import com.filipau.exam.base.mvvm.BaseMvvmView
import com.filipau.exam.databinding.FragmentStartBinding
import com.filipau.exam.ext.showAlertDialog
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import androidx.recyclerview.widget.GridLayoutManager
import io.reactivex.rxjava3.disposables.CompositeDisposable


open class StartFragment : ScopeFragment(R.layout.fragment_start), BaseMvvmView {

    private var binding: FragmentStartBinding? = null
    private val viewModel: StartViewModel by stateViewModel()
    private var tractor: AppCompatImageView? = null
    var adapterPosts = AdapterPosts()
    private val mCompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tractor = binding?.tractor

        binding?.btnSaveLogcat?.setOnClickListener {
            context?.let { it1 -> viewModel.writeLogCat(it1) }
        }

        tractor = binding?.tractor
        tractor?.alpha = .0f
        tractor?.animate()
            ?.setDuration(5000)
            ?.alpha(1f)
            ?.withEndAction { binding?.btnSaveLogcat?.visibility = View.VISIBLE }
            ?.start()

        viewModel.allPostsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Outcome.Progress -> {
                    if (it.loading) showProgress() else hideProgress()
                }
                is Outcome.Failure -> {
                    showError()
                }
                is Outcome.Success -> {
                    showCountries(it.data)
                }

                else -> {

                }
            }
        }

        viewModel.getPostsFromApi()
        binding?.recyclerView?.setHasFixedSize(true)
//        binding?.recyclerView?.layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.HORIZONTAL, false)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerView?.adapter = adapterPosts

    }

    private fun showCountries(listPostsFromApiDto: MutableList<PostItemDto>) {
        adapterPosts.repopulate(
            listPostsFromApiDto
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        mCompositeDisposable.clear()
    }

    override fun showError() {
        hideProgress()
        activity?.showAlertDialog()
    }

    override fun showProgress() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding?.progressBar?.visibility = View.GONE
    }

}