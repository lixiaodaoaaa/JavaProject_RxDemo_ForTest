package com.daolion.study.subject;

import rx.Observer;
import rx.subjects.ReplaySubject;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  15:19
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class Replay{
    
    public static void main(String[] args){
    
    
        ReplaySubject<String> replaySubject = ReplaySubject.create();
    
        replaySubject.subscribe(new Observer<String>(){
            @Override
            public void onCompleted(){
        
            }
    
            @Override
            public void onError(Throwable e){
        
            }
    
            @Override
            public void onNext(String s){
                System.out.println(" replay is "+s);
            }
        });
    
        replaySubject.onNext("lixiaodoaaaa is a goodboy");
    
        
    
    }
}
