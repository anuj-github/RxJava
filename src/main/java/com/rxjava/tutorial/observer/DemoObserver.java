package com.rxjava.tutorial.observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoObserver implements Observer {
    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("On Subscribe");
    }

    @Override
    public void onNext(Object o) {
        System.out.println("On Next " + o);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("On error ");
    }

    @Override
    public void onComplete() {
        System.out.println("On complete");
    }
}
