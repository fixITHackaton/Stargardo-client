package pl.fixit.stargardo.client.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import java.util.ArrayList;
import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;

public class ListCompanyActivity extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_company_list);
        View categoriesButton = findViewById(R.id.categoriesButton);
        categoriesButton.setOnClickListener(this);

        final ListView listView = findViewById(R.id.companyListView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Object o = prestListView.getItemAtPosition(position);
            Intent k = new Intent(this, ListProductActivity.class);
            startActivity(k);
        });


        List<CompanyDto> companiesList = new ArrayList<>();

        CompanySearchCriteriaDto searchCriteriaDto = new CompanySearchCriteriaDto();
        searchCriteriaDto.setCompanyCategory(CompanyCategory.FOOD);
        Activity activity = this;
        AndroidNetworking.post("http://10.0.2.2:8080/companies")
                .addHeaders("Content-Type", "application/json")
                .addApplicationJsonBody(searchCriteriaDto)
                .build()
                .getAsObjectList(CompanyDto.class, new ParsedRequestListener<List<CompanyDto>>() {
                    @Override
                    public void onResponse(List<CompanyDto> users) {
                        companiesList.addAll(users);
                        final CompanyListAdapter adapter = new CompanyListAdapter(activity, companiesList);
                        listView.setAdapter(adapter);
                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.e("REST-POST ERROR", anError.toString());
                    }
                });




        ////////////////////////////////////////////
        //////// DANE DO MOCKOW
//        ////////////////////////////////////////////
//        long l = 0L;
//        CompanyDto companyDto = new CompanyDto();
//        companyDto.setName("Pizzeria Maximus");
//        List<CompanySubcategoryDto> foodCategories = new ArrayList<>();
//        CompanySubcategoryDto companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("pizzeria1");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Kebab Layla");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Turecka");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("kebab1");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Sushi zushi");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Sushi");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("sushi1");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Pizza-hut");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("pizzeria2");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Kebab King");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Turecka");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("kebab2");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Izumi Sushi");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Sushi");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("sushi2");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Pizzeria Domino");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("pizzeria3");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Kuchnia Ashmira");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Turecka");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("kebab3");
//        companiesList.add(companyDto);
//
//        companyDto = new CompanyDto();
//        companyDto.setName("Pizza Nocą");
//        foodCategories = new ArrayList<>();
//        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
//        foodCategories.add(companySubcategoryDto);
//        companyDto.setCompanySubcategories(foodCategories);
//        companyDto.setDescription("pizzeria4");
//        companiesList.add(companyDto);

//        final CompanyListAdapter adapter = new CompanyListAdapter(this, companiesList);
//        listView.setAdapter(adapter);
        /////////////////////////////////////////////////////////
    }

    public void onClick(View v) {
        if (v.getId() == R.id.categoriesButton) {
            Intent k = new Intent(this, CategoryActivity.class);
            startActivity(k);
        }
    }
}
