package com.example.taisuke.ankotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import android.content.Intent;
import java.util.List;

public class QrCodeReadInViewActivity extends AppCompatActivity {

    private CompoundBarcodeView mBarcodeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_read_in_view);

        mBarcodeView = (CompoundBarcodeView)findViewById(R.id.barcodeView);
        mBarcodeView.decodeSingle(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult barcodeResult) {

                //TextView textView = (TextView)findViewById(R.id.textView);
                //textView.setText(barcodeResult.getText());
                if(barcodeResult.getText().equals("お好み焼き")){
                    Intent intent = new Intent(getApplication(), NextActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void possibleResultPoints(List<ResultPoint> list) {}
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mBarcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mBarcodeView.pause();
    }

    //ここから
    //findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      //  @Override
        //public void onClick(View v) {
          //  val intent = Intent(QrCodeReadInViewActivity.this,NextActivity);
            //startActivity(intent);
        //}
    //});//ここまでエラーの原因
}