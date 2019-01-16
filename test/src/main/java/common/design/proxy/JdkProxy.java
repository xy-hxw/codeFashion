package common.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author huoxianwei
 * 代理对象不需要实现接口
 * 目标对象一定要实现接口
 * 否则不能用动态代理
 *
 */
class JdkProxy {

	/**
	 * 维护一个目标对象
 	 */
	private Object target;

	JdkProxy(Object target) {
		super();
		this.target = target;
	}

	/**
	 * 给目标对象生成代理对象
	 */
	Object getProxyInstance() {
		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = (proxy, method, args) -> {
			System.out.println("开始事物");
			Object invoke = method.invoke(target, args);
			System.out.println("结束事物");
			return invoke;
		};
		return Proxy.newProxyInstance(loader, interfaces, h);
	}
}
