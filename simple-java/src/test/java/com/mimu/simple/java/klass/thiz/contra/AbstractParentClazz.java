package com.mimu.simple.java.klass.thiz.contra;


public class AbstractParentClazz {
    private String field;
    private OtherClazz clazz;

    public AbstractParentClazz(OtherClazz clazz) {
        this.clazz = clazz;
        clazz.attach = this;
        field = "abstract parent class filed";
    }

}
