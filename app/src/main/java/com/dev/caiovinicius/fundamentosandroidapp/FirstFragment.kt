package com.dev.caiovinicius.fundamentosandroidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.dev.caiovinicius.fundamentosandroidapp.databinding.FragmentFirstBinding
import com.dev.caiovinicius.fundamentosandroidapp.databinding.FragmentSecondBinding
import kotlin.getValue

class FirstFragment : Fragment() {

    private val viewModel: DiceViewModel by activityViewModels()
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

}