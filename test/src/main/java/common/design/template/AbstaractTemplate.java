package common.design.template;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 15:41
 * @Description 抽象模板
 */
public abstract class AbstaractTemplate {
    /**
     *  模板方法
     *  把基本操作方法组合成一个算法或一个总行为的方法
     *
     *  吃饭
     */
    void eatMethod() {
        doInvite();
        if(isDeal()) {
            defaultEat();
        } else {
            doEat();
        }
    }

    /**
     * 基本方法(由子类实现)
     *
     * 邀请吃饭的人
     */
    protected abstract void doInvite();

    /**
     * 钩子函数(判断是否执行某些步骤)
     * @return  是否执行默认操作
     *
     */
    protected boolean isDeal() {
        return true;
    }
    // 业务处理
    protected void doEat() {
        System.out.println(" 新订套餐......");
    }
    // 业务处理
    private void defaultEat() {
        System.out.println(" 默认的套餐......");
    }
}
