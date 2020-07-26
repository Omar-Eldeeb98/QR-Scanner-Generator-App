package com.example.qrgeneratorreaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class MainActivity extends AppCompatActivity {
    EditText qrValue;
    Button generateButton , scanButton;
    ImageView qrImage;
  public static   TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        qrValue = (EditText) findViewById( R.id.qr_input );
        generateButton = (Button) findViewById( R.id.qr_generate_btn );
        scanButton = (Button) findViewById( R.id.scan_qr_btn );
        qrImage = (ImageView) findViewById( R.id.qr_image );
        result = findViewById( R.id.result );

        generateButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {

                    BitMatrix bitMatrix = multiFormatWriter.encode( qrValue.getText().toString() , BarcodeFormat.QR_CODE , 500 , 500 );
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap( bitMatrix );
                    qrImage.setImageBitmap( bitmap );

                    result.setText( "" );  // حاجه فرعية كده مش اكيد دى جدعنه منى

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        } );

        scanButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent( MainActivity.this , MainActivity2.class ) );
            }
        } );


    }
}