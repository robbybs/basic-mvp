package com.ryse.mvp.base;

public interface Presenter <V extends View> {

    void attachView(V view);

    void detachView();
}
