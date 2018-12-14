package common.design.chain;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 16:55
 * @Description 过滤功能
 */
class FilterImpl{

    public class FontFilterImpl implements FilterI {
        @Override
        public void doFilter(RequestDTO requestDTO, ResponseDTO responseDTO, FilterIChain filterIChain) {
            requestDTO.setMessage(requestDTO.getMessage().replace("被就业", "就业"));
            responseDTO.setMessage(responseDTO.getMessage()+"-FontFilterImpl 执行了  ");
            System.out.println("过滤就业="+requestDTO.getMessage());
            filterIChain.doFilter(requestDTO, responseDTO, filterIChain);
        }
    }

    public class FaceFilterImpl implements FilterI {
        @Override
        public void doFilter(RequestDTO requestDTO, ResponseDTO responseDTO, FilterIChain filterIChain) {
            requestDTO.setMessage(requestDTO.getMessage().replace("‘|’", "*_*"));
            responseDTO.setMessage(responseDTO.getMessage()+"-FaceFilterImpl 执行了  ");
            System.out.println("过滤表情="+requestDTO.getMessage());
            filterIChain.doFilter(requestDTO, responseDTO, filterIChain);
        }
    }

    public class ColorFilterImpl implements FilterI {
        @Override
        public void doFilter(RequestDTO requestDTO, ResponseDTO responseDTO, FilterIChain filterIChain) {
            requestDTO.setMessage(requestDTO.getMessage().replace("red", "blue"));
            responseDTO.setMessage(responseDTO.getMessage()+"-ColorFilterImpl 执行了  ");
            System.out.println("过滤颜色="+requestDTO.getMessage());
            filterIChain.doFilter(requestDTO, responseDTO, filterIChain);
        }
    }
}
