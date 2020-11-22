package pl.fixit.stargardo.client.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import pl.fixit.stargardo.client.R;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
        View categoryGroceriesButton = findViewById(R.id.category_groceries);
        categoryGroceriesButton.setOnClickListener(this);
        View categoryItalianButton = findViewById(R.id.categoryItalian);
        categoryItalianButton.setOnClickListener(this);
        View categoryAmericanButton = findViewById(R.id.categoryAmerican);
        categoryAmericanButton.setOnClickListener(this);
        View categoryOrientalButton = findViewById(R.id.categoryOriental);
        categoryOrientalButton.setOnClickListener(this);
        View categorySushiButton = findViewById(R.id.categorySushi);
        categorySushiButton.setOnClickListener(this);
        View categoryCofeeButton = findViewById(R.id.categoryCoffee);
        categoryCofeeButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.category_groceries) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.categoryItalian) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.categoryAmerican) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.categoryOriental) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.categorySushi) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
        if (v.getId() == R.id.categoryCoffee) {
            Intent k = new Intent(this, ListCompanyActivity.class);
            startActivity(k);
        }
    }
}