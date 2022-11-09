package com.bicontest.umc_week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bicontest.umc_week6.databinding.FragmentBlueHeartBinding

class BlueHeartFragment : Fragment() {
    private lateinit var viewBinding : FragmentBlueHeartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBlueHeartBinding.inflate(layoutInflater);

        return viewBinding.root
    }
}