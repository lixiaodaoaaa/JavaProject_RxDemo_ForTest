package com.daolion.study.subject;

import rx.Observer;
import rx.subjects.PublishSubject;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  14:51
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class Publish{
    
    
    public static void main(String[] args){
        PublishSubject<String> publishSubject=PublishSubject.create();
        
        publishSubject.subscribe(new Observer<String>(){
            @Override
            public void onCompleted(){
                System.out.println("here is onCompleted");
            }
            
            @Override
            public void onError(Throwable e){
            
            }
            
            @Override
            public void onNext(String s){
                System.out.println("newxt is " + s);
            }
        });
        
        publishSubject.onNext("lixiaodoaaaa is a goodboy");
        
        publishSubject.onCompleted();
        ;
    }
}
