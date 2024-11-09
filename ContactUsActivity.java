package com.example.stockmarket;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        // Set up phone numbers and email links
        TextView phone1 = findViewById(R.id.phone1);
        TextView phone2 = findViewById(R.id.phone2);
        TextView phone3 = findViewById(R.id.phone3);
        TextView phone4 = findViewById(R.id.phone4);
        TextView email = findViewById(R.id.email);
        TextView instagram = findViewById(R.id.instagram);

        // Set click listeners to initiate calls or emails
        phone1.setOnClickListener(v -> dialPhoneNumber("9569854644"));
        phone2.setOnClickListener(v -> dialPhoneNumber("8439787683"));
        phone3.setOnClickListener(v -> dialPhoneNumber("9412335480"));
        phone4.setOnClickListener(v -> dialPhoneNumber("9117011475"));
        email.setOnClickListener(v -> sendEmail("support@stockbrokerapp.com"));
        instagram.setOnClickListener(v -> openInstagram("https://instagram.com/stockbrokerapp"));
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    private void sendEmail(String emailAddress) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + emailAddress));
        startActivity(Intent.createChooser(emailIntent, "Send email"));
    }

    private void openInstagram(String url) {
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(instagramIntent);
    }
}

