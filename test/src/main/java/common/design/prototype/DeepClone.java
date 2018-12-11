package common.design.prototype;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 深度克隆
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeepClone implements Cloneable{
	private String name;
	private Integer age;
	private List<String> list;
	
	@Override
	protected DeepClone clone() throws CloneNotSupportedException {
		try {
			DeepClone clone = (DeepClone) super.clone();
			List<String> newList = new ArrayList<>();
			for(String str:newList) {
				newList.add(str);
			}
			clone.setList(newList);
			return (DeepClone)clone;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		List<String> listNew = new ArrayList<>();
		listNew.add("test");
		DeepClone clone = new DeepClone("张三", 23,listNew);
		System.out.println(clone);
		try {
			DeepClone clone2 = clone.clone();
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
