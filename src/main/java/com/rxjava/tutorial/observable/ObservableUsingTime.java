package com.rxjava.tutorial.observable;

import com.rxjava.tutorial.observer.DemoObserver;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableUsingTime {

    public static void main(String args[]) {

        usingTimer();

        usingInterval();
    }

    private static void usingTimer() {
        Observable.timer(1, TimeUnit.SECONDS).subscribe(new DemoObserver());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void usingInterval() {
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new DemoObserver());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
