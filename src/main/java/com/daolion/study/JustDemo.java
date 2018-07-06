package com.daolion.study;

import rx.Observable;
import rx.Observer;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  14:05
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class JustDemo{
    
    public static void main(String[] args){
        
        Observable.just(creatStr()).subscribe(new Observer<String>(){
            @Override
            public void onCompleted(){
                System.out.println("onCompleted here");
            }
            
            @Override
            public void onError(Throwable e){
                System.out.println(" onError is " + e.getMessage());
                
            }
            
            @Override
            public void onNext(String s){
                System.out.println(" onNext is " + s);
            }
        });
        
    }
    
    
    private static String creatStr(){
        return " lixiaodaoaaa is a goodboy";
    }
}
