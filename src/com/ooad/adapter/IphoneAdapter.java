package com.ooad.adapter;

/**
 * 把Iphone适配成TypeC，实现了Typec接口
 *
 * @author HXY
 * @since 2020-5-2
 */
public class IphoneAdapter implements TypeC{

    // 持有Iphone的引用
    final Iphone iphone;

    public IphoneAdapter(Iphone iphone) {
        this.iphone = iphone;
    }

    // 在Typec的方法里调用的是iphone的方法，将iphone适配成Typec
    @Override
    public void transportSoundWithTpyeC() {
        iphone.transportSoundWithIphone();
    }
}
