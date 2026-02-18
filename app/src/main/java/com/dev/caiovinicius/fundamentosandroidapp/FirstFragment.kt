package com.dev.caiovinicius.fundamentosandroidapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.dev.caiovinicius.fundamentosandroidapp.databinding.FragmentFirstBinding
import com.dev.caiovinicius.fundamentosandroidapp.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch
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
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                // id do drawable de dado
                uiState.rolledDice2ImgRes?.let { imgRes ->
                    binding.ivRolledDice2.setImageResource(imgRes)
                }
            }
        }
    }

}