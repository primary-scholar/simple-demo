package com.mimu.simple.java.generic;


/**
 * author: mimu
 * date: 2019/10/18
 */

/**
 * Tips
 * <p>
 * 类上使用 <T> 代表该类是一个 泛型类
 *
 * @param <T>
 */
public class GenericClazz<T> {

    /**
     *  泛型方法 这里的返回值 T 和 参数中的类型 T 一致，但和范型类中的 参数类型 无关；
     *  该方法中的 T 的类型 和泛型类中的 <T> 是毫无关系的 类型(可相同，可不同)
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T getB(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    /**
     * 普通方法 该方法返回值 必须和范型类的 类型一致
     * 此处的 T 和泛型类中的 T 必须相同
     *
     * @param tClass
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public T getA(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    /**
     * 普通方法  此处的 T 和泛型类中的 T 必须相同
     *
     * @param t
     */
    public void print(Class<T> t) {
        System.out.println(t.getCanonicalName());
    }

}
