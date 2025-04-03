package com.example.oursharedpreference

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.oursharedpreference.ui.theme.OurSharedPreferenceTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    //khaibao thuoc tinh cua 1 lop
    private lateinit var edtPhone: EditText
    private lateinit var btnSave: Button
    private lateinit var btbLoad: Button
    private lateinit var txtInfo: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tham chieu ptu view thuc te tren giao dien
        edtPhone = findViewById(R.id.edt_phone)
        btnSave = findViewById(R.id.btn_save)
        btbLoad = findViewById(R.id.btn_load)
        txtInfo = findViewById(R.id.txt_info)

        btnSave.setOnClickListener {
            //lay ra gtr nhap vao tu edittext
            val phone = edtPhone.text.toString()
            // luu gtr nay vao Sharedpreferences
            val sharedPreferences = getSharedPreferences("HIEU", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("PHONE", phone)
            editor.apply()
        }

        btbLoad.setOnClickListener {
            val sharedPreferences = getSharedPreferences("HIEU", MODE_PRIVATE)
            val phone = sharedPreferences.getString("PHONE", "")
            txtInfo.text = phone
        }

    }
}
