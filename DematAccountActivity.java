package com.example.stockmarket;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.SimpleAdapter;


public class DematAccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demat_account);

        // Initialize the ListView
        ListView faqListView = findViewById(R.id.faqListView);

        // Set up questions and answers
        List<HashMap<String, String>> faqList = new ArrayList<>();

        HashMap<String, String> faq1 = new HashMap<>();
        faq1.put("question", "What is a Demat account?");
        faq1.put("answer", "A Demat account is used to hold shares and securities in electronic form.");

        HashMap<String, String> faq2 = new HashMap<>();
        faq2.put("question", "How do I open a Demat account?");
        faq2.put("answer", "To open a Demat account, you need to complete the KYC process with a broker, submit identity and address proof, and complete in-person verification.");

        HashMap<String, String> faq3 = new HashMap<>();
        faq3.put("question", "What documents are required?");
        faq3.put("answer", "Generally, you need PAN card, Aadhaar card, passport-size photos, and bank account details.");

        HashMap<String, String> faq4 = new HashMap<>();
        faq4.put("question", "Is there any fee for a Demat account?");
        faq4.put("answer", "Some brokers charge account opening fees or annual maintenance charges; others may offer it for free.");

        HashMap<String, String> faq5 = new HashMap<>();
        faq5.put("question", "Can I open multiple Demat accounts?");
        faq5.put("answer", "Yes, you can open multiple Demat accounts, but only with different brokers.");

        faqList.add(faq1);
        faqList.add(faq2);
        faqList.add(faq3);
        faqList.add(faq4);
        faqList.add(faq5);

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

