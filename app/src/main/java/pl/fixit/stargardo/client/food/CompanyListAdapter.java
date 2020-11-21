package pl.fixit.stargardo.client.food;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.company.dto.CompanyDto;

class CompanyListAdapter extends ArrayAdapter<CompanyDto> {
    private final Context context;
    private List<CompanyDto> companies;

    public CompanyListAdapter(Context context, List<CompanyDto> companies) {
        super(context, -1, companies);
        this.context = context;
        this.companies = companies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_food_company_list, parent, false);
        }
        CompanyDto company = companies.get(position);
        TextView companyName = convertView.findViewById(R.id.companyName);
        TextView foodType = convertView.findViewById(R.id.foodType);
        TextView companyLocation = convertView.findViewById(R.id.companyLocation);
        TextView openTime = convertView.findViewById(R.id.openTime);
        ImageView companyIcon = convertView.findViewById(R.id.companyIcon);
//        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//        ImageView image = (ImageView) findViewById(R.id.imageView1);
//        image.setImageBitmap(Bitmap.createScaledBitmap(bmp, image.getWidth(), image.getHeight(), false));
//        companyIcon.setImageResource(company.getImage());

        return convertView;
    }
}
