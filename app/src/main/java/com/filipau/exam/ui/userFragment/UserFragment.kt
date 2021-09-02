package com.filipau.exam.ui.userFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.filipau.domain.outcome.Outcome
import com.filipau.exam.Constants.ERROR
import com.filipau.exam.Constants.ID_POST_KEY
import com.filipau.exam.R
import com.filipau.exam.base.mvvm.BaseMvvmView
import com.filipau.exam.databinding.FragmentUserBinding
import com.filipau.exam.ui.startFragment.StartViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class UserFragment : ScopeFragment(R.layout.fragment_user), BaseMvvmView {

    private var binding: FragmentUserBinding? = null
    private lateinit var postId: String
    private val viewModel: UserViewModel by stateViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        postId = arguments?.getString(ID_POST_KEY) ?: ERROR
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNewsFlow(postId).asLiveData(lifecycleScope.coroutineContext)
            .observe(viewLifecycleOwner, {
                when (it) {
                    is Outcome.Failure -> {
                        showError()
                    }

                    is Outcome.Progress -> {
                        if (it.loading) showProgress() else hideProgress()
                    }
                    is Outcome.Success -> {
                        Log.d("kuku", it.toString())
//                        showNews(it.data.toMutableList())
                    }
                    else -> {
                        showError()
                    }
                }
            })
    }

    override fun showError() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

}