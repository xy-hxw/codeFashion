package common.jdk8.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author huoxianwei
 * @date 2019/2/13 19:56
 * js脚本测试
 */
public class TestJs {

    public static void test1 () {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("Nashorn");
        Integer num = null;
        try {
            num = (Integer) nashorn.eval("2+5");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        test1();
    }
}
