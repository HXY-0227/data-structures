package com.ooad.templateMethod;

/**
 * 抽象类，定义模板方法，实现共同的逻辑
 *
 * @author HXY
 * @since 2020-05-02
 */
public abstract class SoftwareDevelopment {
    // 这两个方法是每个软件研发都一样的部分
    private final void begin() {
        System.out.println("----------begin()----------");
    }
    private final void end() {
        System.out.println("----------end()----------");
    }

    // 设计、编码、测试是每个软件研发都经过的，但是每个软件的具体实现是不一样的，
    // 定义成protected, 只能子类重写
    protected abstract void design();
    protected abstract void coding();
    protected abstract void test();

    // 算法基本流程可能不怎么变化，在这里直接定义成final的，防止子类重写
    public final void development() {
        begin();
        design();
        coding();
        test();
        end();
    }
}
