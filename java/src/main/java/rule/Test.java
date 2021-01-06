package rule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("你好");
        strings.add("不是的");
        String s = strings.toString();
        String a = "[\"是的\"]";
        System.out.println(s);
        Object o = strings;

        MVELRule myRule1 = new MVELRule();
//        myRule1.when("{abc} contains\"是的\" ");
        myRule1.when("2>1&&abc.contains(\"是的\")");

        myRule1.name("测试");
        myRule1.then("resultMap.put('code',200);" +
                "resultMap.put('msg','success');" );


        Facts facts = new Facts();
        Map resultMap = new HashMap();
        facts.put("resultMap", resultMap);
       facts.put("abc",s);
        Rules rule = new Rules();
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rule.register(myRule1);
        rulesEngine.fire(rule, facts);

        System.out.println(resultMap.get("msg"));


        /*ArrayList<String> strings = new ArrayList<String>();
        strings.add("你好");
        strings.add("是的");
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Rules rule = new Rules();

        rule.register(new TestRule.Rule1());
        rule.register(new TestRule.Rule2(4));
        Facts facts = new Facts();
        facts.put("strs",strings);
        facts.put("str","是的");
        rulesEngine.fire(rule,facts);*/
    }
}
