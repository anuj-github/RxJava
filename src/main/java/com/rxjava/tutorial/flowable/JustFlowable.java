package com.rxjava.tutorial.flowable;

import com.rxjava.tutorial.observer.FlowObserver;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class JustFlowable {

    public static void main(String ...args){
        JustFlowable jft = new JustFlowable();
        jft.getFlowable()
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new FlowObserver<>(4));


        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }

    public Flowable<String> getFlowable(){
       return Flowable.just("a", "b", "c", "d", "a", "b", "c", "d", "e", "f");
    }

}
