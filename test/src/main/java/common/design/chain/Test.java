package common.design.chain;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 16:17
 * @Description 责任链模式
 */
public class Test {
    /**
     * 每一个对象的聚集由每一个对象对其下一个对象的引用形成责任链
     * 请求在链上传递，直到某一个对象决定处理此请求
     */
    public static void test() {
        String message = "张三被就业red，太好了‘|’";
        RequestDTO requestDTO = new RequestDTO(message);
        FilterIChain filterIChain = new FilterIChain();
        filterIChain.addFilterI(new FilterImpl().new FontFilterImpl())
            .addFilterI(new FilterImpl().new ColorFilterImpl())
            .addFilterI(new FilterImpl().new FaceFilterImpl());
        ResponseDTO responseDTO = new ResponseDTO();
        filterIChain.doFilter(requestDTO, responseDTO, filterIChain);
        System.out.println(responseDTO.getMessage());
    }

    public static void main(String[] args) {
        test();
    }
}
