package question.ip;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huoxianwei
 * @date 2019/10/23 17:25
 */
public class IpUtil {
    private static final String COMMA = ",";
    private static final String UNKNOWN = "unknown";

    /**
     * 获取访问ip
     *
     * @param request 请求
     * @return ip地址
     */
    public static String getRemoteIP (HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        } else if (ip.indexOf(COMMA) > 0) {
            // 服务器重定向多次的话，ip为逗号分隔的字符串
            ip = ip.substring(0, ip.indexOf(COMMA));
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            // apache+WebLogic服务器附加头信息
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        } else if (ip.indexOf(COMMA) > 0) {
            // 客户端ip经过多个代理服务器，ip为逗号分隔的字符串
            ip = ip.substring(0, ip.indexOf(COMMA));
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
