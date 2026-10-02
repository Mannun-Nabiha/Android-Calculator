package com.example.cse489_project_final2;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    Button button1, button2, button3, button4, button5, button6;
    Button button7, button8, button9, button10, button11, button12;
    Button button13, button14, button15, button16, button17, button18;

    double firstNumber = 0;
    String operator = "";
    boolean newNumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);


        button3.setOnClickListener(v -> addNumber("7"));
        button4.setOnClickListener(v -> addNumber("8"));
        button5.setOnClickListener(v -> addNumber("9"));
        button7.setOnClickListener(v -> addNumber("4"));
        button8.setOnClickListener(v -> addNumber("5"));
        button9.setOnClickListener(v -> addNumber("6"));
        button11.setOnClickListener(v -> addNumber("1"));
        button12.setOnClickListener(v -> addNumber("2"));
        button13.setOnClickListener(v -> addNumber("3"));
        button16.setOnClickListener(v -> addNumber("0"));
        button15.setOnClickListener(v -> {

            if (newNumber) {
                number1.setText("0.");
                newNumber = false;
                return;
            }

            String value = number1.getText().toString();

            if (!value.contains(".")) {

                if (value.isEmpty()) {
                    number1.setText("0.");
                } else {
                    number1.append(".");
                }
            }
        });
        button6.setOnClickListener(v -> setOperator("÷"));
        button10.setOnClickListener(v -> setOperator("×"));
        button14.setOnClickListener(v -> setOperator("−"));
        button18.setOnClickListener(v -> setOperator("+"));
        button17.setOnClickListener(v -> calculate());

        button2.setOnClickListener(v -> {

            number1.setText("");
            firstNumber = 0;
            operator = "";
            newNumber = false;
        });

        button1.setOnClickListener(v -> {
        });
    }

    private void addNumber(String number) {

        if (newNumber) {
            number1.setText("");
            newNumber = false;
        }

        number1.append(number);
    }
    private void setOperator(String op) {

        String value = number1.getText().toString();

        if (value.isEmpty()) {
            return;
        }

        firstNumber = Double.parseDouble(value);
        operator = op;

        // Next number will be entered
        newNumber = true;
    }

    private void calculate() {

        String value = number1.getText().toString();

        if (value.isEmpty() || operator.isEmpty()) {
            return;
        }

        double secondNumber = Double.parseDouble(value);
        double result = 0;


        if (operator.equals("+")) {

            result = firstNumber + secondNumber;

        } else if (operator.equals("−")) {

            result = firstNumber - secondNumber;

        } else if (operator.equals("×")) {

            result = firstNumber * secondNumber;

        } else if (operator.equals("÷")) {

            if (secondNumber == 0) {
                number1.setText("Error");
                operator = "";
                return;
            }

            result = firstNumber / secondNumber;
        }


        // Show result without .0 for whole numbers
        if (result == (long) result) {

            number1.setText(String.valueOf((long) result));

        } else {

            number1.setText(String.valueOf(result));
        }


        operator = "";
        newNumber = true;
    }
}
