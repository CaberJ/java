package classload;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class MyClassLoad extends ClassLoader {

    private String path;

    public MyClassLoad (String path){
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) {

        byte[] classDate =getDate();

        if(Objects.nonNull(classDate)){
            Class<?> aClass = defineClass(name, classDate, 0, classDate.length);
            return aClass;
        }
        return null;
    }

    private  byte[] getDate() {

        InputStream fileInputStream = null;
        ByteArrayOutputStream outputStream = null;
        byte[] buffer = new byte[1024];
        int size = 0;
        try {
            fileInputStream = new FileInputStream(new File(path));
            outputStream = new ByteArrayOutputStream();
            while ((size = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        byte[] bytes = outputStream.toByteArray();
        return bytes;
    }

    public static void main(String[] args) {
        String classPath = "D:\\development\\Java\\workspace\\CaberProject\\java\\java\\target\\classes\\Demo.class";
        String className = "Demo";
        MyClassLoad myClassLoad = new MyClassLoad(classPath);
        Class<?> aClass = myClassLoad.findClass(className);
        System.out.println(aClass.getName());
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].getName());
        }

    }

}
