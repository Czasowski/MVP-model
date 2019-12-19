package com.example.test;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter{
    private MainContract.Model mModel;
    private MainContract.View mView;
    private int numPlus = 0;
    private String  sNumPlus = "";

    MainPresenter(MainContract.View mView, Context context) {
        this.mView = mView;
        mModel = new MainModel(context);
    }

    @Override
    public void plus() {
        numPlus++;
        sNumPlus= Integer.toString(numPlus);
        // тут налл летит по нажатию. это не удивительно, ведь презенторй твой,
        // это сухая логика должна быть. и ты на вьюху должен говорить
        // по нажатию на нее презентер.плюс() посчитай мне
        // и результат счета отобрази, сохрани в шареды(прослойка модели)
        // налл летит с интерфейса. там же данных нет. вот и налл. либо ты данные не прокинул

        mView.makeText(sNumPlus);
    }

    @Override
    public String totalNum() {
        String total;
        total = mModel.getQ();
        return total;
    }

    @Override
    public void saveQs() {
        mModel.saveQ(sNumPlus);
    }

}
