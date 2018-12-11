package common.design.bridge;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 优点：分离了实现抽象接口及其实现部分，提供了比继承更好的实现方式
 *       可以在变化的维度中任意扩展一个维度，不需要修改原来的系统
 *       实现细节对客户端隐藏
 *  
 *  缺点：增加了系统的设计和理解难度，聚合关系建立在抽象层，要求对抽象层进行编程
 */
public abstract class Bridge {

	@Getter
	@Setter
	private IDriver iDriver;

	public void connect() {
		iDriver.connect();
	}
}
