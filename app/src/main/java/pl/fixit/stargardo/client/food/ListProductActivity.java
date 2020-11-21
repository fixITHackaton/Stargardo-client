package pl.fixit.stargardo.client.food;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;
import pl.fixit.stargardo.common.product.dto.ProductDto;

public class ListProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_product_list);

        final ListView listView = findViewById(R.id.productListView);


        List<ProductDto> products = new ArrayList<>();
        CompanySearchCriteriaDto searchCriteriaDto = new CompanySearchCriteriaDto();
        searchCriteriaDto.setCompanyCategory(CompanyCategory.FOOD);
        AndroidNetworking.post("http://10.0.2.2:8080/products")
//                .setPriority(Priority.MEDIUM)
//                .setTag("test")
                .addHeaders("Content-Type", "application/json")
                .addApplicationJsonBody(searchCriteriaDto)
                .build()
                .getAsObjectList(CompanyDto.class, new ParsedRequestListener<List<CompanyDto>>() {
                    @Override
                    public void onResponse(List<CompanyDto> users) {
                        companiesList.addAll(users);
                        Log.d("weszło kurła", "kurła");
                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.d("nie kurła", anError.toString());
                    }
                });


        ////////////////////////////////////////////
//        long l = 0L;
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Margherita");
//        productDto.setPrice(19.99);
//        productDto.setDescription("pizza1");
//        products.add(productDto);
//
//        productDto = new ProductDto();
//        productDto.setName("Capricciosa");
//        productDto.setPrice(18.99);
//        productDto.setDescription("pizza2");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Hawajska");
//        productDto.setPrice(20.99);
//        productDto.setDescription("pizza3");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Meksykańska");
//        productDto.setPrice(24.99);
//        productDto.setDescription("pizza4");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Pepperoni");
//        productDto.setPrice(17.99);
//        productDto.setDescription("pizza1");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Margarina");
//        productDto.setPrice(32.99);
//        productDto.setDescription("pizza2");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Na wypasie");
//        productDto.setPrice(39.99);
//        productDto.setDescription("pizza3");
//        products.add(productDto);
//
//        productDto = new ProductDto();
//        productDto.setName("Fungi");
//        productDto.setPrice(25.99);
//        productDto.setDescription("pizza4");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Wiejska");
//        productDto.setPrice(29.99);
//        productDto.setDescription("pizza1");
//        products.add(productDto);
//
//
//        productDto = new ProductDto();
//        productDto.setName("Ekstrawaganza");
//        productDto.setPrice(19.99);
//        productDto.setDescription("pizza2");
//        products.add(productDto);
        /////////////////////////////////////////////////////////

        final ProductListAdapter adapter = new ProductListAdapter(this, products);
        listView.setAdapter(adapter);
    }
}
