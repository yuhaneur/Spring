package kr.or.ddit.case2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case2Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = // 컨테이너가 필요없을때 셧다운 하는 구조가있음
				new ClassPathXmlApplicationContext("kr/or/ddit/case8/conf/AutoDI-Context.xml");
		
		Foo foo = context.getBean("foo1",Foo.class);
		log.info("foo : {}" ,foo);
	}
}
