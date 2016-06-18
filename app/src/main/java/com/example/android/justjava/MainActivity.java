package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int price = 5;
    int qty = 1;
    int whipped_price = 1;
    int chocolatos_price = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
        displayPrice(qty*price);
    }

    public void kurangiQty(View view) {
        if(qty==1) return;

        this.qty--;
        display(qty);
    }

    public void tambahQty(View view){
        if(qty==10) return;

        this.qty++;
        display(qty);
    }

    /**
     * display hasil ke qty
     * @param number
     */
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }

    private void displayPrice(int number){
        String summary = "";

        EditText customer = (EditText) findViewById(R.id.edit_customer);
        summary = summary + customer.getText().toString() + "\n";

        CheckBox cbWhippedCream = (CheckBox) findViewById(R.id.cb_whipped_cream);
        if(cbWhippedCream.isChecked()) {
            number += whipped_price * qty;
            summary = summary + cbWhippedCream.getText().toString() + "\n";
        }

        CheckBox cbChocolatos = (CheckBox) findViewById(R.id.cb_chocolatos);
        if(cbChocolatos.isChecked()) {
            number += chocolatos_price * qty;
            summary = summary + cbChocolatos.getText().toString() + "\n";
        }

        summary = summary + NumberFormat.getCurrencyInstance().format(number);

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(summary);
    }
}
