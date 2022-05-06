package com.rl.solar.browser.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.rl.solar.R
import com.rl.solar.browser.views.fragments.PlanetListFragmentDirections
import com.rl.solar.databinding.ListItemPlanetBinding
=======
>>>>>>> main
import com.rl.solar.core.Planet
import com.rl.solar.databinding.ListItemPlanetBinding

class PlanetAdapter(
  val onItemClicked: (item: Planet) -> Unit
) : ListAdapter<Planet, RecyclerView.ViewHolder>(PlanetDiffCallback()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val binding = ListItemPlanetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return PlanetViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    getItem(position)?.let { planet ->
      (holder as PlanetViewHolder).bind(planet)
    }
  }

<<<<<<< HEAD
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
=======
  inner class PlanetViewHolder(
    private val binding: ListItemPlanetBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    init {
      binding.setClickListener {
        binding.planet?.let { planet ->
          onItemClicked(planet)
        }
      }
    }

    fun bind(item: Planet) {
      binding.apply {
        planet = item
        executePendingBindings()
      }
>>>>>>> main
    }
  }
}

private class PlanetDiffCallback : DiffUtil.ItemCallback<Planet>() {
  override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean =
    oldItem.id == newItem.id
  override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean =
    oldItem == newItem
}
