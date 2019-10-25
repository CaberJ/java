package io.writer;

import java.io.*;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/10/24 9:12
 */
public class WriterTest {
    public static void main(String[] args) throws IOException {


        //写文件
        File file = new File("F:/a.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("hello");
        fileWriter.write('s');
        Writer aaa = fileWriter.append("aaa");
        aaa.write("bbb");
        aaa.close();

//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter();

    }
}
