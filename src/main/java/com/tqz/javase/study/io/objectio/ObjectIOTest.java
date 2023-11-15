package com.tqz.javase.study.io.objectio;

import com.tqz.javase.study.io.Constant;

import java.io.*;
import java.util.Date;

/**
 * 对象流。
 *
 * @author tianqingzhao
 * @since 2023-05-27 11:29
 */
public class ObjectIOTest {

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
