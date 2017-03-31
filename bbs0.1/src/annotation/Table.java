package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//注解描述的目标是类
@Retention(RetentionPolicy.RUNTIME)//希望程序跑起来之后注解发挥作用
public @interface Table {
	public String tableName();
}
