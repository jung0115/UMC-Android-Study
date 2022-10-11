package com.bicontest.umc_week3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bicontest.umc_week3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var viewBinding: FragmentFirstBinding // viewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFirstBinding.inflate(layoutInflater);
        return viewBinding.root
    }
}