package eni.testskotlin.demofragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import eni.testskotlin.R
import eni.testskotlin.demofragments.bo.Utilisateur
import eni.testskotlin.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentBlankBinding>(inflater, R.layout.fragment_blank, container, false)

        binding.btnFrag1.setOnClickListener{
            val action =
                BlankFragmentDirections.actionBlankFragmentToBlankFragment2(
                    123,
                    "test"
                )
            Navigation.findNavController(it).navigate(action)
        }
        binding.btnFrag2.setOnClickListener {
            val action =
                BlankFragmentDirections.actionBlankFragmentToBlankFragmentTest(
                    Utilisateur("cassin", "etienne", 30)
                )
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }
}