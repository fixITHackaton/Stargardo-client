package pl.fixit.stargardo.client.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import pl.fixit.stargardo.client.core.Cart;
import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.product.dto.ProductDto;

class ProductListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ProductListAdapter(Context context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_food_product_list, parent, false);
        }

        TextView firstLineTextView = convertView.findViewById(R.id.textView1);
        TextView secondLineTextView = convertView.findViewById(R.id.textView2);
//        ImageView imageView = convertView.findViewById(R.id.icon);
        firstLineTextView.setText(values[position]);
        secondLineTextView.setText("50zł");
//        imageView.setImageResource(R.drawable.ic_launcher_background);

        Button addToCart = convertView.findViewById(R.id.addToCartButton);
        addToCart.setOnClickListener(v -> {
            Cart.addProduct(new ProductDto());
        });

        return convertView;
    }
}
