package common.design.bridge;

/**
 *  桥接模式
 *  1：实现了抽象和实现部分的分离
 *  2：更好的扩展性
 *  3：可动态的切换实现
 *  4：对用户隐藏实现细节
 *
 *  使用场景
 *  1：系统构建在在抽象化角色和具体角色有更多的灵活性，避免在两个层次之间建立静态的继承关系
 *  2：抽象化角色和实现化角色独立扩展互不影响，需要独立管理这两者
 */
public class Test {
	public static void main(String[] args) {
		Bridge bridge = new MyBridge();
		IDriver mysqlDriver = new MysqlDriver();
		bridge.setIDriver(mysqlDriver);
		bridge.connect();

		IDriver sqlServerDriver = new SqlServerDriver();
		bridge.setIDriver(sqlServerDriver);
		bridge.connect();
	}
}
