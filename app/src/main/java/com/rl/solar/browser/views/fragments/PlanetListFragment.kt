package com.rl.solar.browser.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rl.solar.browser.viewmodels.PlanetListViewModel
import com.rl.solar.browser.views.adapters.PlanetAdapter
import com.rl.solar.core.Planet
import com.rl.solar.databinding.FragmentPlanetListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetListFragment : Fragment() {
  private lateinit var binding: FragmentPlanetListBinding

  private val adapter = PlanetAdapter(::onPlanetClicked)
  private val viewModel: PlanetListViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)

    binding = FragmentPlanetListBinding.inflate(layoutInflater, container, false).apply {
      planetList.adapter = adapter
    }

    viewModel.planets.observe(viewLifecycleOwner) {
      adapter.submitList(it.sortedBy { planet -> planet.id })
    }

    return binding.root
  }

  private fun onPlanetClicked(planet: Planet) {
    Toast.makeText(requireContext(), planet.name, Toast.LENGTH_SHORT).show()
  }
}
