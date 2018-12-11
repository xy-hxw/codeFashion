package common.design.builderPattern;
/**
 * 监工角色
 *
 */
public class Director {
	public Human createHumanByDirector(IHumanBuilder man) {
		man.buildHead();
		man.buildBody();
		man.buildHand();
		man.buildFoot();
		return man.createHuman();
	}
}
