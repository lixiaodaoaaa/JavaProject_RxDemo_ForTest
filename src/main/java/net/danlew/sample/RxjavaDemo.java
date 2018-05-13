package net.danlew.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean.Course;
import bean.Student;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Administrator on 2016/4/20.
 */
public class RxjavaDemo {

    public static void main(String[] args) {
        
        System.out.println("hello");
//          Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello Rxjava");
//                //Notice 如果onCompleted 先调用了,那么后面的onNext onError则会被无视掉,但是不是等同于return,后面其他的代码还是会执行
//                subscriber.onCompleted();
//                System.out.println("看看onCompleted调用了还会不会有输出");
////            subscriber.onError(new Throwable("hehehe"));
//            }
//           }).subscribe(new Subscriber<String>() {
//             @Override
//             public void onCompleted() {
//                 System.out.println("onCompleted");
//             }
//             @Override
//             public void onError(Throwable e) {
//                 System.out.println("onError:" + e.getMessage());
//             }
//             @Override
//             public void onNext(String s) {
//                 System.out.println(s);
//             }
//         });


//        Observable.just("Hell,simple observable","shabi","001").subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//            @Override
//            public vragradoid onNext(String s) {
//                System.out.println(s);
//            }
//        });

//        Observable.just("Hell,simple observable", "shabi", "001").subscribe(onNextAction);

        new RxjavaDemo().otherTestMethod();
    }


    static Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("Action1<String> onNextAction:" + s);
        }
    };


    public void mapTestMethod(){
        Observable.just("Hellp Map Operator")
                .map(new Func1<String,Integer>() {
                    @Override
                    public Integer call(String s) {
                        return 2015;//通过第一个map转成Integer
                    }
                }).map(new Func1<Integer,String>() {
            @Override
            public String call(Integer integer) {
                return String.valueOf(integer);//再通过第二个map转成String
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }

    public void testFrom(){
        List<String> s = Arrays.asList("Java", "Android", "Ruby", "Ios", "Swift");
        Observable.from(s).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    static Observable<List<String>>     getObservable(){
        List<String> s = Arrays.asList("Java", "Android", "Ruby", "Ios", "Swift");
        return Observable.just(s);
    }

    public void testQuery(){
        getObservable().flatMap(new Func1<List<String>,Observable<?>>() {
            @Override
            public Observable<?> call(List<String> strings) {
                return Observable.from(strings);
            }
        }).subscribe(s -> {
            System.out.println("_flatMap:"+s);
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
                .flatMap(new Func1<Student,Observable<Course>>() {
                  @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getListCourse());
                    }
                }).subscribe(subscriber);
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



    public void otherTestMethod(){
        getObservable().flatMap(new Func1<List<String>,Observable<String>>() {
            @Override
            public Observable<String> call(List<String> strings) {
                return Observable.from(strings);
            }
        }).filter(new Func1<String,Boolean>() {
            @Override
            public Boolean call(String s) {
                //包含a的留下
                return s.contains("a");
            }
        }).take(3)//最多只取3个
         .doOnNext(new Action1<String>() {
             @Override
             public void call(String s) {
                 //onNext之前 输出一下
                 System.out.println("doOnNext:" + s);
             }
         }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}
