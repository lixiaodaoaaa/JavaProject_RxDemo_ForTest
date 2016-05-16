package net.danlew.sample;

import java.util.ArrayList;
import java.util.List;

import bean.Course;
import bean.MyObservable;
import bean.Student;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by lixiaodaoaaa is here you can understand  on 2016/4/20.
 */
public class TestRxJava {
    public static void main(String[] args) {
        new TestRxJava().testFlatMap();
    }

    public void testJustMethod(){
        MyObservable myObservable = new MyObservable();
        Observable observable  = myObservable.getObservable();
        observable.just("daoge", "daoge02", "daoge03", "daoge04", "daoge05", "daoge06");
    }

    public void testFromMethod(){
        List<String> myStrs = new ArrayList<>();
        myStrs.add("daoge");
        myStrs.add("dao02");
        myStrs.add("shabi");
        myStrs.add("sha2");
        myStrs.toArray();
        MyObservable  myObservable = new MyObservable();
        Observable observable  = myObservable.getObservable();
        observable.from(myStrs.toArray());
    }

    private Observable getObservable(){
        return new MyObservable().getObservable();
    }


    public void actionTestMethod(){

        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
               System.out.println("s  is here   " + s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                System.out.println("on errro is Running here you can understand you could do it by youself");
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                System.out.println("complete by lixiaodaoaaa is here you can understand yourself");
            }
        };
//        getObservable().subscribe(onNextAction);
//// 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
//        getObservable().subscribe(onNextAction, onErrorAction);
//// 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        getObservable().subscribe(onNextAction, onErrorAction, onCompletedAction);
    }



    public  void printTest(){
        String[] names ={"daoge","shabi","niubi"};
        getObservable().from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {
                        System.out.println(" name is " + name);
                    }
                });
    }


    public  void testSubscribeOn(){
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.immediate()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(Schedulers.io()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        System.out.println(" number is " + number);
                    }
                });
    }


    public void testMap(){
        Observable.just("liixaodao aaaa is a good boy") // 输入类型 String
                .map(new Func1<String,String>() {
                    @Override
                    public String call(String filePath) { // 参数类型 String
                        return "here is the result  " + filePath;
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }



    public void testFlatMap(){
        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onNext(Course course) {
                System.out.println(course.getName());
            }
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }
        };
        Observable.from(getStudents())
                .flatMap(
                        student -> Observable.from(student.getListCourse())
                ).subscribe(subscriber);
    }


    private Student[] getStudents(){
        List<Course> courseListA = new ArrayList<>();
        courseListA.add(new Course("aaa"));
        courseListA.add(new Course("aa2"));
        courseListA.add(new Course("aa3"));
        courseListA.add(new Course("aa4"));
        List<Course> courseListB = new ArrayList<>();
        courseListA.add(new Course("bbb1"));
        courseListA.add(new Course("bb2"));
        courseListA.add(new Course("bbb3"));
        courseListA.add(new Course("bb4"));
        Student studentA  = new Student("A",courseListA);
        Student studentB  = new Student("B",courseListB);
        return new Student[]{studentA,studentB};
    }
}
