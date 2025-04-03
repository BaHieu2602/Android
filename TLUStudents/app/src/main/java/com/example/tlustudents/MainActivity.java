package com.example.tlustudents;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Student[] students = {
                new Student( "01", "Le Tuan Hung",R.drawable.a),
                new Student("02", "Nguyen Van A", R.drawable.b),
                new Student("03", "Tran Thi B", R.drawable.c),
                new Student("04", "Pham Van C", R.drawable.d),
                new Student("05", "Hoang Thi D", R.drawable.e),
                new Student("06", "Doan Van E", R.drawable.a),
                new Student("07", "Nguyen Thi F", R.drawable.b),
                new Student("08", "Bui Van G", R.drawable.c),
                new Student("09", "Pham Thi H", R.drawable.d),
                new Student("10", "Vu Van I", R.drawable.e)
        };
    }
}