package common.design.prototype;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *浅度克隆
 *如果克隆的类中的引用对象时(String, Integer等封装类除外)，克隆出来的类中引用对象储存的还是之前的内存地址
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightClone implements Cloneable{
	private String name;
	private Integer age;
	private List<String> list;
	
	@Override
	protected LightClone clone() throws CloneNotSupportedException {
		try {
			return (LightClone)super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		List<String> listNew = new ArrayList<>();
		listNew.add("test");
		LightClone clone = new LightClone("张三", 23,listNew);
		System.out.println(clone);
		try {
			LightClone clone2 = clone.clone();
			clone2.setName("李四");
			clone2.getList().add("李四");
			System.out.println(clone);
			System.out.println(clone2);
			System.out.println(clone.hashCode());
			System.out.println(clone2.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
}
