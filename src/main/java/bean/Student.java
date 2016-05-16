package bean;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class Student {
    private String name;
    List<Course>  listCourse;

    public Student(String name, List<Course> listCourse) {
        this.name = name;
        this.listCourse = listCourse;
    }


    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
