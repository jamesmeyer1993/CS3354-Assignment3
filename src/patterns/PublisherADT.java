package patterns;

public interface PublisherADT {

	public void notify(String message);
	
	public void receive(String to, String from, String message);
	
	public void subscribe(SubscriberADT s);
}
