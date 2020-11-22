package pl.fixit.stargardo.client.company;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import pl.fixit.stargardo.client.R;
import pl.fixit.stargardo.common.product.dto.ProductDto;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.JsonObject;

import static pl.fixit.stargardo.client.login.LoginActivity.COMPANY_ID;

public class CompanyUserAddProductActivity extends AppCompatActivity implements View.OnClickListener {

    private static int RESULT_LOAD_IMAGE = 1;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_user_add_product);
        findViewById(R.id.addProductPhotoButton).setOnClickListener(this);
        findViewById(R.id.addProductSaveButton).setOnClickListener(this);
        verifyStoragePermissions(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addProductPhotoButton) {
            Intent k = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(k, RESULT_LOAD_IMAGE);
        }
        if (v.getId() == R.id.addProductSaveButton) {
            saveProduct();
            Intent k = new Intent(this, CompanyUserActiveOrdersActivity.class);
            startActivity(k);
        }
    }

    private void saveProduct() {
        Activity activity = this;
        ProductDto productDto = new ProductDto();
        productDto.setCompanyId(COMPANY_ID);
        productDto.setName(String.valueOf(((TextView) findViewById(R.id.addProductName)).getText()));
        productDto.setPrice(Double.valueOf(((TextView) findViewById(R.id.addProductPrice)).getText().toString()));
        productDto.setDescription(String.valueOf(((TextView) findViewById(R.id.addProductName)).getText()));
        //productDto.setPhoto(String.valueOf(((TextView) findViewById(R.id.addProductName)).getText()));
        AndroidNetworking.post("http://10.0.2.2:8080/company/" + COMPANY_ID + "/addProduct")
                .addHeaders("Content-Type", "application/json")
                .addApplicationJsonBody(productDto)
                .build()
                .getAsObject(Long.class, new ParsedRequestListener<Long>() {
                    @Override
                    public void onResponse(Long productId) {
                        Toast.makeText(activity, "Produkt zapisany poprawnie", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(activity, "Błąd zapisu", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.addProductPhotoImage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}