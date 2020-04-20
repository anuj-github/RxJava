package com.rxjava.tutorial.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class JustObservable {

    public static void main(String args[]) {

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        justObserver();
    }

    /**
     * from operator will make N emission , N = size of array
     *
     * @param numbers
     */
    private static void arrayFrom(Integer[] numbers) {
        System.out.println();
        System.out.println("From array");
        Observable.fromArray(numbers).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("on Next " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("on Error");
            }

            @Override
            public void onComplete() {
                System.out.println("on Complete");
            }
        });
    }

    /**
     * Just takes whole array as one item and emits it as observable
     *
     * @param numbers
     */
    private static void arrayJust(Integer[] numbers) {
        System.out.println();
        System.out.println("From just");
        Observable.just(numbers).subscribe(new Observer<Integer[]>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Subscribe");
            }

            @Override
            public void onNext(Integer[] integers) {
                System.out.println("on Next");
                for (int i : integers) {
                    System.out.print(i + " ");
                }
                System.out.println();
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

    /**
     * Just emits max 10 items.
     */
    private static void justObserver() {
        getObservable().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("on Subscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("on Next " + s);
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

    private static Observable<String> getObservable() {
        return Observable.just("a", "b", "c", "d", "a", "b", "c", "d", "e", "f");
    }
}
