package com.dev.caiovinicius.fundamentosandroidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.caiovinicius.fundamentosandroidapp.databinding.ItemRolledDicesBinding

data class RolledDices(
    val dice1: Int,
    val dice2: Int,
    val dice3: Int
)

class RolledDicesAdapter(private val rolledDicesList: List<RolledDices>) : RecyclerView.Adapter<RolledDicesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRolledDicesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(playNumber: Int, rolledDice: RolledDices) {
            with(binding) {
                tvRolledDiceNumber.text = playNumber.toString()
                ivRolledDice1.setImageResource(getDiceImageResource(rolledDice.dice1))
                ivRolledDice2.setImageResource(getDiceImageResource(rolledDice.dice2))
                ivRolledDice3.setImageResource(getDiceImageResource(rolledDice.dice3))
            }
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemRolledDicesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(position + 1, rolledDicesList[position])
    }

    override fun getItemCount(): Int {
        return rolledDicesList.size

    }

}