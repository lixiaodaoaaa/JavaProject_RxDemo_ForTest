package com.daolion.study;

import rx.Observable;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  14:38
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class Empty{
    
    public static void main(String[] args){
    
        Observable.never();
        Observable observableStr =      Observable.just(new Empty().createStr());
        
    }
    
    
    public String createStr(){
        return "lixiaodaoaaa is a goodboy";
    }
}
