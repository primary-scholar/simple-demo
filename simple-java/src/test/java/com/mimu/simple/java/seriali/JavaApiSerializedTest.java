package com.mimu.simple.java.seriali;

import com.mimu.simple.java.abase.Person;
import com.mimu.simple.java.seriali.model.People;
import com.mimu.simple.java.seriali.model.Student;
import org.junit.Test;

import java.io.*;

/**
 * author: mimu
 * date: 2019/10/5
 */

/**
 * jdk 序列化过程
 * <p>
 * <p>
 * 序列化过程 outputStream.writeObject(people);
 * 1、输出对象的 类描述(元数据)信息
 * 11、输出新对象 tc_object 标志位
 * 12、输出类的描述信息
 * 121、输出类描述 TC_CLASSDESC 标志位
 * 122、输出类名
 * 123、输出序列化id 若没有显示指定则生成默认的 id
 * 124、输出 类的 field 个数及 各field 的名称类型
 * 125、输出 超类的 描述信息(递归过程)
 * 2、输出对象的 field 值信息
 * writeOrdinaryObject() 方法中的 writeExternalData() 和 writeSerialData() 中的 的 defaultWriteFields()
 * writeExternalData() 中回调用 用户 重写的 writeExternal() 方法 如果有
 * <p>
 * 反序列化过程 objectInputStream.readObject();
 * 1、读取类的 描述信息(根据 序列化后的二进制信息获取类名，然后列用反射获取类的信息)
 * 参见 : case TC_CLASS: return readClass(unshared)
 * 2、根据类的信息 反射生成类的对象
 * 参见 : case TC_OBJECT: return checkResolve(readOrdinaryObject(unshared)) 中的 readOrdinaryObject() 方法
 * 3、填充对性field 值（）
 * readOrdinaryObject() 方法的 readExternalData() 和 readSerialData() 的 defaultReadFields()
 * <p> readExternalData() 中 会调用 用户 重写的 readExternal() 方法 如果有的话
 * <p>
 * ps:对于类中重写了 readObject() 或 writeObject() 的方法，或 readResolve() 方法
 * 则调用复写的上述方法进行对象的序列化和反序列化
 */
public class JavaApiSerializedTest {

    @Test
    public void info() throws IOException, ClassNotFoundException {
        File file = new File("out.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        People people = new People();
        people.setAge(10);
        people.setName("name:lala");
        outputStream.writeObject(people);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object object = objectInputStream.readObject();
        System.out.println(object);
        file.delete();
    }

    @Test
    public void info1() throws IOException, ClassNotFoundException {
        File file = new File("out1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        Person people = new Person();
        people.setAge(10);
        people.setName("name:lala");
        outputStream.writeObject(people);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object object = objectInputStream.readObject();
        System.out.println(object);
        file.delete();
    }

    /**
     * @throws IOException
     * @throws ClassNotFoundException
     * @see Student 中的说明
     */
    @Test
    public void info2() throws IOException, ClassNotFoundException {
        File file = new File("out2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        Student student = new Student();
        student.setName("name:lala");
        student.setAge(10);
        student.setClassNo(1);
        outputStream.writeObject(student);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object object = objectInputStream.readObject();
        System.out.println(object);
        file.delete();
    }

}
