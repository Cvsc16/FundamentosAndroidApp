package com.dev.caiovinicius.fundamentosandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.dev.caiovinicius.fundamentosandroidapp.databinding.DialogFragmentConfirmBinding
import kotlinx.coroutines.launch
import kotlin.getValue

class ConfirmDialogFragment: DialogFragment() {

    private val viewModel: DiceViewModel by activityViewModels()
    private var _binding: DialogFragmentConfirmBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogFragmentConfirmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            viewModel.rollDice()
            dismiss()
        }
    }
}