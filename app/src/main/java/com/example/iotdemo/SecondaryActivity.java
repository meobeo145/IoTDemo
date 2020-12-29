package com.example.iotdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondaryActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    DatabaseReference mData;
    private ProgressBar temperature;
    private ProgressBar light;
    private ProgressBar humidity;

    private ImageButton turnOffLight;
    private ImageButton turnOnLight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent=getIntent();
//        String stringValue = intent.getStringExtra("mac_device");

        database= FirebaseDatabase.getInstance();
        mData = database.getReference();

        temperature = findViewById(R.id.proBarTemperature);
        light = findViewById(R.id.proBarLight);
        humidity= findViewById(R.id.proBarHumidity);

        turnOffLight = findViewById(R.id.imageButtonTurnOff);
        turnOnLight = findViewById(R.id.imageButtonTurnOn);

        mData.child("Devices").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Device device= snapshot.child(stringValue).getValue(Device.class);
                    Device device= snapshot.getValue(Device.class);
                    temperature.setProgress((int) Float.parseFloat(device.getTemperature()));
                    light.setProgress((int) Float.parseFloat(device.getLight()));
                    humidity.setProgress((int) Float.parseFloat(device.getHumidity()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        turnOnLight.setOnClickListener(v -> {
//                Toast.makeText(SecondaryActivity.this, "Đã bật đèn", Toast.LENGTH_LONG).show();
            mData.child("control").child("led").setValue(1);
        });

        turnOffLight.setOnClickListener(v -> {
//                Toast.makeText(SecondaryActivity.this, "Đã tắt đèn", Toast.LENGTH_LONG).show();
            mData.child("control").child("led").setValue(0);
        });

    }
}
