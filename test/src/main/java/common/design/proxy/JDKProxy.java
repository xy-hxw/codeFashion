package common.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 代理对象不需要实现接口
 * 目标对象一定要实现接口
 * 否则不能用动态代理
 *
 */
public class JDKProxy {
	// 维护一个目标对象
	private Object target;
	public JDKProxy(Object target) {
		super();
		this.target = target;
	}
	
	//给目标对象生成代理对象
	public Object getProxyInstance() {
		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("开始事物");
				Object invoke = method.invoke(target, args);
				System.out.println("结束事物");
				return invoke;
			}
		};
		return Proxy.newProxyInstance(loader, interfaces, h);
	}
}
