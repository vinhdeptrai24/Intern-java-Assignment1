package src;
import java.util.*;
public class A1{
    public static  int max(int[] s){
        int max=s[0];
        for(int a:s){
            if(a>max) max=a;
        }
        return max;
    }
    public static int min(int[] s){
        int min=s[0];
        for(int a:s){
            if(a<min) min=a;
        }
        return min;
    }
    public static int sum(int[] s){
        int sum=0;
        for(int a:s) sum+=a;
        return sum;
    }
    public static double avg(int[] s){

        return (double)sum(s)/s.length;
    }
    public static int demchan(int[] s){
        int count=0;
        for(int a:s){
            if(a%2==0)
                count++;
        }
        return count;
    }
    public static int demle(int[] s){
        int count=0;
        for(int a:s){
            if(a%2!=0)
                count++;
        }
        return count;
    }
    public static Integer secondmax(int[] s){
        int max=max(s);
        Integer second=null;
        for(int a:s){
            if(a!=max&&(second==null||a>second))
                second=a;
        }
        return second;
    }
    public static List<Integer> loaiTrung(int[] s) {
        Set<Integer> trung = new LinkedHashSet<>();
        for (int x : s) trung.add(x);
        return new ArrayList<>(trung);
    }
public static void main(String[] args) {
    int[] numbers = {5, 2, 8, 2, 10, -1, 8};

    System.out.println("Max = " + max(numbers));
    System.out.println("Min = " + min(numbers));
    System.out.println("Tong = " + sum(numbers));
    System.out.println("Trung binh = " + avg(numbers));
    System.out.println("So chan = " + demchan(numbers));
    System.out.println("So le = " + demle(numbers));

    Integer second = secondmax(numbers);
    System.out.println("So lon thu hai = " + (second != 0 ? second : "khong ton tai"));

    System.out.println("Danh sach khong trung = " + loaiTrung(numbers));
}
}