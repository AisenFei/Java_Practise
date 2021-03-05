package code_2021_0301;

public class SolutionJZ2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
