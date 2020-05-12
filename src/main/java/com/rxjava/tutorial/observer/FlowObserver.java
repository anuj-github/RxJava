package com.rxjava.tutorial.observer;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowObserver<T> implements Subscriber<T> {

    private Subscription subscription;
    private int bufferSize = 5;
    AtomicInteger atomicInteger = new AtomicInteger();
    public FlowObserver(int bufferSize){
        this.bufferSize = bufferSize;
    }
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(bufferSize);
    }

    @Override
    public void onNext(T t) {

        System.out.println("onNext " + t);
        if(atomicInteger.incrementAndGet()%bufferSize==0){
            subscription.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
