package com.ooad.simplefactory;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class SimpleFactory {

    public static CodeLanguage getLanguage(String type) {
        CodeLanguage language = null;
        switch (type) {
            case "java":
                language = new Java();
                break;
            case "c":
                language = new C();
                break;
            case "python":
                language = new Python();
                break;
            default:
                break;
        }
        return language;
    }
}
