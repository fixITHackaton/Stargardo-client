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
import pl.fixit.stargardo.common.product.dto.ProductDto;

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
        TextView productName = convertView.findViewById(R.id.productName);
        productName.setText(order.getName());
        TextView productPrice = convertView.findViewById(R.id.productPrice);
        productPrice.setText(order.getPrice().toString() + "zł");
        ImageView companyIcon = convertView.findViewById(R.id.productIcon);
        Resources res = context.getResources();
        int resID = res.getIdentifier(product.getDescription(), "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resID);
        companyIcon.setImageDrawable(drawable);
        return convertView;
    }
}
