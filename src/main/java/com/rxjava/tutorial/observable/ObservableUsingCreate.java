package com.rxjava.tutorial.observable;

import com.rxjava.tutorial.models.Shape;
import com.rxjava.tutorial.observer.DemoObserver;
import com.rxjava.tutorial.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.util.List;

public class ObservableUsingCreate {


    public static void main(String args[]) {
        List<Shape> shapes = RxUtils.getShapes(5);
        getCreateObservable(shapes).subscribe(new DemoObserver());
    }

    private static Observable<Object> getCreateObservable(List<Shape> shapes) {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                try {
                    shapes.forEach(observableEmitter::onNext);
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
                observableEmitter.onComplete();
            }
        });
    }
}
