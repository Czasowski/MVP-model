package com.example.test;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainContract.View {
private MainContract.Presenter mPresenter;
    private TextView numOfClick;
    private TextView totalOfCLick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("RANGER",0);
        mPresenter = new MainPresenter(this);

        numOfClick = findViewById(R.id.textView2);
        totalOfCLick = findViewById(R.id.textView3);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mPresenter.plus();
            }
        });
    }

    @Override
    public void makeText(String text) {
      numOfClick.setText(text);
      totalOfCLick.setText(mPresenter.totalNum());
    }
}
