package com.example.ubnt.fragviewapp

import android.content.Intent
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var mStackLevel = 0
    internal lateinit var simpleList: ListView
    internal lateinit var adapter: MyAdapter
    internal var countriesList = ArrayList<Item>()

    internal fun showDialog(v: View) {
        val country = (findViewById<View>(R.id.textView) as TextView).text as String
        val args = Bundle()
        args.putString("country", country)
        mStackLevel++

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)

        // Create and show the dialog.
        val newFragment = DeleteFragment.newInstance(mStackLevel)
        newFragment.arguments = args
        newFragment.show(ft, "dialog")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.my_listview)

        //     ArrayAdapter<Button> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,buttons);
        simpleList = findViewById<View>(R.id.my_listview) as ListView
        for (country in COUNTRIES) {
            countriesList.add(Item(country, resources.getIdentifier(country, "drawable", packageName)))
        }

        adapter = MyAdapter(this, R.layout.list_view_items, countriesList)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, detailedActivity::class.java)
            intent.putExtra("country", ((view as ViewGroup).findViewById<View>(R.id.textView) as TextView).text)
            startActivity(intent)
        }

        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, id ->
            //             DeleteDialog deleteDialog = new DeleteD
            showDialog(view)
            true
        }
    }

    fun updateListView(countryName: String) {
        val b = countriesList.remove(Item(countryName, resources.getIdentifier(countryName, "drawable", packageName)))
        Log.v("countryname", "" + b)
        adapter.notifyDataSetChanged()
    }

    companion object {

        private val COUNTRIES = arrayOf("afghanistan", "albania", "china", "chile", "colomia", "france", "germany", "finland", "costa_rica")
    }
}