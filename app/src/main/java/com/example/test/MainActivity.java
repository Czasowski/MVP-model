package com.example.test;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    SharedPreferences pref;
private MainContract.Presenter mPresenter;
private MainContract.Model mModel;
    private TextView numOfClick;
    private TextView numsOfCLick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("RANGER",0);
        mPresenter = new MainPresenter(this);

        numOfClick = findViewById(R.id.textView2);
        numsOfCLick = findViewById(R.id.textView3);
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
      numsOfCLick.setText(mPresenter.totalNum());
    }
}
