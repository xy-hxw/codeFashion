package common.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 10:52
 * @Description Folder
 */
public class Folder extends AbstractFile {

    private String name;
    private List<AbstractFile> fileList = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void delete(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("------对文件夹"+name+"进行杀毒");
        if (null != fileList && !fileList.isEmpty()) {
            fileList.parallelStream().forEach(AbstractFile::killVirus);
        }
    }
}
