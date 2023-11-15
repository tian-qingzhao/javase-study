package com.tqz.javase.study.io.arrayio;

import com.tqz.javase.study.io.objectio.Amount;
import com.tqz.javase.study.io.objectio.User;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * 数组流。
 *
 * <p>问题1：节点流有哪些？还有哪些？
 * FileInputStream FileOutputStream
 * FileReader FileWriter
 * 数据源和目的地：File 外存  长久保存
 * ByteArrayInutStream和ByteArrayOutputStream 字节数组
 * CharArrayReader和CharArrayWriter 字符数组
 * StringReader和StringWriter  字符串
 * 数据源和目的地：array  内存中的一块存储区域   可以作为中间结果，下一步操作的前提
 *
 * <p>问题2：如何实现字符串和字节数组之间的转换
 * 字节数组---->String
 * new String(buf, 0, len)
 * String----->字节数组
 * byte [] buf2 = str.getBytes();
 * byte [] buf2 = str.getBytes("utf-8");
 *
 * <p>问题3：如何实现所有数据类型（基本数据类型、引用数据类型）和字节数组之间的转换
 * ByteArrayInutStream和ByteArrayOutputStream
 *
 * <p>总结
 * 1.ByteArrayOutputStream的数据源是一个字节数组，默认空间32字节，可以自动增长（ArrayList，StringBuffer，Vector）
 * 2.作用：实现所有数据类型（基本数据类型、引用数据类型）和字节数组之间的转换
 * 转换成字节数组后可以保存到文件或者传输到网络
 * 3.使用了ObjectOutputStream可以方便的写入对象到文件或者字节数组，但要求对象必须序列化
 *
 * @author tianqingzhao
 * @since 2023-05-27 16:31
 */
public class ArrayIOTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] buf = toByteArrayStream();
        System.out.println("字节数组：" + Arrays.toString(buf));

        fromToData(buf);
    }

    private static byte[] toByteArrayStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
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

        // 转换为字节数组
        return byteArrayOutputStream.toByteArray();
    }

    private static void fromToData(byte[] buf) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
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
    }
}
