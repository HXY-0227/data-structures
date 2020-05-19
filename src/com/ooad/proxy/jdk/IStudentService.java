package com.ooad.proxy.jdk;

/**
 * Service接口 处理学生的相关业务
 *
 * @author HXY
 * @since 2020-5-9
 */
public interface IStudentService {
    void save(Student s);
    void delete(long id);
    Student find(long id);
    void update(int age);
}
