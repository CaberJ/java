package rule;

import org.jeasy.rules.annotation.*;

import java.util.List;

public class TestRule {
    @Rule
    public static class Rule1 {
        @Condition
        public boolean isFizz(@Fact("strs") List<String> strs,@Fact("str") String str ) {
            return strs.contains(str);
        }

        @Action
        public void printFizz() {
            System.out.print("成功2");
        }
        @Priority
        public  int getPriority(){
            return 2;
        }

    }
    @Rule
    public static class Rule2 {
        public Integer priority;

        public Rule2(Integer priority) {
            this.priority = priority;
        }

        @Condition
        public boolean isFizz(@Fact("strs") List<String> strs,@Fact("str") String str ) {
            return strs.contains(str);
        }

        @Action
        public void printFizz() {
            System.out.print("成功"+priority);
        }
        @Priority
        public  int getPriority(){
            return priority;
        }

    }
}
