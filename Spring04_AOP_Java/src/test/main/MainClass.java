package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.WritingUtil;

public class MainClass {
	public static void main(String[] args) {
		//init.xml 문서를 로딩해서 bean으로 만들것을 만들어서 관리한다
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		//관리하고 있는 객체중에서 WritingUtil type의 참조값얻어오기(여러개의 같은 타입이 존재할때에는 이셉션이 발생한다)
		WritingUtil util=context.getBean(WritingUtil.class);
		
		util.write1();
		util.write2();
		util.write3();
	}
}
