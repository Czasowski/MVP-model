package com.example.test;


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
        numOfClick = findViewById(R.id.textView2);
        totalOfCLick = findViewById(R.id.textView3);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.plus();
            }
        });
        mPresenter = new MainPresenter(this, getApplicationContext());
        totalOfCLick.setText(mPresenter.totalNum());
    }

    @Override
    public void makeText(String text) {
        numOfClick.setText(text);
        int text1 = Integer.parseInt(text) + Integer.parseInt(mPresenter.totalNum());
        String text1ex = Integer.toString(text1);
        totalOfCLick.setText(text1ex);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.saveQs();
    }
}