package com.example.weightconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.textedit);
        button = findViewById(R.id.butt);
        textView = findViewById(R.id.viewtext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString().trim();

                if (!input.isEmpty()) {
                    try {
                        double kilos = Double.parseDouble(input);
                        double pounds = conversion(kilos);
                        textView.setText(String.format("%.2f",pounds) + " lb");
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a value.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public double conversion(double kilos) {
        return kilos * 2.20462;
    }
}
