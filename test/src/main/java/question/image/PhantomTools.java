package question.image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author huoxianwei
 * @date 2019/6/27 16:27
 *
 * 文档地址：http://phantomjs.org/download.html
 */
public class PhantomTools {

    /**
     * 执行cmd命令
     * @param imgagePath 图片url
     * @param url 网站
     * @return cmd命令
     */
    private static String cmd(String imgagePath, String url) {
        String blank = " ";
        //插件引入地址
        String binPath = "D:/download/phantomjs-2.1.1-windows/bin/phantomjs.exe";
        //js引入地址
        String jsPath = "D:/download/phantomjs-2.1.1-windows/examples/rasterize.js";
        return binPath + blank + jsPath + blank + url + blank + imgagePath;
    }

    /**
     * 关闭命令
     * @param process process
     * @param bufferedReader bufferedReader
     * @throws IOException IOException
     */
    private static void close(Process process, BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (process != null) {
            process.destroy();
        }
    }
    private static void printUrlScreen2jpg(String url, String tempPath) throws IOException {
        String imgagePath = tempPath +"/"+System.currentTimeMillis()+".png";
        //Java中使用Runtime和Process类运行外部程序
        System.out.println(cmd(imgagePath,url));
        Process process = Runtime.getRuntime().exec(cmd(imgagePath,url));
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.readLine() != null) {
            close(process,reader);
        }
        System.out.println("success");
    }

    public static void main(String[] args) throws IOException {
        String url = "https://www.baidu.com/";
        String tempPath = "D:/temp";
        PhantomTools.printUrlScreen2jpg(url, tempPath);
    }
}
