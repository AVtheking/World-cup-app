package com.example.worldcupapp

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listview=findViewById<ListView>(R.id.listview)

        var adapter=MyAdapter(this,generatedata())
        listview?.adapter=adapter
        adapter?.notifyDataSetChanged()
    }
    fun generatedata():ArrayList<model>{
        var result=ArrayList<model>()
        var country1:model=model("Brazil","5",R.drawable.brazil)
        var country2:model=model("Germany","4",R.drawable.germany)
        var country3:model=model("France","2",R.drawable.france)
        var country4:model=model("Spain","1",R.drawable.spain)
        var country5:model=model("England","1",R.drawable.unitedkingdom)
        var country6:model=model("United States","0",R.drawable.unitedstates)
        var country7:model=model("Saudi Arabia","0",R.drawable.saudiarabia)
        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)
        result.add(country5)
        result.add(country6)
        result.add(country7)
        return result
    }
}