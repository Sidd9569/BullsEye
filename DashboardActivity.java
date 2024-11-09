package com.example.stockmarket;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;

public class DashboardActivity extends AppCompatActivity {

    // Declare the Settings button
    private Button settingsButton;
    private static final int REQUEST_CODE_SEARCH = 1;

    private TextView welcomeTextView;
    private EditText searchBar;
    private TextView accountMoneyTextView;
    private ListView portfolioListView;
    private ListView watchlistListView;

    private double accountMoney = 1000.00;
    private List<String> portfolioItems;
    private List<String> watchlistItems;
    private ArrayAdapter<String> portfolioAdapter;
    private ArrayAdapter<String> watchlistAdapter;

    private Handler handler = new Handler();
    private Runnable marketPriceUpdater;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        welcomeTextView = findViewById(R.id.welcomeTextView);
        searchBar = findViewById(R.id.searchBar);
        accountMoneyTextView = findViewById(R.id.accountMoneyTextView);
        portfolioListView = findViewById(R.id.portfolioListView);
        watchlistListView = findViewById(R.id.watchlistListView);
        viewFlipper = findViewById(R.id.viewFlipper);

        // Initialize the settings button
        settingsButton = findViewById(R.id.settingsButton);

        // Add click listener for settings button
        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        searchBar.setHintTextColor(Color.LTGRAY);

        // Set initial account money
        updateAccountMoney();

        // Initialize portfolio and watchlist
        portfolioItems = new ArrayList<>();
        portfolioAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, portfolioItems);
        portfolioListView.setAdapter(portfolioAdapter);

        watchlistItems = new ArrayList<>();
        watchlistItems.add("Nifty - $15800.00");
        watchlistItems.add("Bank Nifty - $34500.00");
        watchlistItems.add("BSE - $50000.00");
        watchlistAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, watchlistItems);
        watchlistListView.setAdapter(watchlistAdapter);

        // Update market prices periodically
        marketPriceUpdater = new Runnable() {
            @Override
            public void run() {
                updateMarketPrices();
                handler.postDelayed(this, 15000);
            }
        };
        handler.post(marketPriceUpdater);

        // Handle search bar input
        searchBar.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN)) {
                handleSearch();
                return true;
            }
            return false;
        });

        // Start image flipping
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();
    }

    private void updateAccountMoney() {
        accountMoneyTextView.setText("Account Balance: $" + String.format("%.2f", accountMoney));
    }

    private void updateMarketPrices() {
        watchlistItems.set(0, "Nifty - $" + String.format("%.2f", Math.random() * 20000 + 10000));
        watchlistItems.set(1, "Bank Nifty - $" + String.format("%.2f", Math.random() * 40000 + 20000));
        watchlistItems.set(2, "BSE - $" + String.format("%.2f", Math.random() * 60000 + 40000));
        watchlistAdapter.notifyDataSetChanged();
    }

    private void handleSearch() {
        String searchQuery = searchBar.getText().toString().trim();
        if (!searchQuery.isEmpty()) {
            Intent intent = new Intent(DashboardActivity.this, SearchResultActivity.class);
            intent.putExtra("searchQuery", searchQuery);
            startActivityForResult(intent, REQUEST_CODE_SEARCH);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SEARCH && resultCode == Activity.RESULT_OK) {
            String purchasedStock = data.getStringExtra("purchasedStock");
            if (purchasedStock != null) {
                portfolioItems.add(purchasedStock);
                portfolioAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(marketPriceUpdater);
    }
}



