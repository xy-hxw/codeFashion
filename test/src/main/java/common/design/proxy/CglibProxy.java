package common.design.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 
 * 不要求目标对象是否实现接口
 * 生成一个目标对象子类的代理类
 *
 */
public class CglibProxy implements MethodInterceptor{
	
	// 目标对象
	private Object target;
	public CglibProxy(Object target) {
		super();
		this.target = target;
	}

	// 为目标对象创建代理对象
	public Object getProxyInstance() {
		// 工具类
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		System.out.println(" 开始事物。。。");
		Object invoke = method.invoke(target, args);
		System.out.println(" 提交事物。。。");
		return invoke;
	}

}
