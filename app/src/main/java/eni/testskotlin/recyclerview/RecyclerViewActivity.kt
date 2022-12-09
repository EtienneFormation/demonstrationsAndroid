package eni.testskotlin.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import eni.testskotlin.R
import eni.testskotlin.databinding.ActivityRecyclerViewBinding
import eni.testskotlin.recyclerview.bo.Instrument

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityRecyclerViewBinding>(this, R.layout.activity_recycler_view)

        val model = InstrumentVM()
        binding.model = model
        binding.lifecycleOwner = this

        binding.rvDemo.adapter = InstrumentAdapter(model.instruments, ::onclick)
    }

    private fun onclick(instrument: Instrument) {
        Toast.makeText(this, instrument.toString(), Toast.LENGTH_LONG).show()
    }
}