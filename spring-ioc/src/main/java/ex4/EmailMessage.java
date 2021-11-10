package ex4;

public class EmailMessage implements Message {
	
	public EmailMessage() {
		System.out.println("Email Message Constructor");
	}

	@Override
	public void send(String to, String msg) {
		System.out.println("Email sent to " + to + " as " + msg);
	}

}
