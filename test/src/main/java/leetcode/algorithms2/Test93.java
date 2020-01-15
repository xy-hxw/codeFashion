package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/15 17:08
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class Test93 {

    private List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder ip = new StringBuilder();
        int num = 4;
        for(int a = 1 ; a < num ; ++ a) {
            for(int b = 1 ; b < num ; ++ b) {
                for(int c = 1 ; c < num ; ++ c) {
                    for(int d = 1 ; d < num ; ++ d)
                    {
                        if(a + b + c + d == s.length() )
                        {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a+b));
                            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                            int n4 = Integer.parseInt(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                            {
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);
                                if (ip.length() == s.length() + 3) {
                                    ret.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = new Test93().restoreIpAddresses(s);
        System.out.println(JSON.toJSONString(list));
    }
}
