package com.mimu.simple.java.klass.thiz.contra;

public class Outer {

    SubClazz newObject() {
        OtherClazz clazz = new OtherClazz();
        return new SubClazz(clazz);
    }


    class SubClazz extends AbstractParentClazz {
        private String innerField;

        public SubClazz(OtherClazz clazz) {
            super(clazz);
            this.innerField = "subclazz inner filed";
        }

    }
}
