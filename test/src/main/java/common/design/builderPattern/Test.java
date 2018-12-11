package common.design.builderPattern;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 工厂方法模式创建的产品一般都是单一性质产品
 * 建造者模式创建的则是一个复合产品，它由各个部件复合而成，部件不同产品对象当然不同
 * 如果需要详细关注一个产品部件的生产、安装步骤，则选择建造者，否则选择工厂方法模式
 *
 */
public class Test {
	public static void main(String[] args) {
		Director director = new Director();
		IHumanBuilder man = new SmartManBuilder();
		Human human = director.createHumanByDirector(man);
		System.out.println(JSON.toJSONString(human));
	}
}
