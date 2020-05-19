package com.ooad.proxy.jdk;

/**
 * 接口的一个简单实现
 *
 * @author HXY
 * @since 2020-5-9
 */
public class StudentServiceImpl implements IStudentService{
    @Override
    public void save(Student s) {
        System.out.println("save..............");
    }

    @Override
    public void delete(long id) {
        System.out.println("delete..............");
    }

    @Override
    public Student find(long id) {
        System.out.println("find..............");
        return new Student();
    }

    @Override
    public void update(int age) {
        System.out.println("update..............");
    }
}
