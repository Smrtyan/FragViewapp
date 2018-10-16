package com.example.ubnt.fragviewapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView simpleList;
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

        MyAdapter adapter=new MyAdapter(this,R.layout.list_view_items,countriesList);
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
             return true;
         }
     });
    }
}