package common.file;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/11/1 15:09
 */
public class ReadFileUtil {
    private static void read (String url) {
        try {
            String str = "test";
            ArrayList<Object> list1 = Lists.newArrayList();
            list1.add(str);
            FileUtils.writeLines(new File(url), "UTF-8", list1);
            List<String> list = FileUtils.readLines(new File(url), "UTF-8");
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        String url = "D:/phone.txt";
        read(url);
    }
}
