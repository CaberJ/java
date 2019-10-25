package io.inputStream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/10/24 10:59
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {

        byte[] bytes = {'a','b','c','d'};
        byte[] buff = new byte[1024];

        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:/b.txt"));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        while (byteArrayInputStream.read(buff) != -1) {
            fileOutputStream.write(buff);
        }
        byteArrayInputStream.close();
//        fileOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream(new File("F:/a.txt"));
        while (fileInputStream.read(buff) != -1){
            fileOutputStream.write(buff);
        }

        fileInputStream.close();
        fileOutputStream.close();







    }
}
