package common.design.adaptor;

/**
 * 类适配器
 * 此适配器实现了Ps2接口，但需要调用Usb接口中方法，故继承了Usber
 *
 */
public class Adaptor1 extends Usber implements Ps2{
	
	@Override
	public void isPs2() {
		isUser();
	}
	
}
