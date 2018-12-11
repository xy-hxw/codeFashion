package common.design.Decorator;

public class Aworker implements Worker{
	
	private Worker worker;
	
	public Aworker(Worker worker) {
		super();
		this.worker = worker;
	}

	@Override
	public void doSomething() {
		System.out.println("我是装饰器");
		worker.doSomething();
	}

}
