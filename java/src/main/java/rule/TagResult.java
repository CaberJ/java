package rule;


import java.util.List;

public class TagResult {

    private Boolean successFlag; //是否匹配成功
    private List<RuleInfo> RuleList;//标签匹配条件

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public List<RuleInfo> getRuleList() {
        return RuleList;
    }

    public void setRuleList(List<RuleInfo> ruleList) {
        RuleList = ruleList;
    }
}
