package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {
    /*This just makes shorter code for Log.i(TAG) instead of putting in "DemoInitialApp"*/
    private static final String TAG = "DemoInitialApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
/*Tokenizer allows the " , " after each category in the add products layout.*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Categories);
        MultiAutoCompleteTextView textView = findViewById(R.id.Mactv);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

/*This is creating the "Product added message when the "Add Product button is clicked after
* inputting all the information like SKU, Inventory, Price etc...*/
        Button addProduct = (Button) findViewById(R.id.buttonAddProduct);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Product added log.");
                Toast.makeText(getApplicationContext(), "Product added", Toast.LENGTH_SHORT)
                        .show();
                /*When you click the button, you are going to a new activity.*/
                Intent intent = new Intent(AddProduct.this, ProductList.class);
                startActivity(intent);
            }
        });
    }
/*The categories for products in the add products page.*/
    private static final String[] Categories = new String[] {
            "Accessories", "Adult", "Appliance", "Art", "Baby", "Beauty", "Bird", "Books", "Candy",
            "Car", "Cat", "Cleaning", "Cooking", "Computer", "Dog", "Drink", "Electronic", "Entertainment",
            "Food", "Games", "Hand Made", "Health", "Home Improvement", "Kids", "Kitchen", "Light",
            "Music", "Office", "Parts", "Pets", "Phone", "Sewing", "Shoes", "Snake", "Sneakers",
            "Software", "Sports", "Supplies", "Tools", "Toys", "Turtle", "Video Games"
    };

}
