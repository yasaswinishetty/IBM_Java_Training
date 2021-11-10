package ex6;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stk")
@Scope("singleton")
public class Stock {
	
	public Stock() {
		System.out.println("Stock constructor");
	}
	
	private static Stock stk;
	
	public static Stock get() {
		System.out.println("Stock singleton");
		if(stk==null)
			stk = new Stock();
		
		return stk;
	}

}
