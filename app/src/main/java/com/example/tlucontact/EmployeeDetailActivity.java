package com.example.tlucontact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDetailActivity extends AppCompatActivity {
    private TextView tvName, tvPosition, tvPhone, tvEmail, tvDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        tvName = findViewById(R.id.tvName);
        tvPosition = findViewById(R.id.tvPosition);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvDepartment = findViewById(R.id.tvDepartment);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));
        tvPosition.setText(intent.getStringExtra("position"));
        tvPhone.setText("📞 " + intent.getStringExtra("phone"));
        tvEmail.setText("✉ " + intent.getStringExtra("email"));
        tvDepartment.setText("🏢 " + intent.getStringExtra("department"));
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

    }
}
