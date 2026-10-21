package src;
import java.util.*;
public class A2 {
    public static int countWords(String s){
        if(s==null||s.isBlank()) return 0;
        return s.trim().split("\\s+").length;
    }
    public static String reverse(String s){
        if(s==null||s.isBlank()) return null;
        String rs="";
        for(int i=s.length()-1;i>=0;i--){
            rs+=s.charAt(i);
        }
        return  rs;
    }
    public static boolean isPalindrome(String s){
        if(s==null||s.isBlank()) return false;
        String rs=s.replace(" ","").toLowerCase();
        return rs.equals(reverse(rs));
    }
    public static Map<String,Integer> wordefrequency(String s){
        Map<String,Integer> map =new LinkedHashMap<>();
        if(s==null||s.isBlank()) return map;
        for (String a:s.trim().toLowerCase().split("\\s+"))
            map.put(a, map.getOrDefault(a,0)+1);
        return map;
    }

    static void main(String[] args) {
        System.out.println(countWords("  Java   is fun  "));     // 3
        System.out.println(reverse("Java"));                     // avaJ
        System.out.println(isPalindrome("Never odd or even"));   // true
        System.out.println(wordefrequency("Java java SQL"));
    }
}
