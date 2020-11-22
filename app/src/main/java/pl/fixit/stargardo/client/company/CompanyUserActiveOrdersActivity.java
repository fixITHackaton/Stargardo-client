package pl.fixit.stargardo.client.company;

import androidx.appcompat.app.AppCompatActivity;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.order.dto.OrderDto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CompanyUserActiveOrdersActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_user_active_orders);
        findViewById(R.id.ordersMenuButton).setOnClickListener(this);
        final ListView listView = findViewById(R.id.activeOrders);
        List<OrderDto> orders = new ArrayList();

        OrderDto orderDto = new OrderDto();
        orderDto.setId(12624L);
        orderDto.setAddress("ul. Stargradzka 3 m. 32");
        orders.add(orderDto);
        orderDto = new OrderDto();
        orderDto.setId(64533L);
        orderDto.setAddress("ul. Witkowska 2/12");
        orders.add(orderDto);

        final CompanyUserActiveOrdersAdapter adapter = new CompanyUserActiveOrdersAdapter(this, orders);
        listView.setAdapter(adapter);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.ordersMenuButton) {
            Intent k = new Intent(this, CompanyUserMenuActivity.class);
            startActivity(k);
        }
    }
}