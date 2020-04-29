package com.rxjava.tutorial.observable;

import com.rxjava.tutorial.observer.DemoObserver;
import io.reactivex.Observable;

public class ObservableUsingRange {
    public static void main(String args[]) {
        Observable.range(5, 6).subscribe(new DemoObserver());
    }
}
