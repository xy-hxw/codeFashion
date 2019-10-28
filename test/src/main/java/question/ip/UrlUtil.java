package question.ip;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author huoxianwei
 * @date 2019/7/3 19:52
 */
public class UrlUtil {
    private static String getAddressByIP (String strIP) {
        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            String ipAddr = result.toString();
            try {
                String status = "code";
                String success = "0";
                JSONObject obj1 = JSONObject.parseObject(ipAddr);
                if (success.equals(obj1.get(status).toString())) {
                    JSONObject obj2 = JSONObject.parseObject(obj1.get("data").toString());
                    return obj2.get("country").toString();
                } else {
                    return "读取失败";
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return "读取失败";
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            return "读取失败";
        }
        return null;
    }

    public static void main(String[] args) {
        String ip = "124.127.99.32";
        String addressByIP = getAddressByIP(ip);
        System.out.println(addressByIP);
    }
}
