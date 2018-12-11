package common.design.bridge;

public class SqlServerDriver implements IDriver{

	@Override
	public void connect() {
		System.out.println(" sqlServer conncect");
	}

}
