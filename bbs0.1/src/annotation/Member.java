package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Member {
	
	public String field();//字段名称
	public boolean primaryKey() default false;//是否为主键，默认值为false
	public String type() default "VARCHAR(80)";//字串类型，默认值为VARCHAR(80)
	public boolean defaultNull() default true;//是否允许为空，默认值为true
	
}
