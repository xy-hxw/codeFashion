package common.design.simpleFactory;

/**
 * 汽车工厂类
 * @author huoxianwei
 *
 */
public class CarFactory implements Factory{
	
	private static CarImpl car = new CarImpl();
	
	@Override
	public Product create() {
		return car;
	}
}
