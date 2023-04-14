package com.example.timewise_rsa2023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore fStore;
    String userID;

    TextView welcomeButtonText;
    ImageView welcomeBack;
    ImageView toDoButton;
    ImageView pomodoroButton;
    TextView signOutText;
    TextView homeText;
    TextView calendarText;
    TextView unwindText;
    TextView resourcesText;

    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button = findViewById(R.id.logout_button);
        welcomeBack = findViewById(R.id.welcome_back);
        welcomeButtonText = findViewById(R.id.welcome_back_text);
        toDoButton = findViewById(R.id.home_todo);
        pomodoroButton = findViewById(R.id.home_pomodoro);
        signOutText = findViewById(R.id.sign_out);
        calendarText = findViewById(R.id.calendar_panel_text);
        unwindText = findViewById(R.id.unwind_panel_text);
        resourcesText = findViewById(R.id.resources_panel_text);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userID = auth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        ListenerRegistration registration = documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                welcomeButtonText.setText("welcome back, " + documentSnapshot.getString("fName") + "!");
            }
        });

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), IntroScreen.class);
            startActivity(intent);
            finish();
        }

        unwindText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BreathingExercisesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signOutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration.remove();
                auth.signOut();
                Intent intent = new Intent(getApplicationContext(), IntroScreen.class);
                startActivity(intent);
                finish();
            }
        });

        calendarText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
                finish();
            }
        });

        resourcesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudyResourcesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        pomodoroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectPomodoroTimer.class);
                startActivity(intent);
                finish();
            }
        });

        toDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ToDoListMain.class);
                startActivity(intent);
                finish();
            }
        });

    }
}