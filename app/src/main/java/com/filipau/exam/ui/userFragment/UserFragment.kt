package com.filipau.exam.ui.userFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.filipau.exam.Constants.ERROR
import com.filipau.exam.Constants.ID_POST_KEY
import com.filipau.exam.R
import com.filipau.exam.base.mvvm.BaseMvvmView
import com.filipau.exam.databinding.FragmentUserBinding
import com.filipau.exam.ui.startFragment.StartViewModel
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

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

}