package common.design.decorator;

public class TeacherImpl implements Worker{

	@Override
	public void doSomething() {
		System.out.println("teacher 教书育人");
	}

}
