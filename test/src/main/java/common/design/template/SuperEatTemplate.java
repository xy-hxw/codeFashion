package common.design.template;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 15:48
 * @Description 具体的模板方法
 *
 * 请人吃套餐
 */
public class SuperEatTemplate extends AbstaractTemplate{

    @Override
    protected void doInvite() {
        System.out.println(" 邀请10个人吃饭");
    }
}
