package io.reader;

import java.io.*;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/10/24 11:23
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {'a','b','c','d'};
        char[] charBuff =new char[4];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);

        while (inputStreamReader.read(charBuff) != -1) {
            System.out.println(new String(charBuff));
        }


        FileReader fileReader = new FileReader(new File("F:/a.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str ;
        while ((str = bufferedReader.readLine())!=null ){
            System.out.println(str);
        }


    }
}
