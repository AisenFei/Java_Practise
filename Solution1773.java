package code2021_0301;

import java.util.List;

class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int keyInt = 0;
        if("color".equals(ruleKey)){
            keyInt = 1;
        }else if("name".equals(ruleKey)){
            keyInt = 2;
        }
        int res = 0;
        for (List<String> item : items) {
            if(item.get(keyInt).equals(ruleValue)){
                res++;
            }
        }
        return res;
    }
}
