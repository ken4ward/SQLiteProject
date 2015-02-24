package com.example.ken4ward.sqliteproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    EditText addInputTextbox;
    TextView databaseReportText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addInputTextbox  = (EditText) findViewById(R.id.addInputTextbox);
        databaseReportText = (TextView) findViewById(R.id.databaseReportText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        Product product = new Product(addInputTextbox.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputText = addInputTextbox.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        databaseReportText.setText(dbString);
        addInputTextbox.setText("");
    }
}
