package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

class SleepNightAdapter: ListAdapter<SleepNight, SleepNightAdapter.SleepNightViewHolder>(SleepNightDiffCallback())
{


    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {
        return SleepNightViewHolder.from(parent)
    }


    // inner class
    class SleepNightViewHolder private constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SleepNight) {
            binding.sleep = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): SleepNightViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                //val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent, false)
                //return SleepNightViewHolder(view)

                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return SleepNightViewHolder(binding)
            }
        }
    }

    class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
        override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem.nightId == newItem.nightId
        }

        override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem == newItem
        }
    }
}