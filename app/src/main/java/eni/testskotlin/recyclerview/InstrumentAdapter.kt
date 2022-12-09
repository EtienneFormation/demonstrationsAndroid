package eni.testskotlin.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eni.testskotlin.databinding.RecyclerLineBinding
import eni.testskotlin.recyclerview.bo.Instrument

class InstrumentAdapter(val instruments: ArrayList<Instrument>, val click: (Instrument) -> Unit) : RecyclerView.Adapter<InstrumentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = instruments[position]
        holder.binding.root.setOnClickListener{click(item)}
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return instruments.size
    }

    class ViewHolder private constructor(val binding: RecyclerLineBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Instrument) {
            Log.i("Etienne", "Passage dans le bind")
            binding.instr = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerLineBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}