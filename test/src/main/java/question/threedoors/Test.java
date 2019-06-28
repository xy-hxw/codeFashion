package question.threedoors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author huoxianwei
 * @date 2019/6/27 9:26
 *
 * 节目中有一位参与者和一位主持人，在参与者的面前有三扇关闭的门，
 * 其中两扇门的后面是空的，剩下一扇门后是一辆法拉利跑车，主持人知道哪扇是有奖品
 *
 * 选完一扇门后，主持人打卡一扇空门，参与者可以选择换门或者不换门，换门和不换门中奖的概率各有多大
 */
public class Test {

    public static void test (int num) {
        int winningCount = 0;
        int unWinningCount = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2));
            int prize = random.nextInt(3);
            int select = random.nextInt(3);
            // 打开空门
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != select && list.get(j) != prize) {
                    list.remove(j);
                    break;
                }
            }
            // 获得换门的序号
            Integer change = list.get(0);
            if (change == select) {
                change = list.get(1);
            }
            if (prize == change) {
                winningCount = winningCount + 1;
            } else {
                unWinningCount = unWinningCount + 1;
            }
        }
        System.out.println("换门中奖="+winningCount);
        System.out.println("不换门中奖="+unWinningCount);
    }

    public static void main(String[] args) {
        test(10000);
    }
}
