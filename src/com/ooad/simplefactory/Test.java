package com.ooad.simplefactory;

public class Test {
    public static void main(String[] args) {
        CodeLanguage language = SimpleFactory.getLanguage("c");
        language.code();
    }


}
