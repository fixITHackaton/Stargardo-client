package pl.fixit.stargardo.client.food;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import retrofit2.Retrofit;

public class ListCompanyActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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
//        try {
//            URL url = new URL("http://localhost:8080/companies");
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Content-Type", "application/json; utf-8");
//            con.setRequestProperty("Accept", "application/json");
//            con.setDoOutput(true);
//
//            CompanySearchCriteriaDto searchCriteriaDto = new CompanySearchCriteriaDto();
//            searchCriteriaDto.setCompanyCategory(CompanyCategory.FOOD);
//            JsonObject jsonObject = new JsonObject();
//            OutputStream os = con.getOutputStream();
//            byte[] input = jsonObject.toString().getBytes(StandardCharsets.UTF_8);
//            os.write(input, 0, input.length);
//
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
//
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            Log.d("kurła", response.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        AndroidNetworking.post("localhost:8080/companies")
//                .setPriority(Priority.MEDIUM)
//                .setTag("test")
//                .build()
//                .getAsObjectList(CompanyDto.class, new ParsedRequestListener<List<CompanyDto>>() {
//                    @Override
//                    public void onResponse(List<CompanyDto> users) {
//                        companiesList.addAll(users);
//                        Log.d("weszło kurła", "kurła");
//                    }
//                    @Override
//                    public void onError(ANError anError) {
//                        Log.d("nie kurła", anError.toString());
//                    }
//                });
//        String[] values = new String[] { "Kebab", "Kurczaki", "Hindus", "Chińskie" };



        ////////////////////////////////////////////
        long l = 0L;
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("Pizzeria Maximus");
        List<CompanySubcategoryDto> foodCategories = new ArrayList<>();
        CompanySubcategoryDto companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("pizzeria1");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Kebab Layla");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Turecka");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("kebab1");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Sushi zushi");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Sushi");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("sushi1");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Pizza-hut");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("pizzeria2");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Kebab King");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Turecka");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("kebab2");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Izumi Sushi");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Sushi");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("sushi2");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Pizzeria Domino");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("pizzeria3");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Kuchnia Ashmira");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Turecka");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("kebab3");
        companiesList.add(companyDto);

        companyDto = new CompanyDto();
        companyDto.setName("Pizza Nocą");
        foodCategories = new ArrayList<>();
        companySubcategoryDto = new CompanySubcategoryDto(l + 1, "Włoska");
        foodCategories.add(companySubcategoryDto);
        companyDto.setCompanySubcategories(foodCategories);
        companyDto.setDescription("pizzeria4");
        companiesList.add(companyDto);
        /////////////////////////////////////////////////////////

        final CompanyListAdapter adapter = new CompanyListAdapter(this, companiesList);
        listView.setAdapter(adapter);
    }
}
