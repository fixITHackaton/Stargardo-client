package pl.fixit.stargardo.client.food;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.Base64;
import java.util.List;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;

class CompanyListAdapter extends ArrayAdapter<CompanyDto> {
    private final Context context;
    private final List<CompanyDto> companies;

    public CompanyListAdapter(Context context, List<CompanyDto> companies) {
        super(context, -1, companies);
        this.context = context;
        this.companies = companies;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_food_company_list, parent, false);
        }
        CompanyDto company = companies.get(position);
        TextView companyName = convertView.findViewById(R.id.companyName);
        companyName.setText(company.getName());
        TextView foodType = convertView.findViewById(R.id.foodType);
        StringBuilder foodTypes = new StringBuilder();
        List<CompanySubcategoryDto> foodCategories = company.getCompanySubcategories();
        for (CompanySubcategoryDto foodCategory : foodCategories) {
            foodTypes.append(foodCategory.getName());
            foodTypes.append(", ");
        }
        foodTypes.delete(foodTypes.length() - 2, foodTypes.length());
        foodType.setText(foodTypes);
        TextView companyLocation = convertView.findViewById(R.id.companyLocation);
        companyLocation.setText(company.getAddress());
        TextView openTime = convertView.findViewById(R.id.openTime);
        openTime.setText(company.getOpeningHour() + "-" + company.getClosingHour());

        ImageView companyIcon = convertView.findViewById(R.id.companyIcon);
        RelativeLayout.LayoutParams imageProcessParams =
                (RelativeLayout.LayoutParams)companyIcon.getLayoutParams();
        byte[] image = Base64.getDecoder().decode(company.getImage());
        Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
        companyIcon.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageProcessParams.width, imageProcessParams.height, false));
        return convertView;
    }
}
