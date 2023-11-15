package com.tqz.javase.study.io.objectio;

import com.tqz.javase.study.io.Constant;

import java.io.*;
import java.util.Date;

/**
 * 学习序列化。
 * NotSerializableException 没有序列化异常
 * 使用ObjectOutputStream写对象，该对象必须实例化
 *
 * <p>1.什么是序列化 和反序列化
 * 序列化Serializable 对象---字节序列  与平台无关  oos.writeObject(new Date());
 * 反序列化    字节序列----对象   ois.readObject()
 * 2.为什么要序列化
 * 1)写入文件（内存短暂----硬盘持久）
 * 2)通过网络传输
 * 3.如何序列化
 * public class Student implements Serializable
 * 其中没有任何方法，标记接口
 * ObjectOutputStream
 * oos.writeObject(new Date());
 * oos.writeObject(stu);
 *
 * <p>4.注意事项
 * 1.static属性不参与序列化
 * 2.不参与序列化的不能随便static，要使用 transient 关键字表示瞬时的
 * 3.Exception in thread "main" java.io.InvalidClassException:
 * cn.sxt.io.objectio.Student;
 * local class incompatible: stream classdesc serialVersionUID = 9217107204685998921,
 * local class serialVersionUID = 1896896584076422343
 * 读和写时类的版本号不一致，中间进行了属性的修改
 * 解决：指定一个固定的serialVersionUID
 * 4.如果对象的属性是对象，属性对应类也必须实现Serializable接口
 *
 * @author tianqingzhao
 * @since 2023-05-27 15:23
 */
public class ObjectIOTest2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write();

        read();
    }

    private static void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(Constant.PATH1);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        // 写出去的是二进制文件，可转换成16进制
        objectOutputStream.writeInt(100);
        objectOutputStream.writeLong(438543753454896L);
        objectOutputStream.writeShort(8);
        objectOutputStream.writeByte(16);
        objectOutputStream.writeFloat(34.1F);
        objectOutputStream.writeDouble(3.14);
        objectOutputStream.writeChar('a');
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeUTF("字符串");

        objectOutputStream.writeObject(new Date());
        // 对象必须实现序列化Serializable接口
        User user = new User(1, "123", 12, 56.5);
        // 属性是引用类型的也必须实现序列化接口
        user.setAmount(new Amount(1, 65866));
        objectOutputStream.writeObject(user);

        objectOutputStream.close();
    }

    private static void read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Constant.PATH1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readLong());
        System.out.println(objectInputStream.readShort());
        System.out.println(objectInputStream.readByte());
        System.out.println(objectInputStream.readFloat());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readUTF());

        System.out.println(objectInputStream.readObject());
        System.out.println(objectInputStream.readObject());
//        System.out.println(objectInputStream.readUTF()); // 重复读会报 EOFException 异常
    }
}
