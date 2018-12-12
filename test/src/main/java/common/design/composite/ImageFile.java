package common.design.composite;

/**
 * @Author huoxianwei
 * @Date 2018/12/11 17:30
 * 文件类型处理
 */
public class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("对图像文件"+name+"进行杀毒");
    }
}
