package com.example.samuel.gasosamaneira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekGas;
    private SeekBar seekAlcohol;

    private TextView gasPriceTextView;
    private TextView alcoholPriceTextView;

    private TextView bestChoiceTextView;
    private ImageView imageBestChoice;

    private double GasValue;
    private double AlcoholValue;

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekGas = (SeekBar) findViewById(R.id.seekGas);
        seekAlcohol = (SeekBar) findViewById(R.id.seekAlcohol);
        alcoholPriceTextView = (TextView) findViewById(R.id.alcoholPriceTextView);
        gasPriceTextView = (TextView) findViewById(R.id.gasPriceTextView);
        imageBestChoice = (ImageView) findViewById(R.id.imageBestChoice);
        bestChoiceTextView = (TextView) findViewById(R.id.bestChoiceTextView);

        alcoholPriceTextView.setText(currencyFormat.format(0.0));
        gasPriceTextView.setText(currencyFormat.format(0.0));

        seekGas.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        CalculateValues();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        seekAlcohol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                CalculateValues();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void CalculateValues() {
        AlcoholValue = seekAlcohol.getProgress();
        GasValue = seekGas.getProgress();


        alcoholPriceTextView.setText(currencyFormat.format(AlcoholValue));
        gasPriceTextView.setText(currencyFormat.format(GasValue));

        boolean IsGas = (AlcoholValue / GasValue >= 0.7);

        if (IsGas){
            bestChoiceTextView.setText(getString(R.string.bestChoiceGas));
            imageBestChoice.setImageResource(R.drawable.gasolina);
        }
        else{
            bestChoiceTextView.setText(getString(R.string.bestChoiceAlcohol));
            imageBestChoice.setImageResource(R.drawable.etanol);
        }
    }
}
