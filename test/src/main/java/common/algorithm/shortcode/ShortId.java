package common.algorithm.shortcode;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author huoxianwei
 * @Date 2018/12/25 11:38
 * @Description 将十进制数转换为36进制数
 */
public class ShortId {

    private static final String CODE = "0123456789ABCDEFGHIJKLMNOPKRSTUVWXYZ";

    /**
     * 十进制转为36进制
     * @param id
     * @param num
     * @return
     */
    private static String createId(Long id, Integer num) {
        if (null == id || id == 0) {
            return "0";
        }
        long mod;
        long k = id;
        StringBuilder sb = new StringBuilder();
        while (k >= num) {
            mod = k % num;
            k = (k-mod) / num;
            sb.append(CODE.charAt((int) mod));
        }
        sb.append(CODE.charAt((int) k));
        return sb.reverse().toString();
    }

    /**
     * 36进制字符串转为16进制
     * @param id
     * @param num
     * @return
     */
    private static Integer parseId (String id, Integer num) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            sum = sum + CODE.indexOf(id.charAt(i)) * ((int) Math.pow(num, id.length() - i - 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        long id = 236146700000L;
        int num = 36;
        String str = createId(id, num);
        System.out.println(str);
        Integer integer = parseId(str, num);
        System.out.println(integer);
    }
}
