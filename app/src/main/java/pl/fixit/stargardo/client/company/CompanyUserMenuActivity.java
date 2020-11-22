package pl.fixit.stargardo.client.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.fixit.stargardo.client.R;

public class CompanyUserMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_user_menu);
        findViewById(R.id.menuCurrentOrders).setOnClickListener(this);
        findViewById(R.id.menuAddProduct).setOnClickListener(this);
        findViewById(R.id.menuEditProduct).setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.menuCurrentOrders) {
            Intent k = new Intent(this, CompanyUserActiveOrdersActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.menuAddProduct) {
            Intent k = new Intent(this, CompanyUserAddProductActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.menuEditProduct) {
            Intent k = new Intent(this, CompanyUserAddProductActivity.class);
            startActivity(k);
        }
    }
}