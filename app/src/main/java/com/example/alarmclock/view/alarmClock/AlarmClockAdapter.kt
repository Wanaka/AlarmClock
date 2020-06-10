package com.example.alarmclock.view.alarmClock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.TimePicker
import androidx.recyclerview.widget.RecyclerView.*
import com.example.alarmclock.R
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.util.splitting
import com.example.alarmclock.view.alarmClock.AlarmClockAdapter.*


class AlarmClockAdapter(
    private val data: List<AlarmItem>,
    private val onItemClick: (id: Int, hour: Int, minute: Int, isOn: Boolean) -> Unit
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
        var id = data[position].id
        holder.time.text = data[position].alarm
        holder.switch.isChecked = data[position].isOn
        holder.timePicker.setIs24HourView(true)

        //-- Buttons --//
        holder.switch.setOnClickListener {
            var time = data[position].alarm.splitting()
            updateAlarmItem(id, time[0].toInt(), time[1].toInt(), holder.switch.isChecked)
        }

        holder.okBtn.setOnClickListener {
            updateAlarmItem(id, holder.timePicker.hour, holder.timePicker.minute, holder.switch.isChecked)
        }

        holder.view.setOnClickListener {
            setVisibility(holder.expandableView)
            setVisibility(holder.timePicker)
            setVisibility(holder.okBtn)
        }
    }


    private fun updateAlarmItem(id: Int, hour: Int, minute: Int, isOn: Boolean) =
        onItemClick.invoke(id, hour, minute, isOn)

    private fun setVisibility(holder: View) {
        holder.visibility =
            if (holder.visibility == View.VISIBLE) View.GONE
            else View.VISIBLE
    }

    fun deleteAlarmItem(position: Int) = data[position]


    //---------------------------------------------------------------------------//

    // holder class to hold reference
    inner class AlarmClockViewHolder(view: View) : ViewHolder(view) {
        var view: View = view.findViewById(R.id.alarmItemView) as View
        var expandableView: View = view.findViewById(R.id.expandableView) as View
        var time: TextView = view.findViewById(R.id.timeTxt) as TextView
        var switch: Switch = view.findViewById(R.id.alarmSwitch) as Switch
        var timePicker: TimePicker = view.findViewById(R.id.timePicker) as TimePicker
        var okBtn: Button = view.findViewById(R.id.okBtn) as Button
    }
}