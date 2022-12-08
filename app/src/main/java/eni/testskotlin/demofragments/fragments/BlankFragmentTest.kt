package eni.testskotlin.demofragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import eni.testskotlin.R
import eni.testskotlin.databinding.FragmentBlankBinding
import eni.testskotlin.databinding.FragmentBlankTestBinding


class BlankFragmentTest : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val amb = DataBindingUtil.inflate<FragmentBlankTestBinding>(inflater, R.layout.fragment_blank_test, container, false)
        val args = arguments?.let { eni.testskotlin.demofragments.fragments.BlankFragmentTestArgs.fromBundle(it) }
        amb.txt2.text = args?.myuser.toString()
        return amb.root
    }
}