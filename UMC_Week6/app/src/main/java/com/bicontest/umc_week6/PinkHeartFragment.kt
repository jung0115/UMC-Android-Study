package com.bicontest.umc_week6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bicontest.umc_week6.databinding.FragmentPinkHeartBinding

class PinkHeartFragment : Fragment() {
    private lateinit var viewBinding : FragmentPinkHeartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPinkHeartBinding.inflate(layoutInflater);

        return viewBinding.root
    }
}