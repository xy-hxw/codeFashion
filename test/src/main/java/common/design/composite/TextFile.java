package common.design.composite;


/**
 * @Author huoxianwei
 * @Date 2018/12/11 17:35
 * 文件类型处理
 */
public class TextFile extends AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("对文本文件"+name+"进行杀毒");
    }
}
