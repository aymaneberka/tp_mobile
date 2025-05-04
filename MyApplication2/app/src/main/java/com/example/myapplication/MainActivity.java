package com.example.myapplication;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.location.LocationManager.NETWORK_PROVIDER;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements LocationListener {

    Button btnmap;
    private TextView latituteField;
    private TextView longitudeField;
    LocationManager localisations;
    Location lastprovider;
    private final String provider = NETWORK_PROVIDER;
    private static final int REQUEST_CODE = 101;
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


        latituteField = findViewById(R.id.textView2);
        longitudeField = findViewById(R.id.textView3);
        Button butlocation = findViewById(R.id.button3);

        butlocation.setOnClickListener(view -> {
            if (getApplicationContext().checkSelfPermission(ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED &&
                    getApplicationContext().checkSelfPermission(ACCESS_COARSE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{ACCESS_FINE_LOCATION}, REQUEST_CODE);
                return;
            }
            localisations = (LocationManager)
                    getSystemService(Context.LOCATION_SERVICE);
            Location lastprovider =
                    localisations.getLastKnownLocation(NETWORK_PROVIDER);
            latituteField.setText("Latitude : " + lastprovider.getLatitude());
            longitudeField.setText("Longitude : " + lastprovider.getLongitude());
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (localisations != null) {
            try {
                localisations.requestLocationUpdates(provider, 60000, 1, this);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (localisations != null) {
            localisations.removeUpdates(this);
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if (location != null) {
            latituteField.setText("Latitude : " + location.getLatitude());
            longitudeField.setText("Longitude : " + location.getLongitude());
        } else latituteField.setText("Location not available ");
        Toast.makeText(MainActivity.this, "Nouvelle position", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onProviderEnabled(String provider)
    { Toast.makeText(this, "Enabled new provider " + provider,
            Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onProviderDisabled(String provider)
    { Toast.makeText(this, "Disabled provider " + provider, Toast.LENGTH_SHORT).show();
    }
}