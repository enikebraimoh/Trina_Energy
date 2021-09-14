package com.trina.energy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.findNavController
import com.google.android.material.appbar.AppBarLayout
import com.trina.energy.core.BaseFragment
import com.trina.energy.databinding.FragmentCctvBinding

class CctvFragment : BaseFragment<FragmentCctvBinding>(R.layout.fragment_cctv){

    override fun start() {
        super.start()
        coordinateMotion()
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