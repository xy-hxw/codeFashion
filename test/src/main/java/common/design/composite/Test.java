package common.design.composite;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 10:58
 * @Description Test
 *
 * 组合模式
 * 1：分层次的定义复杂对象，让客户端忽略层次的差异，方便对整个层次进行控制
 * 2：客户端可以一致的使用一个组合结构或其中单个对象，不必关心处理的是单个对象还是整个组合结构，简化了客户端代码
 * 3：组合模式中新增容器和叶子构件都非常方便，无须对现有类库进行修改，符合“开闭原则”
 * 4：组合模式为树形结构面向对象提供了解决方案，通过叶子和容器对象的递归组合，可以形成复杂的树形结构，但控制简单
 *
 * 缺点：
 * 1：新增容器时，很难对容器中的类型构件进行限制
 *
 * 适用场景
 * 1：在有整体和部分的场景中，希望通过一种方式忽略整体和部分的差异，客户端可以统一的对待他们
 * 2：需要将树形结构作为面向对象处理时
 * 3：能够分离叶子节点和容器节点，他们的类型又不固定，需要新增类型
 */
public class Test {
    public static void test() {
        AbstractFile file1, file2, file3, file4, folder1, folder2, folder3;
        folder1 = new Folder("资料文件");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");

        file1 = new ImageFile("照片-1");
        file2 = new ImageFile("照片-2");
        file3 = new ImageFile("文本-1");
        file4 = new ImageFile("文本-2");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.killVirus();
    }

    public static void main(String[] args) {
        test();
    }
}
