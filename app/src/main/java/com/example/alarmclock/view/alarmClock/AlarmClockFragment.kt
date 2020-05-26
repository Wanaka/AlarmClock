package com.example.alarmclock.view.alarmClock

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.alarmclock.R
import com.example.alarmclock.model.AlarmItem
import kotlinx.android.synthetic.main.fragment_alarm_clock.*

class AlarmClockFragment : Fragment() {

    private lateinit var viewModel: AlarmClockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
////            param1 = it.getString(ARG_PARAM1)
//        }

        viewModel = ViewModelProvider(this).get(AlarmClockViewModel::class.java)
        alarmClockList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alarm_clock, container, false)
    }

    private fun alarmClockList() {
        viewModel.alarmList.observe(this, Observer {
            alarmClockRecyclerView(it)
        })
    }

    private fun alarmClockRecyclerView(data: List<AlarmItem>) {
        alarmRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AlarmClockAdapter(data)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlarmClockFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
