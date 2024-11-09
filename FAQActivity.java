package com.example.stockmarket;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqactivity);

        // Initialize the ListView
        ListView faqListView = findViewById(R.id.faqListView);

        // List of questions and answers for common problems in a stock broker app
        List<HashMap<String, String>> faqList = new ArrayList<>();

        HashMap<String, String> faq1 = new HashMap<>();
        faq1.put("question", "Why can't I log into my account?");
        faq1.put("answer", "Ensure your internet connection is stable. If the issue persists, try resetting your password.");

        HashMap<String, String> faq2 = new HashMap<>();
        faq2.put("question", "What should I do if my funds aren’t reflecting?");
        faq2.put("answer", "It may take a few hours for funds to reflect. Contact support if it exceeds the expected time.");

        HashMap<String, String> faq3 = new HashMap<>();
        faq3.put("question", "Why is my trade order not executing?");
        faq3.put("answer", "Orders may not execute if there is insufficient liquidity or the market is closed. Check your order type and timing.");

        HashMap<String, String> faq4 = new HashMap<>();
        faq4.put("question", "How do I resolve app crashes?");
        faq4.put("answer", "Ensure you are using the latest app version. Try clearing the app cache or reinstalling.");

        HashMap<String, String> faq5 = new HashMap<>();
        faq5.put("question", "Why are my stock prices delayed?");
        faq5.put("answer", "Most apps provide delayed prices due to market policies. For real-time prices, consider a premium subscription.");

        HashMap<String, String> faq6 = new HashMap<>();
        faq6.put("question", "Why is my withdrawal request delayed?");
        faq6.put("answer", "Withdrawal requests may take a few business days. Check if your bank details are correct or contact support.");

        HashMap<String, String> faq7 = new HashMap<>();
        faq7.put("question", "How can I change my linked bank account?");
        faq7.put("answer", "To update your bank details, go to Settings > Account Details. You may need to verify the new account.");

        HashMap<String, String> faq8 = new HashMap<>();
        faq8.put("question", "Why is the app slow or unresponsive?");
        faq8.put("answer", "Heavy traffic during peak hours can slow down the app. Try again later or contact support if the issue continues.");

        faqList.add(faq1);
        faqList.add(faq2);
        faqList.add(faq3);
        faqList.add(faq4);
        faqList.add(faq5);
        faqList.add(faq6);
        faqList.add(faq7);
        faqList.add(faq8);

        // Adapter to display the questions and answers
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                faqList,
                android.R.layout.simple_list_item_2,
                new String[]{"question", "answer"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        faqListView.setAdapter(adapter);
    }
}

