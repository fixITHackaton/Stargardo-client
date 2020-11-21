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
import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;

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
        companyName.setText(company.getName());
        TextView foodType = convertView.findViewById(R.id.foodType);
        StringBuilder foodTypes = new StringBuilder();
        List<CompanySubcategoryDto> foodCategories = company.getCompanySubcategories();
        for (CompanySubcategoryDto foodCategory : foodCategories) foodTypes.append(foodCategory.getName());
        foodType.setText(foodTypes);
        TextView companyLocation = convertView.findViewById(R.id.companyLocation);
        companyLocation.setText("Stargardzka 5");
        TextView openTime = convertView.findViewById(R.id.openTime);
        openTime.setText("10:00-22:00");
        ImageView companyIcon = convertView.findViewById(R.id.productIcon);
        Resources res = context.getResources();
        String mDrawableName = "logo_default";
        int resID = res.getIdentifier(company.getDescription() , "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resID);
        companyIcon.setImageDrawable(drawable);
//        ImageView companyIcon = convertView.findViewById(R.id.companyIcon);
//        Bitmap bmp = BitmapFactory.decodeByteArray(company.getImage(), 0, company.getImage().length);
//        companyIcon.setImageBitmap(Bitmap.createScaledBitmap(bmp, companyIcon.getWidth(), companyIcon.getHeight(), false));

        return convertView;
    }
}
