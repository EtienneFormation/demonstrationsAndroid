package eni.testskotlin.demofragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import eni.testskotlin.R
import eni.testskotlin.databinding.FragmentBlank2Binding
import eni.testskotlin.databinding.FragmentBlankBinding
import eni.testskotlin.databinding.FragmentBlankTestBinding


class BlankFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val amb = DataBindingUtil.inflate<FragmentBlank2Binding>(inflater, R.layout.fragment_blank2, container, false)
        val args = arguments?.let { eni.testskotlin.demofragments.fragments.BlankFragment2Args.fromBundle(it) }
        amb.txt1.text = args?.nom
        return amb.root
    }
}