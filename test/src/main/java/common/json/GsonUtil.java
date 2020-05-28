package common.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author huoxianwei
 * @date 2020/5/27 17:46
 */
public class GsonUtil {

    /**
     * 对象转换为json字符串
     * @param obj 对象
     * @return json字符串
     */
    public static String toJson (Object obj) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }

    /**
     * json字符串转换为对象
     * @return 对象
     */
    public static <T> T fromJson (String str, Class<T> clazz) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(str, clazz);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setNum(10);
        String str = toJson(student);
        System.out.println(str);

        Student student1 = fromJson(str, Student.class);
        System.out.println(student1.getName());

    }
}
