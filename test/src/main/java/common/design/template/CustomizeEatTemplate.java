package common.design.template;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 17:33
 * @Description 具体模板方法
 *
 * 请人吃定制餐
 */
public class CustomizeEatTemplate extends AbstaractTemplate{
    @Override
    protected void doInvite() {
        System.out.println(" 邀请1个人吃大餐");
    }

    @Override
    protected boolean isDeal() {
        return false;
    }

    @Override
    protected void doEat() {
        System.out.println(" 吃臭鳜鱼");
    }
}
