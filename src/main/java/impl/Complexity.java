package impl;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)//声明注释保留时长
@Target(ElementType.METHOD)//声明可以使用此注解的元素级别类型（如类、方法变量等）
@Documented//表示当标注了NeedRecord注解的对象在被javadoc生成文档时，NeedRecord注解将会被API文档记录
public @interface Complexity {
	String time();
	String space();
}
