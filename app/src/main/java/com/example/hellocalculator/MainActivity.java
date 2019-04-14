package com.example.hellocalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText firstNumEditText;
    EditText secondNumEditText;
    TextView resultTextView;
    Button addBtn;
    Button minusBtn;
    Button timesBtn;
    Button divideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
        secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        addBtn = (Button) findViewById(R.id.addBtn);
        minusBtn = (Button) findViewById(R.id.subBtn);
        timesBtn = (Button) findViewById(R.id.timesBtn);
        divideBtn = (Button) findViewById(R.id.divideBtn);

        firstNumEditText.addTextChangedListener(textWatcher);
        secondNumEditText.addTextChangedListener(textWatcher);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Closes keyboard on button press
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(result + "");

            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Closes keyboard on button press
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 - num2;
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(result + "");

            }
        });
        timesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Closes keyboard on button press
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 * num2;
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(result + "");

            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Closes keyboard on button press
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 / num2;
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(result + "");

            }
        });
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

        @Override
        public void afterTextChanged(Editable s) {
            String num1Input = firstNumEditText.getText().toString().trim();
            String num2Input = secondNumEditText.getText().toString().trim();

            addBtn.setEnabled(!num1Input.isEmpty() && !num2Input.isEmpty());
            minusBtn.setEnabled(!num1Input.isEmpty() && !num2Input.isEmpty());
            timesBtn.setEnabled(!num1Input.isEmpty() && !num2Input.isEmpty());

            //Checks if either of the inputs are a 0 to prevent dividing by 0
            String tmp = s.toString().trim().toLowerCase();
            if(!tmp.contains("0")){
                divideBtn.setEnabled(!num1Input.isEmpty() && !num2Input.isEmpty());
            }
        }
    };
}