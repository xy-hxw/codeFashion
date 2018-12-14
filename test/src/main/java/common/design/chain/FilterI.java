package common.design.chain;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 16:43
 * @Description 过滤器接口
 */
public interface FilterI {
    void doFilter(RequestDTO requestDTO, ResponseDTO responseDTO, FilterIChain filterIChain);
}
