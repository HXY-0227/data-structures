package com.ooad.templateMethod;

/**
 * 子类，继承抽象类，实现个性化方法
 *
 * @author HXY
 * @since 2020-05-02
 */
public class Idea extends SoftwareDevelopment{
    @Override
    protected void design() {
        System.out.println("-----design IDEA-----");
    }

    @Override
    protected void coding() {
        System.out.println("-----coding IDEA-----");
    }

    @Override
    protected void test() {
        System.out.println("-----test IDEA-----");
    }
}
