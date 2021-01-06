package rule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleUtils {
    public static void main(String[] args) {

        TagResult tagResult = matchRule(1, 3);
        System.out.println(tagResult);


    }

    /**
     * 匹配通话时长和通话次数，满足其中一个条件表示匹配成功
     * @param talkTime
     * @param talkNum
     */
    public static TagResult matchRule(Integer talkTime, Integer talkNum){
        RuleInfo rules = new RuleInfo(1, "通话时长", "{0}>10", "talkTime");
        RuleInfo rules1 = new RuleInfo(1, "通话次数", "{0}>2", "talkNum");
        /*Rules rules2 = new Rules(1, "挂机次数", "{0}>3");
        Rules rules3 = new Rules(1, "拒接次数", "{0}>4");*/
        List<RuleInfo> ruleList = new ArrayList();
        ruleList.add(rules);
        ruleList.add(rules1);
        Map<String, TagResult> map = new HashMap();
        TagResult tagResult = new TagResult();
        tagResult.setRuleList(ruleList);
        map.put("标签名称", tagResult);
//        List<RuleInfo> tagList = map.get("标签名称");
        TagResult tagObj = map.get("标签名称");
        List<RuleInfo> tagList = tagObj.getRuleList();


        MVELRule myRule1 = new MVELRule();


        for(RuleInfo rules2 : tagList){
            Map resultMap = new HashMap();
            Facts facts = new Facts();
            String ruleOption = rules2.getRuleOption();
            String tagName = rules2.getTagName();
            String option = MessageFormat.format(ruleOption, tagName);
            if("talkTime".equals(tagName)){
                facts.put(tagName, talkTime);
            }else {
                facts.put(tagName, talkNum);
            }
            myRule1.name("客户意向规则")
                    .when(option)
                    .then("resultMap.put('code','200');" +
                            "resultMap.put('msg','success');");

            facts.put("resultMap", resultMap);
            Rules rule = new Rules();
            RulesEngine rulesEngine = new DefaultRulesEngine();
            rule.register(myRule1);
            rulesEngine.fire(rule, facts);
            if("200".equals(resultMap.get("code"))){
                tagObj.setSuccessFlag(true);
                break;
            }
        }
        return tagObj;
    }
}
