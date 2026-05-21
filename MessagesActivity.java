package com.example.online_shop;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MessagesActivity extends AppCompatActivity {

    private RecyclerView messagesRecycler;
    private EditText etMessage;
    private Button btnSend;
    private List<String> messages = new ArrayList<>();
    private List<String> times = new ArrayList<>();
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        messagesRecycler = findViewById(R.id.messagesRecycler);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        // Default welcome message
        messages.add("Hello! How can we help you?");
        times.add("Support");

        adapter = new MessageAdapter(messages, times);
        messagesRecycler.setLayoutManager(new LinearLayoutManager(this));
        messagesRecycler.setAdapter(adapter);

        btnSend.setOnClickListener(v -> {
            String msg = etMessage.getText().toString().trim();
            if (!TextUtils.isEmpty(msg)) {
                String time = new SimpleDateFormat("hh:mm a", Locale.getDefault())
                        .format(new Date());
                messages.add(msg);
                times.add(time);
                adapter.notifyItemInserted(messages.size() - 1);
                messagesRecycler.scrollToPosition(messages.size() - 1);
                etMessage.setText("");

                // Auto reply
                messagesRecycler.postDelayed(() -> {
                    messages.add("Thank you for your message! We will get back to you soon.");
                    times.add("Support");
                    adapter.notifyItemInserted(messages.size() - 1);
                    messagesRecycler.scrollToPosition(messages.size() - 1);
                }, 1000);
            }
        });
    }
}