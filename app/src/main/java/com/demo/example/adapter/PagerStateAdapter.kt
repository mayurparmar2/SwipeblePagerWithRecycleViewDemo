package com.demo.example.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.demo.example.R
import com.demo.example.State
import java.util.Locale

class PagerStateAdapter(private val context: Context, private var allStates: ArrayList<State>) : PagerAdapter(), Filterable {
    private var filteredStates: ArrayList<State> = allStates // Initially, both lists are the same
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return filteredStates.size // Use the filtered list size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.item_state, container, false)
        val stateNameTextView = view.findViewById<TextView>(R.id.stateName)
        val rtoRecyclerView = view.findViewById<RecyclerView>(R.id.rtoRecyclerView)
        val state: State = filteredStates[position] // Use filtered list
        stateNameTextView.text = state.name
        val rtoAdapter = RecycleViewStateAdapter(context, state)
        rtoRecyclerView.adapter = rtoAdapter
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val str = constraint.toString().uppercase(Locale.getDefault())
                Log.e("constraint", str)
                val results = FilterResults()
                if (constraint != null && constraint.length > 0) {
                    val filterList = java.util.ArrayList<State>()
                    for (i in filteredStates.indices) {
                        if (filteredStates.get(i).name.uppercase(Locale.getDefault())
                                .contains(constraint.toString().uppercase(Locale.getDefault()))
                        ) {
                            val bean_contacts: State = filteredStates.get(i)
                            filterList.add(bean_contacts)
                        }
                    }
                    results.count = filterList.size
                    results.values = filterList
                } else {
                    results.count = filteredStates.size
                    results.values = filteredStates
                }
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                allStates = results.values as java.util.ArrayList<State>
                notifyDataSetChanged()
            }
        }

    }


//    override fun getFilter(): Filter {
//        if (valueFilter == null) {
//            valueFilter = ValueFilter()
//        }
//        return valueFilter as ValueFilter
//    }






//    // Implementing the filter function
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val filteredList = ArrayList<State>()
//                if (constraint.isNullOrEmpty()) {
//                    filteredList.addAll(allStates)
//                } else {
//                    val filterPattern = constraint.toString().toLowerCase().trim()
//                    for (state in allStates) {
//                        if (state.name.toLowerCase().contains(filterPattern)) {
//                            filteredList.add(state)
//                        }
//                    }
//                }
//                val results = FilterResults()
//                results.values = filteredList
//                return results
//            }
//
//            @Suppress("UNCHECKED_CAST")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                filteredStates.clear()
//                filteredStates.addAll(results?.values as ArrayList<State>)
//                notifyDataSetChanged()
//            }
//        }
//    }
}


//class PagerStateAdapter(private val context: Context, private var allStates: ArrayList<State>) : PagerAdapter() ,
//    Filterable {
//    private var states: ArrayList<State> = allStates
//
////    private var states: ArrayList<State>
//    private val layoutInflater: LayoutInflater
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
//        val stateNameTextView = view.findViewById<TextView>(R.id.stateName)
//        val rtoRecyclerView = view.findViewById<RecyclerView>(R.id.rtoRecyclerView)
//        val state: State = states[position]
//        stateNameTextView.setText(state.name)
//        val rtoAdapter = RecycleViewStateAdapter(context, state)
//        rtoRecyclerView.adapter = rtoAdapter
//        container.addView(view)
//        return view
//    }
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View)
//    }
//    // Implementing the filter function
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val filteredList = ArrayList<State>()
//                if (constraint.isNullOrEmpty()) {
//                    filteredList.addAll(allStates)
//                } else {
//                    val filterPattern = constraint.toString().toLowerCase().trim()
//                    for (state in allStates) {
//                        if (state.name.toLowerCase().contains(filterPattern)) {
//                            filteredList.add(state)
//                        }
//                    }
//                }
//                val results = FilterResults()
//                results.values = filteredList
//                return results
//            }
//
//            @Suppress("UNCHECKED_CAST")
//                override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                states.clear()
//                states.addAll(results?.values as ArrayList<State>)
//                notifyDataSetChanged()
//            }
//        }
//    }
//
//}
//



//fun setStates(filteredStates: ArrayList<State>) {
////        this.states = filteredStates
//    this.states.clear();
//    this.states.addAll(filteredStates);
//
//    notifyDataSetChanged()
//}

//    fun setStates(filteredStates: List<State>) {
//        states = filteredStates
//        notifyDataSetChanged() // Notify adapter about the dataset change
//    }
