package com.tqz.javase.study.io.dataio;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 数据流。
 *
 * <p>PrintStream和PrintWriter
 * 优点：各种类型的数据直接写入文件，简单
 * 缺点1：全部变成字符串，而不是保留原来的类型
 * 缺点2：PrintStream和PrintWriter只管写 ，不管读
 *
 * <p>解决：
 * 1.DataInputStream和DataOutputStream 只能操作基本数据类型和String，它们只有字节流，没有字符流。
 * 2.ObjectInputStream和ObjectOutputStream 可以操作所有数据类型，它们只有字节流，没有字符流。
 * DataOutputStream写的数据只能使用DataInputStream读。
 * ObjectOutputStream写的数据只能使用ObjectInputStream读
 * 这四个流只有字节流，没有字符流
 * 写入到文件中不是字符串，是二进制数据
 *
 * @author tianqingzhao
 * @since 2023-05-27 11:17
 */
public class DataIOTest {

    public static void main(String[] args) throws IOException {
        write();

        read();
    }

    private static void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(Constant.PATH1);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);

        // 写出去的是二进制文件，可转换成16进制
        dataOutputStream.writeInt(100);
        dataOutputStream.writeLong(438543753454896L);
        dataOutputStream.writeShort(8);
        dataOutputStream.writeByte(16);
        dataOutputStream.writeFloat(34.1F);

        dataOutputStream.writeDouble(3.14);
        dataOutputStream.writeChar('a');
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeUTF("字符串");

        dataOutputStream.close();
    }

    private static void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(Constant.PATH1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readLong());
        System.out.println(dataInputStream.readShort());
        System.out.println(dataInputStream.readByte());
        System.out.println(dataInputStream.readFloat());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readChar());
        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readUTF());
//        System.out.println(dataInputStream.readUTF()); // 重复读会报 EOFException 异常
    }
}
