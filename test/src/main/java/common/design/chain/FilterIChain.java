package common.design.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 16:45
 * @Description 过滤器链
 */
public class FilterIChain implements FilterI {
    // 存储过滤规则
    private List<FilterI> list = new ArrayList<>();
    // 标记规则的引用顺序
    private int index = 0;

    // 往规则链中添加规则
    FilterIChain addFilterI(FilterI filterI) {
        list.add(filterI);
        return this;
    }

    @Override
    public void doFilter(RequestDTO requestDTO, ResponseDTO responseDTO, FilterIChain filterIChain) {
        if (index >= list.size()) {
            return;
        }
        FilterI filterI = list.get(index);
        index++;
        filterI.doFilter(requestDTO, responseDTO, filterIChain);
    }
}
