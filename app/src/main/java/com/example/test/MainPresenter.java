package com.example.test;


import android.content.Context;

public class MainPresenter implements MainContract.Presenter{
    private MainContract.Model mModel;
    private MainContract.View mView;
    private int numPlus = 0;

    MainPresenter(MainContract.View mView) {
        this.mView = mView;
        MainModel mModel = new MainModel(Context);
    }

    @Override
    public void plus() {
        numPlus++;
        String sNumPlus = Integer.toString(numPlus);
        mView.makeText(sNumPlus);
        mModel.saveQ(sNumPlus);
    }

    @Override
    public String totalNum() {
        String total;
        total = mModel.getQ();
        return total;
    }

}
