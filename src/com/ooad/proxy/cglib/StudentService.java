package com.ooad.proxy.cglib;

import com.ooad.proxy.cglib.Student;

/**
 * 接口的一个简单实现
 *
 * @author HXY
 * @since 2020-5-9
 */
public class StudentService {
    public void save(Student s) {
        System.out.println("save..............");
    }

    public void delete(long id) {
        System.out.println("delete..............");
    }

    public Student find(long id) {
        System.out.println("find..............");
        return new Student();
    }

    public void update(int age) {
        System.out.println("update..............");
    }
}
