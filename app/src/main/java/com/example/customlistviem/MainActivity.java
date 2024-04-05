package com.example.customlistviem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String fruitList[] ={"Apple", "Banana", "Apricot", "Orange", "Water Melon"};
    int fruitImages[] = {R.drawable.apple, R.drawable.banana,R.drawable.apricot, R.drawable.orange, R.drawable.water_melon};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent login = new Intent(this, LoginActivity.class);
        //startActivity(login);

        listView =(ListView) findViewById(R.id.customListView);
        CustomBaseAdapetr customBaseAdapetr= new CustomBaseAdapetr(getApplicationContext(),fruitList, fruitImages);
        listView.setAdapter(customBaseAdapetr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("CUSTOM_LIST_VIEW","Item is clicked @ Position ::" + position );
            }
        });
    }
}