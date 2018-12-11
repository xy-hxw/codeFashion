package common.design.bridge;


public class MysqlDriver implements IDriver{

	@Override
	public void connect() {
		System.out.println(" mysql connect");
	}

}
