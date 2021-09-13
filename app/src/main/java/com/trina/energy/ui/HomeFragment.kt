package com.trina.energy.ui

import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.trina.energy.R
import com.trina.energy.core.BaseFragment
import com.trina.energy.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.tool_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_menu -> {
               findNavController().navigate(R.id.notificationFragment)
                true
            }
            else -> false
        }
    }

    override fun start() {
       setHasOptionsMenu(true)
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)
        val animation2 = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)
        val animation3 = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)
        binding.services1.setOnClickListener {
            binding.services1Parent.startAnimation(animation)
            findNavController().navigate(R.id.action_homeFragment_to_cctvFragment)
        }

        binding.services2.setOnClickListener {
            binding.services2Parent.startAnimation(animation2)
        }

        binding.services3.setOnClickListener {
            binding.services3Parent.startAnimation(animation3)
        }
    }
}