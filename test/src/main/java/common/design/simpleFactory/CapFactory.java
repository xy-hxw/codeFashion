package common.design.simpleFactory;

public class CapFactory implements Factory{
	
	private static CapImpl cap = new CapImpl();
	
	@Override
	public Product create() {
		return cap;
	}
	
}
