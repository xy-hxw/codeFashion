package common.design.simpleFactory;

public class CapImpl implements Product{

	@Override
	public void load() {
		System.out.println("create cap");
	}

}
