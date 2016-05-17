package net.danlew.sample;

import java.util.Arrays;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/5/17.
 */
public class TestForRxjavaAgain {


    static Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onCompleted() {
            System.out.println("onCompleted");
            System.out.printf("daoge is onCompleted");
        }
        @Override
        public void onError(Throwable e) {
            System.out.println("onError");
        }
        @Override
        public void onNext(Integer integer) {
            System.out.println(integer);
        }};



    static Observable.OnSubscribe<Integer> onsubscribe = new Observable.OnSubscribe<Integer>() {
        @Override
        public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
//            subscriber.onError(new Exception());
            subscriber.onCompleted();
            subscriber.onError(new Exception());
            subscriber.onNext(2);
        }};


    static void just(){
        Observable.just(1).subscribe(observer);
    }
    static void just2(){
        Observable.just(1,2,3,4,22,33,44,55,66,77).subscribe(observer);
    }

    static void create(){
//        Observable.create(onsubscribe).subscribe(observer);
        just2();
    }

    public static void main(String[] args) {
//        create();
//        from();
//        from2();

//        take();
//        take(22211);
        takeLast(2);
    }


    static void take(){
        Integer arr[] = {1,2,3,4 };
        Observable.from(arr).take(2).subscribe(observer);
    }


    static void take(int num) {
        Integer arr[] = {1,2,3,4 };
        Observable.from(arr).take(num).subscribe(observer);
    }


    static void takeLast(int num){
        Integer arr[] = {1,2,3,4,5,6,7,8,9};
        Observable.from(arr).takeLast(num).subscribe(observer);
    }

    static void from(){
        Integer arr[] = {1,2,3,4 };
        Observable.from(arr).subscribe(observer);
    }
    static void from2(){
        Integer arr[] = {1,2,3,4 ,5,6,7,8,9,10};
        Observable.from(Arrays.asList(arr)).subscribe(observer);
    }
}
