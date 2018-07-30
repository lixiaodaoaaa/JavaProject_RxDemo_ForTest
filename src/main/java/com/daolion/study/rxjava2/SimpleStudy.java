package com.daolion.study.rxjava2;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/30
       Time     :  22:41
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

public class SimpleStudy {


    public static void main(String[] args) {


        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(8);
            emitter.onNext(11);
            emitter.onComplete();

            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);
            emitter.onNext(3);

        }).subscribe(integer -> System.out.println(" I  get this number is here :   ---->  " + integer));

    }
}
