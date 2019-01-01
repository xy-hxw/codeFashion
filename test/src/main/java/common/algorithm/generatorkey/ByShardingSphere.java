package common.algorithm.generatorkey;

import common.algorithm.shortcode.ShortId;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;

import java.math.BigInteger;
import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author Administrator
 * @Date 2018/12/30 11:56
 * @Description 雪花算法
 */
public class ByShardingSphere {

    private static DefaultKeyGenerator defaultKeyGenerator;
    private static Long ipNum;

    static {
        defaultKeyGenerator = new DefaultKeyGenerator();
        ipNum = getIPNum();
    }

    /**
     * 获取内网ip和
     * @return 返回网卡ip和
     */
    private static Long getIPNum() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isVirtual()) {
                    continue;
                }
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if ((inetAddress instanceof Inet4Address) && !inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        System.out.println(hostAddress);
                        return Arrays.stream(hostAddress.split("\\.")).mapToLong(Long::valueOf).sum();
                    }
                }
             }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 十进制转为36进制
     * @param id 十进制数
     * @param num 36进制
     * @return 返回36进制数
     */
    private static String createId(BigInteger id, Integer num, String code) {
        if (null == id) {
            return "0";
        }
        if (null == num) {
            num = 10;
        }
        BigInteger radix = new BigInteger(num.toString());
        BigInteger mod;
        BigInteger k = id;
        StringBuilder sb = new StringBuilder();
        while (k.compareTo(radix)>=0) {
            mod = k.remainder(radix);
            k = k.subtract(mod).divide(radix);
            sb.append(code.charAt(mod.intValue()));
        }
        sb.append(code.charAt(k.intValue()));
        return sb.reverse().toString();
    }

    /**
     * 对外提供自增id
     * 最大值=18446744073709551616
     */
    private static String generatorId () {
        if (ipNum == null) {
            return null;
        }
        DefaultKeyGenerator.setWorkerId(ipNum);
        Number number = defaultKeyGenerator.generateKey();
        System.out.println("生成的id="+number.toString());

        // 将id转换为36进制字符串
        int num = 36;
        return createId(new BigInteger("18446744073709551616"), num, ShortId.randomNum(num));
    }
    public static void main(String[] args) {
        int num = 3;
        for (int i = 0; i < num; i++) {
            String number = generatorId();
            System.out.println(number);
        }
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();
            System.out.println(hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}


