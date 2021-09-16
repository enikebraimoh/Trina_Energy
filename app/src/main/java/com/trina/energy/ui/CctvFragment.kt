package com.trina.energy.ui

import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout
import com.trina.energy.R
import com.trina.energy.core.BaseFragment
import com.trina.energy.databinding.FragmentCctvBinding

class CctvFragment : BaseFragment<FragmentCctvBinding>(R.layout.fragment_cctv){

    override fun start() {
        super.start()
        coordinateMotion()
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.callForYours.setOnClickListener {
            binding.callForYours.startAnimation(animation)
        }
    }

    private fun coordinateMotion() {
        val appBarLayout = binding.appbarLayout
        val motionLayout = binding.motionLayout

        val listener = AppBarLayout.OnOffsetChangedListener { unused, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition
        }

        appBarLayout.addOnOffsetChangedListener(listener)
    }

}