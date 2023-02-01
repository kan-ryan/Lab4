package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        loadProfile();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Code Here
        saveProfile();


    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "");
        TextView nameView = findViewById(R.id.name_text);
        nameView.setText(name);

        String status = preferences.getString("status", "");
        TextView statusView = findViewById(R.id.status_text);
        statusView.setText(status);


    }

    public void saveProfile(){
        SharedPreferences  preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameView = findViewById(R.id.name_text);
        editor.putString("name", nameView.getText().toString());
        TextView statusView = findViewById(R.id.status_text);
        editor.putString("status", statusView.getText().toString());

        editor.apply();
    }

    public void onExitClicked(View view) {
        finish();
    }
}