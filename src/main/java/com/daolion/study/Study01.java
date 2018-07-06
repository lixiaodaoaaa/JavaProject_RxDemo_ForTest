package com.daolion.study;

import rx.Observable;
import rx.Observer;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  12:03
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class Study01{
    
    
    public static void main(String[] args){
        
        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
            for (int i=0; i < 5; i++) {
                subscriber.onNext(i);
            }
            subscriber.onCompleted();
        }).subscribe(new Observer<Integer>(){
            @Override
            public void onCompleted(){
                System.out.println(" onCompleted here");
            }
            
            @Override
            public void onError(Throwable e){
                System.out.println(" error here ");
            }
            
            @Override
            public void onNext(Integer integer){
                System.out.println(" Item is " + integer);
            }
        });
        
        
    }
}
