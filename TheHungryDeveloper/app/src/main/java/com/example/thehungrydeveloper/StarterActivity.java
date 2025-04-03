package com.example.thehungrydeveloper;

import static com.example.thehungrydeveloper.R.*;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StarterActivity extends AppCompatActivity {

private ListView LstStaterFoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_starter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LstStaterFoods = (ListView) findViewById(R.id.lstStarter) ;

        String[] dishes = {
                "Mushroom and tofu maki",
                "Egg and avocado uramaki",
                "Melon and lemon soup",
                "Coconut and chocolate mousse",
                "Spinach and cabbage wontons",
                "Broccoli and cucumber soup",
                "Chilli and aubergine dip",
                "Chickpea and chilli gyoza",
                "Sprout and pineapple soup",
                "Egusi and borscht soup",
                "Aubergine and egg sushi",
                "Artichoke and mustard soup",
                "Peppercorn and tamarind soup",
                "Parsley and celeriac parcels",
                "Pasta and broccoli soup",
                "Potato and courgette soup",
                "Chickpea and cabbage parcels",
                "Coriander and peppercorn gyoza",
                "Pear and chestnut soup",
                "Pesto and garam masala parcels"
        };
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dishes);
        LstStaterFoods.setAdapter(myAdapter);
    }
}