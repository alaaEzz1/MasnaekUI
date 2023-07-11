package com.elmohandes.masnaekscreens.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.SpinnerAdapter
import com.elmohandes.masnaekscreens.databinding.FragmentFixRequestBinding
import com.elmohandes.masnaekscreens.models.MainCategoryModel


class FixRequestFragment : Fragment() {

    lateinit var categoryList:List<MainCategoryModel>
    lateinit var spinnerAdapter: SpinnerAdapter
    lateinit var binding: FragmentFixRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fix_request, container, false)
        binding = FragmentFixRequestBinding.bind(view)

        categoryList = listOf(
            MainCategoryModel(
                "https://i.pinimg.com/564x/ad/6f/68/ad6f68aa3780157d5adf42bcc0bd9c9b.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/77/45/16/77451635c04184dcb239b89accbf1687.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/a6/10/59/a6105921aa346f84aa4ae78d18498874.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/ee/33/4d/ee334d5380519010f831290210deb949.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/4c/66/ca/4c66ca60c092015d462a066b8dcb0054.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/62/8f/f5/628ff5a2b9987c739408a7d7646805e6.jpg",
            ),
        )
        spinnerAdapter = SpinnerAdapter(categoryList, requireContext())
        binding.fixReqSpinner.adapter = spinnerAdapter

        return view
    }

}