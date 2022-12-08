package eni.testskotlin.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import eni.testskotlin.R
import eni.testskotlin.databinding.FragmentLiveDataBinding

class LiveDataFragment : Fragment() {
    private lateinit var viewModel: CompteurVM
    private lateinit var binding : FragmentLiveDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live_data, container, false)
        viewModel = ViewModelProvider(this)[CompteurVM::class.java]
        // le "viewLivecycleOwner" permet d'indiquer a l'observer le cycle de vie du fragment
        // de cette maniere, si le fragment est cache, l'observer n'est pas trigger
        // lorsque le fragment revient au premier plan, il recupere les infos les plus recentes
        viewModel.cpt.observe(viewLifecycleOwner, Observer { binding.vm = viewModel})
        binding.btnIncr.setOnClickListener{
            viewModel.plusUn()
            //binding.tvCpt.text = viewModel.cpt.toString()
        }
        //binding.tvCpt.text = viewModel.cpt.toString()
        return binding.root
    }
}