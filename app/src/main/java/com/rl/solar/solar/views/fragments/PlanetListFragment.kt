package com.rl.solar.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rl.solar.databinding.FragmentPlanetListBinding
import com.rl.solar.viewmodels.PlanetListViewModel
import com.rl.solar.views.adapters.PlanetAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlanetListFragment : Fragment() {
    private lateinit var binding: FragmentPlanetListBinding
    private val viewModel: PlanetListViewModel by viewModels()

    @Inject
    lateinit var planetAdapter: PlanetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPlanetListBinding.inflate(layoutInflater, container, false)
        binding.planetList.adapter = planetAdapter

        viewModel.planets.observe(viewLifecycleOwner) {
            planetAdapter.submitList(it.sortedBy { planet -> planet.id })
        }

        return binding.root
    }
}
