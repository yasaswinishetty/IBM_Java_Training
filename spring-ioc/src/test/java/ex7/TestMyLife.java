package ex7;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyLife {
	
	@Test
	public void testLife() {
//		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex3cxt.xml");
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("appcxt.xml");
		appCtx.getBean(MyLife.class);
		
		appCtx.close();
	}

}
