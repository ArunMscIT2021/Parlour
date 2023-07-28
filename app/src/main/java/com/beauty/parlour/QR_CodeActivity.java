package com.beauty.parlour;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QR_CodeActivity extends AppCompatActivity {
    private ImageView qrCodeImageView;
    private EditText edt_upi_id,edt_amt;
    private Button btn_generate;
    String upiId;
    String amount;

    String trxNo = "123456"; // Replace with the transaction number
    String trxRef = "ABCDEF"; // Replace with the transaction reference
    String name = "Receiver Name"; // Replace with the receiver's name

    String currencyCode = "INR";
    String transactionNote = "Payment for XYZ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        qrCodeImageView = findViewById(R.id.qrCodeImageView);
        edt_amt=findViewById(R.id.edt_amt);
        edt_upi_id=findViewById(R.id.edt_upi_id);
        btn_generate=findViewById(R.id.btn_generate);


        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upiId=edt_upi_id.getText().toString();
                amount=edt_amt.getText().toString();
                if (upiId.isEmpty() ||amount.isEmpty()){
                    Toast.makeText(QR_CodeActivity.this, "please fill the amount and upi id", Toast.LENGTH_SHORT).show();
                }else {
                    // Create the UPI payment QR code
                    // Create the UPI payment URL
                    String upiPaymentUrl = "upi://pay?pa=" + upiId +
                            "&pn=" + name +
                            "&tn=" + trxNo +
                            "&tr=" + trxRef +
                            "&am=" + amount +
                            "&cu=INR" +
                            "&purpose=" + "testing";

                    Bitmap qrCodeBitmap = generateQRCode(upiPaymentUrl);

                    // Set the QR code image to the ImageView
                    qrCodeImageView.setImageBitmap(qrCodeBitmap);
                }
            }
        });


    }

    private Bitmap generateQRCode(String content) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap qrBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    qrBitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }

            return qrBitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}