package com.example.timewise_rsa2023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore fStore;
    String userID;

    Button welcomeButton;
    TextView toDoButton;
    TextView pomodoroButton;
    TextView homeText;
    TextView toDoTextView;
    TextView unwindText;
    TextView resourcesText;

    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button = findViewById(R.id.logout_button);
        welcomeButton = findViewById(R.id.welcome_back);
        toDoButton = findViewById(R.id.home_todo);
        pomodoroButton = findViewById(R.id.home_pomodoro);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userID = auth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                welcomeButton.setText("welcome back, " + documentSnapshot.getString("fName"));
            }
        });

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }


        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        toDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
                finish();
            }
        });

    }
}