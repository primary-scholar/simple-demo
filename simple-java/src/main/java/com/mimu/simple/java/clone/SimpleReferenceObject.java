package com.mimu.simple.java.clone;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 使用第三方 类库
 * Apache Commons BeanUtils 的 BeanUtils.cloneBean()
 * 或
 * spring 的 ObjectUtils.clone()
 * 可以很方便的实现深度 copy
 */

@Setter
@Getter
public class SimpleReferenceObject implements Serializable, Cloneable {
    private Integer id;
    /**
     * 对于引用 不可变类型字段，使用浅拷贝 两个对象之间不影响
     */
    private String name;
    /**
     * 对于引用 可变类型的字段，使用浅拷贝，两个对象之间互相影响；
     */
    private Set<Integer> scoreSet;
    /**
     * 对于引用 可变类型的字段，使用浅拷贝，两个对象之间互相影响；
     */
    private List<String> majorList;

    /**
     * 对于引用 符合类型，符合类型对象的改变，同样会相互影响；
     */
    private InnerReferenceObject innerReference;

    @Setter
    @Getter
    public static class InnerReferenceObject implements Serializable, Cloneable {
        private Integer id;
        private String name;

        @Override
        public InnerReferenceObject clone() {
            try {
                return (InnerReferenceObject) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    @Override
    protected SimpleReferenceObject clone() throws CloneNotSupportedException {
        try {
            return (SimpleReferenceObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
