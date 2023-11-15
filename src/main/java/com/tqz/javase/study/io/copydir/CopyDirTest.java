package com.tqz.javase.study.io.copydir;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：复制文件夹
 * 技能：流+递归+创建目录File
 *
 * <p>思路分析：
 * 1.在目的文件夹中创建一个空的文件夹
 * 2.将源文件夹对应目录下的文件（不包括子文件夹）复制到目的文件夹
 *
 * <p>问题1：字符流还是字节流
 * 因为可能有图片、视频、所以必须使用字节流
 * 问题2：如何提高复制的速度
 * BufferedInputStream BufferedOutputStream
 * 中转站不是一个字节，而是一个字节数组
 * 问题3：复制文件夹操作复杂，直接做没有头绪
 *
 * <p>问题分解
 * 1.复制一个文件
 * 2.复制一个文件夹下的所有的文件（不包括子文件夹）
 * 3.复制整个文件夹（包括子文件夹）
 *
 * @author tianqingzhao
 * @since 2023-06-03 16:01
 */
public class CopyDirTest {

    public static void main(String[] args) {
        String path1 = Constant.DIR + "dir1";
        String path2 = Constant.DIR + "dir2";
        copyDir(path1, path2);
    }

    /**
     * 复制一个文件夹（不包括子文件夹）
     *
     * @param sourceDir 源文件夹
     * @param destDir   目的文件夹
     */
    private static void copyDir(String sourceDir, String destDir) {
        //获取源文件
        File fsourceDir = new File(sourceDir);
        if (!fsourceDir.exists()) {
            System.out.println("源文件夹名称错误");
            return;
        }

        //创建目的文件夹
        File fdestDir = new File(destDir);
        if (!fdestDir.exists()) {
            fdestDir.mkdir();
        }

        //复制源文件夹中所有的文件到目的文件夹
        File[] files = fsourceDir.listFiles();
        for (File file : files) {
            //如果是文件，就复制
            if (file.isFile()) {
                copyFile(sourceDir + "/" + file.getName(), destDir + "/" + file.getName());
            }

            //如果是目录，递归调用
            if (file.isDirectory()) {
                copyDir(sourceDir + "/" + file.getName(), destDir + "/" + file.getName());
            }
        }
    }


    /**
     * 复制一个文件
     *
     * @param sourceFile 源文件
     * @param destFile   目的文件
     */
    public static void copyFile(String sourceFile, String destFile) {
        //创建流（输入流和输出流）
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(sourceFile)));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));
            //使用流（输入流和输出流）
            byte[] buf = new byte[1024];
            int len = bis.read(buf);
            while (len != -1) {
                //写一个字节
                bos.write(buf, 0, len);
                //读一个字节
                len = bis.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流（输入流和输出流）
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
