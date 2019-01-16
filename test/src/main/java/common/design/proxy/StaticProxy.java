package common.design.proxy;

/**
 * @author huoxianwei
 * 静态代理
 *
 */
public class StaticProxy implements IUserDao{

	/**
	 * 需要代理的对象
 	 */
	private IUserDao target;

	StaticProxy(IUserDao target) {
		super();
		this.target = target;
	}

	@Override
	public void save() {
		System.out.println(" proxy start");
		target.save();
		System.out.println(" proxy end");
	}
}
