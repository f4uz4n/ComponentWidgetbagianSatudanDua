package com.example.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    // deklarasi komponen
    Intent intent;
    Button btnLink, btnDialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // terima kiriman data
        String message = getIntent().getStringExtra("message");

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        // instansiasi komponen
        btnLink = findViewById(R.id.btn_link);
        btnDialNumber = findViewById(R.id.btn_dial_number);

        // event click btnLink
        btnLink.setOnClickListener( view -> {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/studywithstudentkuy"));
            startActivity(intent);
        });

        // event click btnDialNumber
        btnDialNumber.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));
            startActivity(intent);
        });
    }
}