package cn.book.bus.test;

import cn.book.bus.domain.Fiction;
import cn.book.bus.utils.ClassUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        System.out.println("sum:"+sum(1,2,3,6,5,8,9));
//        String[] strings={"魔法","都市"};
//        System.out.println("sum:"+sum(strings));
//        User user=new User();
//        System.out.println(user.getId());
//        HashMap<String,String> map=new HashMap<>();
//        Map(map);
    }
    public static int sum(int...a) {
        int sum = 0;

        for(int x:a) {
            sum+=x;
        }
        return sum;

    }
    public static String sum(String...strings) {
        String Str = "";

        for(String x:strings) {
            Str=x;
        }
        return Str;

    }
    public static void Map(HashMap<String,String> map) {
        Iterator<Map.Entry<String, String>> iterator;
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            System.out.println(key+val);
        }
    }


}
