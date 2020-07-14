package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConvert(View view) {
        EditText convertAmount = (EditText) findViewById(R.id.editCurrencyValue);
        String amountUSD = convertAmount.getText().toString();
        double toUSD = Double.parseDouble(amountUSD) * 23000;

        String amountInVND = String.format("%.2f", toUSD);
        String formattedVND = currencyFormat(amountInVND);

        Toast.makeText(this, "You'll get  " + formattedVND + " VND", Toast.LENGTH_LONG).show();
    }

    public static String currencyFormat(String amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(Double.parseDouble(amount));
    }
}
