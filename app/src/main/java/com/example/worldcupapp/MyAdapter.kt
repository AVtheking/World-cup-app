package com.example.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class MyAdapter(private  var activity: Activity,private var items:ArrayList<model>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View?
       val viewholder:ViewHolder
       if(convertView==null)
       {
           val inflator=activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
       //dynamic way of defining ui0
           view=inflator.inflate(R.layout.list_item,null)
           viewholder= ViewHolder(view)
           view?.tag=viewholder

       }
        else
       {
           view=convertView
           viewholder=view.tag as ViewHolder
       }
        var countries=items[position]
        viewholder.txtname?.text=countries.name
        viewholder.cupwin?.text=countries.cupWins
        viewholder.flagimg?.setImageResource(countries.flag_img)
        view?.setOnClickListener()
        {
            Toast.makeText(activity,"You choose:${countries.name}",Toast.LENGTH_LONG).show()
        }
        return view as View


    }
    private class ViewHolder(row:View?)
    {
        var txtname:TextView?=null
        var cupwin:TextView?=null
        var flagimg:ImageView?=null
        init {
            this.txtname=row?.findViewById(R.id.textView)
            this.cupwin=row?.findViewById(R.id.textView2)
            this.flagimg=row?.findViewById(R.id.img)
        }
    }
}