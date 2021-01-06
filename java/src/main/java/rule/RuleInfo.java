package rule;


public class RuleInfo {



    private Integer group;
    private String name;
    private String ruleOption;
    private String tagName;

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleOption() {
        return ruleOption;
    }

    public void setRuleOption(String ruleOption) {
        this.ruleOption = ruleOption;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public RuleInfo(Integer group, String name, String ruleOption, String tagName) {
        this.group = group;
        this.name = name;
        this.ruleOption = ruleOption;
        this.tagName = tagName;
    }
}
