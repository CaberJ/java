package json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class JsonTest {

    public static void main(String[] args) {
        String str1 = " \"name\" : \"张三\" ,";
        String str2 = " \"age\" : \"12\" , ";
        String str3 = " \"sex\" : [ ], ";
        String str4 = " \"address\" : [null]";

        String jsonStr ="{" +str1+str2+str3+str4+"}";

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String name = jsonObject.getString("name");
        JSONArray address  = jsonObject.getJSONArray("address");
        System.out.println(address.size());
        String  o = (String)address.get(address.size() - 1);
        System.out.println(o);
        System.out.println(Objects.isNull(o));
        System.out.println("----------");



        JSONArray sex = jsonObject.getJSONArray("sex");
        System.out.println(sex.size());
        System.out.println(sex.toJSONString());
        System.out.println(name);
        System.out.println(address.toJSONString());

    }


}
