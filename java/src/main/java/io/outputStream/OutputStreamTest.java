package io.outputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/10/24 13:43
 */
public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {'a','b','c','d','e'};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:/a.txt"));
//        fileOutputStream.write(1);
        fileOutputStream.write(bytes);
        fileOutputStream.close();

    }
}
