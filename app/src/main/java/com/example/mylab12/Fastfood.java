package com.example.mylab12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Fastfood extends AppCompatActivity {
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood);
        dataList=findViewById(R.id.dataList);

        titles=new ArrayList<>();
        images=new ArrayList<>();

        titles.add("Pizza");
        titles.add("Garlic Bread");
        titles.add("Burger");
        titles.add("Milk Shake");
        titles.add("Pastry");
        titles.add("Ice Cream");
        titles.add("Tacos");
        titles.add("Donuts");


        images.add(R.drawable.img1);
        images.add(R.drawable.img2);
        images.add(R.drawable.img3);
        images.add(R.drawable.img4);
        images.add(R.drawable.img5);
        images.add(R.drawable.img6);
        images.add(R.drawable.img7);
        images.add(R.drawable.img8);

        adapter=new Adapter(this,titles,images);

        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        View parentLayout = findViewById(android.R.id.content);
        switch (item.getItemId()) {
            case R.id.search:
                Snackbar snackbar = Snackbar.make(parentLayout,"Searching",Snackbar.LENGTH_SHORT);
                snackbar.show();
                return true;
            case R.id.fav:
                Snackbar snackbar1 = Snackbar.make(parentLayout,"Added to your favourites",Snackbar.LENGTH_SHORT);
                snackbar1.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        MenuItem menuItem=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}