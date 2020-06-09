package com.example.alarmclock.view.alarmClock

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.TimePicker
import androidx.recyclerview.widget.RecyclerView.*
import com.example.alarmclock.R
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.view.alarmClock.AlarmClockAdapter.*


class AlarmClockAdapter(
    private val data: List<AlarmItem>,
    private val onItemClick: (alarmItem: AlarmItem) -> Unit
) :
    Adapter<AlarmClockViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmClockViewHolder {
        // create view holder to hold reference
        return AlarmClockViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.alarm_clock_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlarmClockViewHolder, position: Int) {
        //set values
        holder.time.text = data[position].alarm
        holder.switch.isChecked = data[position].isOn
        holder.timePicker.setIs24HourView(true)

        holder.view.setOnClickListener {
            setVisibility(holder.expandableView)
            setVisibility(holder.timePicker)
        }

        holder.switch.setOnClickListener {
            onItemClick.invoke(AlarmItem(data[position].alarm, holder.switch.isChecked))
        }
    }

    private fun setVisibility(holder: View) {
        holder.visibility =
            if (holder.visibility == View.VISIBLE) View.GONE
            else View.VISIBLE
    }

    fun getAlarmItem(position: Int) = data[position]


    //---------------------------------------------------------------------------//

    // holder class to hold reference
    inner class AlarmClockViewHolder(view: View) : ViewHolder(view) {
        var view: View = view.findViewById(R.id.alarmItemView) as View
        var expandableView: View = view.findViewById(R.id.expandableView) as View
        var time: TextView = view.findViewById(R.id.timeTxt) as TextView
        var switch: Switch = view.findViewById(R.id.alarmSwitch) as Switch
        var timePicker: TimePicker = view.findViewById(R.id.timePicker) as TimePicker
    }
}