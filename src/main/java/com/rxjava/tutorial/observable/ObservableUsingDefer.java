package com.rxjava.tutorial.observable;

import com.rxjava.tutorial.models.Shape;
import com.rxjava.tutorial.observer.DemoObserver;
import com.rxjava.tutorial.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.List;
import java.util.concurrent.Callable;

public class ObservableUsingDefer {

    String name = "Default";
    public static void main(String args[]){
        ObservableUsingDefer defer = new ObservableUsingDefer();
        Observable<String> normal = defer.getNormal();
        Observable<String> deferable = defer.getDefer();
        defer.name = "Changed";
        // normal.subscribe(new DemoObserver());
        deferable.subscribe(new DemoObserver());
    }

    private static Observable<Object> getDeferObservable(List<Shape> shapes) {
        return Observable.defer((Callable<ObservableSource<Object>>) () ->
                Observable.fromIterable(shapes)
        );
    }

    /**
     * Observable is created when its called
     * @return
     */
    private Observable<String> getNormal(){
        return Observable.just(name);
    }

    /**
     * Defer create observable when subscribe is called
     * @return
     */
    private Observable<String> getDefer(){
        return Observable.defer(() -> Observable.just(name));
    }

}
