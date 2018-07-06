package com.daolion.study.subject;

import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.subjects.PublishSubject;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  15:06
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class Publish2{
    
    
    public static void main(String[] args){
        final PublishSubject<Boolean> subject=PublishSubject.create();
        
        subject.subscribe(new Observer<Boolean>(){
            @Override
            public void onCompleted(){
            
            }
            
            @Override
            public void onError(Throwable e){
            
            }
            
            @Override
            public void onNext(Boolean aBoolean){
                System.out.println("Observable onNext value is " + aBoolean);
            }
        });
        
        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
            for (int i=0; i < 5; i++) {
                subscriber.onNext(i);
            }
            subscriber.onCompleted();
        }).doOnCompleted(new Action0(){
            @Override
            public void call(){
                subject.onNext(true);
            }
        }).subscribe();
    }
}
