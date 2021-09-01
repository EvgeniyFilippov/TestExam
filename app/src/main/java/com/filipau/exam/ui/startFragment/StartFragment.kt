package com.filipau.exam.ui.startFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.filipau.exam.R
import com.filipau.exam.base.mvvm.BaseMvvmView
import com.filipau.exam.databinding.FragmentStartBinding
import com.filipau.exam.ext.showAlertDialog

open class StartFragment : Fragment(R.layout.fragment_start), BaseMvvmView {

    private var binding: FragmentStartBinding? = null
    private val viewModel: StartViewModel = StartViewModel()
    private var tractor: AppCompatImageView? = null

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun showError() {
        activity?.showAlertDialog()
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

}