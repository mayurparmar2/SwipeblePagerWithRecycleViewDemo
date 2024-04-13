package com.demo.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.demo.example.R
import com.demo.example.State


class PagerStateAdapter(private val context: Context, states: List<State>) :
    PagerAdapter() {
    private val states: List<State>
    private val layoutInflater: LayoutInflater

    init {
        this.states = states
        layoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return states.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.item_state, container, false)
        val stateNameTextView = view.findViewById<TextView>(R.id.stateName)
        val rtoRecyclerView = view.findViewById<RecyclerView>(R.id.rtoRecyclerView)
        val state: State = states[position]
        stateNameTextView.setText(state.name)
        val rtoAdapter = RecycleViewStateAdapter(context, state)
        rtoRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rtoRecyclerView.adapter = rtoAdapter
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}

