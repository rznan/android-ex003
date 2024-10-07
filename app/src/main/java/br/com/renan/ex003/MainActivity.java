package br.com.renan.ex003;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
*@author:<renan santos carvalho>
*/
public class MainActivity extends AppCompatActivity {

    private EditText etValueA;
    private EditText etValueMaior;
    private EditText etValueMenor;
    private Button   calculateButton;
    private TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValueA = findViewById(R.id.etValueA);
        etValueMenor = findViewById(R.id.etValueMenor);
        etValueMaior = findViewById(R.id.etValueMaior);
        calculateButton = findViewById(R.id.calculateButton);
        results = findViewById(R.id.results);

        calculateButton.setOnClickListener(e -> calcular());
    }

    private void calcular() {
        double altura = Double.parseDouble(etValueA.getText().toString());
        double baseMaior = Double.parseDouble(etValueMaior.getText().toString());
        double baseMenor = Double.parseDouble(etValueMenor.getText().toString());
        double area = ((baseMaior + baseMenor) * altura)/2;
        String tmp = getString(R.string.resultado) + " " + area;
        results.setText(tmp);
    }
}