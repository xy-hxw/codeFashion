package common.algorithm.shortcode;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author huoxianwei
 * @Date 2018/12/25 11:38
 * @Description 将十进制数转换为36进制数
 */
public class ShortId {

    private static String CODE = "0123456789ABCDEFGHIJKLMNOPKRSTUVWXYZ";


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

    /**
     * 获取一个4位随机数
     */
    public static String randomNum() {
        String str = "0123456789abcdefghijklmnopqrstuvwxyz";
        List<String> rlist = new ArrayList<>(Arrays.asList(str.split("")));
        StringBuilder sb = new StringBuilder();
        int size = rlist.size();
        for (int i = 1; i <= 36; i++) {
            int index = ThreadLocalRandom.current().nextInt(size);
            sb.append(rlist.get(index));
            rlist.remove(index);
            size = size - 1;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        // 46656  1679615
        CODE = randomNum();
        Long random = ThreadLocalRandom.current().nextLong(46656L, 1679615L);
        int num = 36;
        String str = createId(random, num);
        Integer integer = parseId(str, num);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        uuid = str + uuid;
        System.out.println(uuid);
    }
}
