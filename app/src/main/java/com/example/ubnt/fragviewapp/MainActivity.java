package com.example.ubnt.fragviewapp;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int mStackLevel = 0;

    void showDialog(View v) {
        String country  = (String) ((TextView)findViewById(R.id.textView)).getText();
        Bundle args = new Bundle();
        args.putString("country",country);
        mStackLevel++;

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = DeleteFragment.newInstance(mStackLevel);
        newFragment.setArguments(args);
        newFragment.show(ft,"dialog");

    }
    ListView simpleList;
    MyAdapter adapter;
    ArrayList<Item> countriesList=new ArrayList<>();

    private static final String[] COUNTRIES = {
            "afghanistan",
            "albania",
            "china",
            "chile",
            "colomia",
            "france",
            "germany",
            "finland",
            "costa_rica"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.my_listview);

  //     ArrayAdapter<Button> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,buttons);
        simpleList = (ListView) findViewById(R.id.my_listview);
        for (String country : COUNTRIES){
            countriesList.add(new Item(country, getResources().getIdentifier(country,"drawable",getPackageName())));
        }

        adapter=new MyAdapter(this,R.layout.list_view_items,countriesList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,detailedActivity.class);
                intent.putExtra("country",((TextView)((ViewGroup)view).findViewById(R.id.textView)).getText());
                startActivity(intent);
            }
        });

     listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//             DeleteDialog deleteDialog = new DeleteD
             showDialog(view);
             return true;
         }
     });
    }
    public void updateListView(String countryName){
        boolean b = countriesList.remove(new Item(countryName, getResources().getIdentifier(countryName,"drawable",getPackageName())));
        Log.v("countryname",""+b);
        adapter.notifyDataSetChanged();
    }
}