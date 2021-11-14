package com.rl.solar.browser.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rl.solar.R
import com.rl.solar.browser.views.fragments.PlanetListFragmentDirections
import com.rl.solar.databinding.ListItemPlanetBinding
import com.rl.solar.core.Planet
import javax.inject.Inject

class PlanetAdapter @Inject constructor() : ListAdapter<Planet, RecyclerView.ViewHolder>(
    PlanetDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlanetViewHolder(
            ListItemPlanetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val planet = getItem(position)
        (holder as PlanetViewHolder).bind(planet)
    }

    class PlanetViewHolder(
        private val binding: ListItemPlanetBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                navigateToPlanet(binding.planet, it)
            }
        }

        fun bind(item: Planet) {
            binding.apply {
                planet = item
                executePendingBindings()
            }
        }

        private fun navigateToPlanet(planet: Planet?, view: View) {
            if (planet == null) return
            val destination = PlanetListFragmentDirections
                .actionPlanetListFragmentToPlanetDetailFragment(planet.id)
            view.findNavController().navigate(destination)
        }
    }
}

private class PlanetDiffCallback : DiffUtil.ItemCallback<Planet>() {
    override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean =
        oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean =
        oldItem == newItem
}
