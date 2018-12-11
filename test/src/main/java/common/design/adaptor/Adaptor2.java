package common.design.adaptor;

/**
 *对象适配器 
 *不继承类，在适配器中定义私有对象
 */
public class Adaptor2 implements Ps2{
	
	private Usb usb;
	
	public Adaptor2(Usb usb) {
		this.usb=usb;
	}
	
	@Override
	public void isPs2() {
		usb.isUser();
	}

}
