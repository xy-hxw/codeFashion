package common.design.decorator;

public class PoliceImpl implements Worker{

	@Override
	public void doSomething() {
		System.out.println("police 抓小偷");
	}

}
