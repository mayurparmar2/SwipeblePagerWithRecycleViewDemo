package com.demo.example.adapter

import android.animation.LayoutTransition
import android.content.Context
import android.transition.AutoTransition
import android.transition.Transition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.demo.example.RTO
import com.demo.example.State


class RecycleViewStateAdapter(val context: Context, rtoList: State) :
    RecyclerView.Adapter<RecycleViewStateAdapter.RTOViewHolder>() {
    private val rtoList: List<RTO>

    init {
        this.rtoList = rtoList.rtoList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RTOViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(com.demo.example.R.layout.item_rto, parent, false)
        return RTOViewHolder(view)
    }

    override fun onBindViewHolder(holder: RTOViewHolder, position: Int) {
        holder.rtoName.setText(rtoList[position].name)
        holder.rtoAddress.setText(rtoList[position].address)
        holder.rtoPhone.setText(rtoList[position].phone)
        holder.rtoWebsite.setText(rtoList[position].website)
    }

    override fun getItemCount(): Int {
        return rtoList.size
    }

    class RTOViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rtoName: TextView
        var expandCollapseIcon: ImageView
//        var expandableListAdapter: com.demo.example.adapter.ExpandableListAdapter
        var rtoAddress: TextView
        var rtoPhone: TextView
        var rtoWebsite: TextView
        var cardView: CardView
        var hideConstraint: ConstraintLayout

        init {
            rtoName = itemView.findViewById<TextView>(com.demo.example.R.id.rtoName)
            expandCollapseIcon = itemView.findViewById<ImageView>(com.demo.example.R.id.expandCollapseIcon)
            cardView = itemView.findViewById<CardView>(com.demo.example.R.id.cardView)
            hideConstraint = itemView.findViewById<ConstraintLayout>(com.demo.example.R.id.hideConstraint)

            hideConstraint.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

            cardView.setOnClickListener(View.OnClickListener {
                val i = if (hideConstraint.getVisibility() == View.GONE) View.VISIBLE else View.GONE
                TransitionManager.beginDelayedTransition(hideConstraint,AutoTransition());
                hideConstraint.visibility = i
            })
            rtoAddress = itemView.findViewById<TextView>(com.demo.example.R.id.rtoAddress)
            rtoPhone = itemView.findViewById<TextView>(com.demo.example.R.id.rtoPhone)
            rtoWebsite = itemView.findViewById<TextView>(com.demo.example.R.id.rtoWebsite)
        }
    }
}


//class RecycleViewStateAdapter(private val context: Context, states: List<State>) : PagerAdapter() {
//    private val states: List<State>
//    private val layoutInflater: LayoutInflater
//
//    init {
//        this.states = states
//        layoutInflater = LayoutInflater.from(context)
//    }
//
//    override fun getCount(): Int {
//        return states.size
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view === `object`
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val view: View = layoutInflater.inflate(R.layout.item_state, container, false)
//        val textView = view.findViewById<TextView>(R.id.stateName)
//        textView.setText(states[position].name)
//        container.addView(view)
//        return view
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View)
//    }
//}

