package com.rl.solar.browser.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.rl.solar.browser.viewmodels.PlanetDetailViewModel
import com.rl.solar.databinding.FragmentPlanetDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetDetailFragment : Fragment() {
    private lateinit var binding: FragmentPlanetDetailBinding
    private val viewModel by viewModels<PlanetDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPlanetDetailBinding.inflate(layoutInflater, container, false)

        val args: PlanetDetailFragmentArgs by navArgs()
        viewModel.loadPlanet(args.planetId)

        viewModel.planet.observe(viewLifecycleOwner) {
            binding.planet = it
        }

        return binding.root
    }
}
