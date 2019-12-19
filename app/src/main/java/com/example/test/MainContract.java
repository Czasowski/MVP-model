package com.example.test;

public interface MainContract {

    interface View {
     void makeText(String text);
    }

    interface Presenter {
        void plus();
        String totalNum();
        void saveQs();
    }
     interface Model {
        void saveQ(String text);
        String getQ();
     }
}
