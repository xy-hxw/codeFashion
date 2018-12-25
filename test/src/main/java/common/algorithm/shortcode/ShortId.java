package common.algorithm.shortcode;

/**
 * @Author huoxianwei
 * @Date 2018/12/25 11:38
 * @Description ShortId
 */
public class ShortId {
    private static String createId(Integer id, Integer num) {
        String code = "0123456789ABCDEFGHIJKLMNOPKRSTUVWXYZ";
        if (null == id || id == 0) {
            return "0";
        }
        int mod ;
        int k = id;
        String str = "";
        StringBuilder sb = new StringBuilder();
        while (k >= num) {
            mod = k % num;
            k = (k-mod) / num;
            sb.append(code.charAt(mod));
        }
        sb.append(code.charAt(k));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String id = createId(12345, 36);
        System.out.println(id);
    }
}
