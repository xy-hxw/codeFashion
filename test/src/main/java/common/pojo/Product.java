package common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huoxianwei
 * @date 2019/2/18 14:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer price;
    private String name;
}
