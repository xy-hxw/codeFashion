package common.design.builderPattern;

public class SmartManBuilder implements IHumanBuilder{
	
	Human human = new Human();
	
	@Override
	public void buildHead() {
		human.setHead("new head");
	}

	@Override
	public void buildBody() {
		human.setBody("new body");
	}

	@Override
	public void buildHand() {
		human.setHand("new hand");
	}

	@Override
	public void buildFoot() {
		human.setFoot("new foot");
	}

	@Override
	public Human createHuman() {
		return human;
	}
}
