package com.daolion.study;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  13:59
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class FromStudy{
    
    public static void main(String[] args){
        List<Integer> listInt=new ArrayList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        listInt.add(6);
        listInt.add(7);
        listInt.add(8);
        listInt.add(9);
        listInt.add(10);
        listInt.add(11);
        listInt.add(12);
        listInt.add(13);
        listInt.add(14);
        listInt.add(15);
        
        Observable.from(listInt).subscribe(new Observer<Integer>(){
            @Override
            public void onCompleted(){
                System.out.println(" onCompleted is ");
            }
            
            @Override
            public void onError(Throwable e){
                System.out.println(" onError is ");
            }
            
            @Override
            public void onNext(Integer integer){
                System.out.println(" item is " + integer);
            }
        });
    }
}
