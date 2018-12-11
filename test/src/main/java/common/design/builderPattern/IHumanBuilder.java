package common.design.builderPattern;

public interface IHumanBuilder {
	public void buildHead();
	public void buildBody();
	public void buildHand();
	public void buildFoot();
	public Human createHuman();
}
