package common.design.proxy;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("save success");
	}

}
