package com.example.alarmclock.view.alarmClock

import android.graphics.Canvas
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmclock.R
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.util.Swipe
import kotlinx.android.synthetic.main.fragment_alarm_clock.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class AlarmClockFragment : Fragment() {

    private val viewModel by viewModel<AlarmClockViewModel>()
    private val swipe: Swipe by inject()
    lateinit var alarmClockAdapter: AlarmClockAdapter
    private lateinit var onItemClick: (alarmItem: AlarmItem) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        alarmClockList()
        updateList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alarm_clock, container, false)
    }

    private fun alarmClockList() {
        viewModel.getList.observe(this, Observer {
            alarmClockRecyclerView(it)
        })
    }

    private fun alarmClockRecyclerView(data: List<AlarmItem>) {
        alarmRecyclerView.apply {
            alarmClockAdapter = AlarmClockAdapter(data, onItemClick)
            layoutManager = LinearLayoutManager(context)
            adapter = alarmClockAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        swipe()
    }

    private fun updateList() {
        onItemClick = { alarmItem ->
            viewModel.update(alarmItem)
        }
    }

    private fun swipe() {
        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(vH: RecyclerView.ViewHolder, position: Int) {
                    val alarmItem = alarmClockAdapter.getAlarmItem(vH.adapterPosition)
                    viewModel.delete(alarmItem)
                }

                override fun onChildDraw(
                    c: Canvas,
                    rV: RecyclerView,
                    vH: RecyclerView.ViewHolder,
                    dX: Float,
                    dY: Float,
                    aS: Int,
                    isCurrentlyActive: Boolean
                ) {
                    context?.let { swipe.drawDelete(it, c, vH) }
                    super.onChildDraw(c, rV, vH, dX, dY, aS, isCurrentlyActive)
                }
            }

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(alarmRecyclerView)
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
