package com.example.tlucontact;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tlucontact.R;

import java.text.BreakIterator;

public class UnitDetailActivity extends AppCompatActivity {
    private TextView tvName, tvPhone, tvAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_detail);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvAddress = findViewById(R.id.tvAddress);
        Button btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ Intent
        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");

        // Hiển thị thông tin lên giao diện
        tvName.setText(name);
        tvPhone.setText("📞 " + phone);
        tvAddress.setText("📍 " + address);

        // Xử lý sự kiện khi nhấn vào nút "Back"
        btnBack.setOnClickListener(v -> finish()); // Đóng Activity và quay lại danh sách
    }

    }

