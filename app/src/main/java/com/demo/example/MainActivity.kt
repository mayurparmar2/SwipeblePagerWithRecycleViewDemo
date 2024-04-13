package com.demo.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.demo.example.adapter.PagerStateAdapter


class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager;
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)


        viewPager = findViewById<ViewPager>(R.id.viewPager)
        val states: List<State> = getStates() // Assuming you have a method to retrieve state data

        val adapter = PagerStateAdapter(this, states)
        viewPager.setAdapter(adapter)
    }

    private fun getStates(): List<State> {
        val states: MutableList<State> = ArrayList()
        states.add(State("Custom State 1",generateCustomRTOs()))
        states.add(State("Custom State 2",generateCustomRTOs()))
        states.add(State("Custom State 3",generateCustomRTOs()))
        states.add(State("Custom State 4",generateCustomRTOs()))
        states.add(State("Custom State 5",generateCustomRTOs()))
        return states
    }


    // Method to generate custom RTOs
    private fun generateCustomRTOs(): List<RTO> {
        val customRTOs: MutableList<RTO> = ArrayList()
        // Add some RTOs with values
        customRTOs.add(RTO("RTO 1", "Address 1","99999 ","google.com"))
        customRTOs.add(RTO("RTO 2", "Address 2","99999 ","google.com"))
        customRTOs.add(RTO("RTO 3", "Address 3","99999 ","google.com"))
        // Add more RTOs as needed
        return customRTOs
    }

}