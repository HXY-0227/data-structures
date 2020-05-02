package com.ooad.adapter;

public class Test {
    public static void main(String[] args) {
        TypeC typeC = new IphoneAdapter(new IphoneX());
        typeC.transportSoundWithTpyeC();

    }
}
