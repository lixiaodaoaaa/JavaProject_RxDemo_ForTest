package com.daolion.study.subject;

import rx.Observer;
import rx.subjects.BehaviorSubject;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  15:17
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class Behaviou{
    
    
    public static void main(String[] args){
        
        BehaviorSubject<Integer> integerBehaviorSubject=BehaviorSubject.create(1);
        
        
        integerBehaviorSubject.subscribe(new Observer<Integer>(){
            @Override
            public void onCompleted(){
            
            }
            
            @Override
            public void onError(Throwable e){
            
            }
            
            @Override
            public void onNext(Integer integer){
                System.out.println("value is " + integer);
            }
        });
    }
}
