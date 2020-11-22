package pl.fixit.stargardo.client.food;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.product.dto.ProductDto;

class ProductListAdapter extends ArrayAdapter<ProductDto> {
    private final Context context;
    private final List<ProductDto> products;

    public ProductListAdapter(Context context, List<ProductDto> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_food_product_list, parent, false);
        }

        ProductDto product = products.get(position);
        TextView productName = convertView.findViewById(R.id.productName);
        productName.setText(product.getName());
        TextView productPrice = convertView.findViewById(R.id.productPrice);
        productPrice.setText(product.getPrice().toString() + "zł");
        ImageView productIcon = convertView.findViewById(R.id.productIcon);
        Resources res = context.getResources();
        int resID = res.getIdentifier(product.getDescription() , "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resID);
        productIcon.setImageDrawable(drawable);
        return convertView;
    }
}
