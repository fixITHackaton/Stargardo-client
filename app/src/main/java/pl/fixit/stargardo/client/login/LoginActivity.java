package pl.fixit.stargardo.client.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.client.company.CompanyUserActiveOrdersActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static long COMPANY_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View loginButton = findViewById(R.id.signInButton);
        loginButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.signInButton) {
            Intent k = new Intent(this, CompanyUserActiveOrdersActivity.class);
            startActivity(k);
        }
    }

}