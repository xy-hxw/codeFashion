package common.design.simpleFactory;

public class CarImpl implements Product{

	@Override
	public void load() {
		System.out.println("create car");
	}
	
}
