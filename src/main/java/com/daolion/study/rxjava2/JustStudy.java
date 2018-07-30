package com.daolion.study.rxjava2;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/31
       Time     :  00:49
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import io.reactivex.Observable;

public class JustStudy {

    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4, 5, 6).subscribe(integer -> System.out.println("  " + integer));


        Observable.fromArray(1, 34, 333).subscribe(integer -> System.out.println("    " + integer));
    }
}
