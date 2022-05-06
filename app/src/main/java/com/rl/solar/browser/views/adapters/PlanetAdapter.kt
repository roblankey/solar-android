package com.rl.solar.browser.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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

  inner class PlanetViewHolder(
    private val binding: ListItemPlanetBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    init {
      binding.planetListCard.setOnClickListener {
        binding.planet?.let { planet ->
          onItemClicked(planet)
        }
      }

      binding.planetItemImage.setOnClickListener {
        binding.planetListCard.performClick()
      }

      binding.plantItemTitle.setOnClickListener {
        binding.planetListCard.performClick()
      }
    }

    fun bind(item: Planet) {
      binding.apply {
        planet = item
        executePendingBindings()
      }
    }
  }
}

private class PlanetDiffCallback : DiffUtil.ItemCallback<Planet>() {
  override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean =
    oldItem.id == newItem.id
  override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean =
    oldItem == newItem
}
