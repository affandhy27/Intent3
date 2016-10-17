package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialPhoneNumber("085258124128");

            }
        });


        findViewById(R.id.imageView3sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialsms("SMS dari Affandhy");

            }
        });


        findViewById(R.id.imageViewbrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openweb("https://www.google.com");

            }
        });


        findViewById(R.id.imageViewcamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                capture();

            }
        });

    }

    private void capture() {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);


    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {

        super.onActivityResult(requestcode, resultcode, data);
        if (requestcode == REQUEST_IMAGE_CAPTURE && requestcode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            ImageView iv = (ImageView) findViewById(R.id.imageViewcamera);
            iv.setImageBitmap(bitmap);


        }
    }

    private void openweb(String url) {

        Uri weppage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, weppage);
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivity(intent);

    }

    private void dialsms(String message) {


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivity(intent);


    }

    private void dialPhoneNumber(String phonenumber) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phonenumber));
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivity(intent);

    }
}
