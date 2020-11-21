package pl.fixit.stargardo.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.fixit.stargardo.client.food.ListCompanyActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View doneButton = findViewById(R.id.foodButton);
        doneButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.foodButton) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
    }
}