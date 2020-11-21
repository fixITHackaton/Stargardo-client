package pl.fixit.stargardo.client.food;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import java.util.ArrayList;
import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.company.dto.CompanyDto;

public class ListCompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_company_list);

        final ListView listView = findViewById(R.id.companyListView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Object o = prestListView.getItemAtPosition(position);
            Intent k = new Intent(this, ListProductActivity.class);
            startActivity(k);
        });


        List<CompanyDto> companiesList = new ArrayList<>();
        AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/createAnUser")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObjectList(CompanyDto.class, new ParsedRequestListener<List<CompanyDto>>() {
                    @Override
                    public void onResponse(List<CompanyDto> users) {
                        companiesList.addAll(users);
                    }
                    @Override
                    public void onError(ANError anError) {
                    }
                });
//        String[] values = new String[] { "Kebab", "Kurczaki", "Hindus", "Chińskie" };


        final CompanyListAdapter adapter = new CompanyListAdapter(this, companiesList);
        listView.setAdapter(adapter);
    }
}
