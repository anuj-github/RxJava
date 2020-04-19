package com.rxjava.tutorial;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class JustObservable {

    public static void main(String args[]){

        getObservable().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("on Subscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("on Next "+s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("on Error");
            }

            @Override
            public void onComplete() {
                System.out.println("on complete");
            }
        });
    }

    private static Observable<String> getObservable(){

        return Observable.just("a", "b", "c", "d", "a", "b", "c", "d", "e", "f");

    }
}
