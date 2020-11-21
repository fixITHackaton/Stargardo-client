package pl.fixit.stargardo.client.food;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import pl.fixit.stargardo.client.R;

public class ListProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_product_list);

        final ListView listView = findViewById(R.id.productListView);
        String[] values = new String[] { "Strips x5", "Dupa z masłem", "Swierzy siuras", "Jajka na miękko" };

        final ProductListAdapter adapter = new ProductListAdapter(this, values);
        listView.setAdapter(adapter);
    }
}
