package common.classloader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("initClass")
public class InitClass {
	public void init() {
		System.out.println("初始化方法");
	}
	public void destroy() {
		System.out.println("结束方法");
	}
	@Bean(initMethod="init", destroyMethod="destroy")
	public InitClass test() {
		return new InitClass();
	}
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitClass.class);
         System.out.println("#################################");
         context.close();
	}
}
