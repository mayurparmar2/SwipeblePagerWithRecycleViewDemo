package com.demo.example

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.example.adapter.Adapter_Contacts
import com.demo.example.adapter.CustomPagerAdapter
import com.demo.example.adapter.PagerStateAdapter
import kotlinx.android.synthetic.main.activity_main.searchEditText
import kotlinx.android.synthetic.main.activity_main.viewPager
import java.util.Locale


class MainActivity : AppCompatActivity() {
    companion object{

        lateinit var states: java.util.ArrayList<State>
//        lateinit var adapter: Adapter_Contacts
        lateinit var adapter: PagerStateAdapter
//        lateinit var adapter: CustomPagerAdapter
    }
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)


         states= getStates() // Assuming you have a method to retrieve state data
//         adapter = Adapter_Contacts(this, states)
         adapter = PagerStateAdapter(this, states)
//         adapter = CustomPagerAdapter(this, states)
        viewPager.setAdapter(adapter)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                filter(s.toString())
//                adapter.filterByName(s.toString());
                adapter.filter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun getStates(): java.util.ArrayList<State> {
        val states: java.util.ArrayList<State> = java.util.ArrayList<State>()
        states.add(State("gujrat",generateCustomRTOs()))
        states.add(State("maharstra",generateCustomRTOs()))
        states.add(State("up",generateCustomRTOs()))
        states.add(State("mp",generateCustomRTOs()))
        states.add(State("rajastan",generateCustomRTOs()))
        return states
    }


    // Method to generate custom RTOs
    private fun generateCustomRTOs(): ArrayList<RTO> {
        val customRTOs: ArrayList<RTO> = ArrayList()
        // Add some RTOs with values
        customRTOs.add(RTO("amreli", "Address 1","99999 ","google.com"))
        customRTOs.add(RTO("rajkot", "Address 2","99999 ","google.com"))
        customRTOs.add(RTO("amdavad", "Address 3","99999 ","google.com"))
        // Add more RTOs as needed
        return customRTOs
    }

    // Method to filter data based on search query
//    private fun filter(searchText: String) {
//        if(searchText.isEmpty()){
//            adapter.setStates(states)
//        }else{
//            val filteredStates: ArrayList<State> = ArrayList()
//            for (state in states) {
//
//
//
//            }
//            adapter.setStates(filteredStates) // Update the adapter with filtered data
//        }
//
//    }
    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<State> = ArrayList()

        // running a for loop to compare elements.
        for (item in states) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.name.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
//            adapter.setStates(filteredlist)
        }
    }


//    private fun filter(searchText: String) {
//        val filteredStates = ArrayList<State>()
//        for (state in states) {
//            val filteredState = State(
//                state.getName(),
//                ArrayList<RTO>()
//            ) // Create a new state with an empty list of RTOs
//
//            if (state.getName().toLowerCase().contains(searchText.toLowerCase())) {
//                // If state name matches, add it to the filtered list
//                filteredStates.add(state)
//            }
//            for (rto in state.getRtoList()) {
//                // Filter RTOs within the state
//                if (rto.name.lowercase(Locale.getDefault()).contains(searchText.toLowerCase())) {
//                    // If RTO name matches, add it to the filtered state
//                    filteredState.rtoList.add(rto)
//                }
//            }
//            if (!filteredState.rtoList.isEmpty()) {
//                // If filtered RTOs exist, add the state to the filtered list
//                filteredStates.add(filteredState)
//            }
////            // Filter state by name
////            if (state.name.lowercase(Locale.getDefault()).contains(searchText.lowercase(Locale.getDefault()))) {
////                // If state name matches, add it to the filtered list
////                filteredStates.add(state)
////            } else {
////                // If state name doesn't match, check RTO names
////                val filteredRTOs: MutableList<RTO> = ArrayList()
////                for (rto in state.rtoList) {
////                    if (rto.name.lowercase(Locale.getDefault()).contains(searchText.lowercase(Locale.getDefault()))) {
////                        // If RTO name matches, add the state to the filtered list and break the loop
////                        filteredRTOs.add(rto)
////                        break
////                    }
////                }
////                // If filtered RTOs exist, add the state to the filtered list
////                if (!filteredRTOs.isEmpty()) {
////                    val filteredState = State(state.name, filteredRTOs)
////                    filteredStates.add(filteredState)
////                }
////            }
//        }
//        adapter.setStates(filteredStates)
//    // Update the adapter with filtered data
//    }

}