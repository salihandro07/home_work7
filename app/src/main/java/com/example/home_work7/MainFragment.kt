package com.example.home_work7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.home_work7.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cars = listOf(
            Car("Tesla Model S", "https://example.com/tesla.jpg", "+123456789"),
            Car("BMW M3", "https://example.com/bmw.jpg", "+987654321"),
            Car("Audi R8", "https://example.com/audi.jpg", "+1122334455")
        )

        val adapter = CarAdapter(cars) { car ->
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(car.name, car.phoneNumber)
            findNavController().navigate(action)
        }

        binding.recyclerViewCars.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCars.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
