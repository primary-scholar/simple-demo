package com.mimu.simple.java.seriali.model;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 自定义 序列化 和反序列化
 * <p>
 * 还可以 实现 Externalizable
 * 并复写 writeExternal() 和 readExternal() 方法 可达到同样的效果
 */

@Setter
@Getter
public class PeopleAnother implements Serializable {
    private String name;
    private int age;

    /**
     * 重写 writeObject 方法 1
     *
     * @param objectOutputStream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.getName() + "writeObject");

    }

    /**
     * 重写 writeObject 方法 2
     * @param
     * @throws IOException
     */
        /*private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.getName() + "writeObject");
            objectOutputStream.writeObject(this.getAge() + 1);
        }*/

    /**
     * 重写 readObject 方法 1
     *
     * @param objectInputStream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.setName(objectInputStream.readObject() + "readObject");
    }

    /**
     * 重写 readObject 方法 2
     * @param objectInputStream
     * @throws IOException
     * @throws ClassNotFoundException
     */
        /*private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.setName((String) objectInputStream.readObject());
            this.setAge((Integer) objectInputStream.readObject());
        }*/

}
