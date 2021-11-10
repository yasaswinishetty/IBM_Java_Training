package ex2;

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
