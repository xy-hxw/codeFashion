package question.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author huoxianwei
 * @date 2019/10/25 18:25
 */
public class WebUtil {
    public static void main(String[] args) {
        String url = "www.baidu.com";
        byIp(url);
    }

    /**
     * 判断ip是否在此域名下
     * @param url 域名
     */
    private static void byIp (String url) {
        try {
            InetAddress ip = InetAddress.getByName(url);
            System.out.println(ip.getHostName());
            System.out.println(ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
