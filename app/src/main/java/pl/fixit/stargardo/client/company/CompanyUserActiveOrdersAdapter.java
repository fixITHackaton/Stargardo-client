package pl.fixit.stargardo.client.company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pl.fixit.stargardo.client.R;

import pl.fixit.stargardo.common.order.dto.OrderDto;

public class CompanyUserActiveOrdersAdapter extends ArrayAdapter<OrderDto> {
    private final Context context;
    private final List<OrderDto> orders;

    public CompanyUserActiveOrdersAdapter(Context context, List<OrderDto> orders) {
        super(context, -1, orders);
        this.context = context;
        this.orders = orders;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_company_food_product_list, parent, false);
        }

        OrderDto order = orders.get(position);
        TextView orderId = convertView.findViewById(R.id.orderId);
        orderId.setText(String.valueOf(order.getId()));
        TextView orderAddress = convertView.findViewById(R.id.orderAddress);
        orderAddress.setText(order.getAddress());
        // TODO - dodać orderSTatus i orderDate do OrderDto
        TextView orderStatus = convertView.findViewById(R.id.orderStatus);
        orderStatus.setText("SPRZEDANE");
        TextView orderDate = convertView.findViewById(R.id.orderDate);
        orderDate.setText("10:00 17.02.2020");
        return convertView;
    }
}
