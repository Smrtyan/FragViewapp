package com.example.ubnt.fragviewapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

class MyAdapter(context: Context, textViewResourceId: Int, objects: ArrayList<Item>) : ArrayAdapter<Item>(context, textViewResourceId, objects) {

    internal var countriesList = ArrayList<Item>()

    init {
        countriesList = objects
    }

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var v = convertView
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v = inflater.inflate(R.layout.list_view_items, null)
        val textView = v!!.findViewById<View>(R.id.textView) as TextView
        val imageView = v.findViewById<View>(R.id.imageView) as ImageView
        textView.text = countriesList[position].name
        imageView.setImageResource(countriesList[position].image)
        //set tag as country's name  for the viewGroup
        (textView.parent as ViewGroup).tag = textView.text
        return v

    }

}
