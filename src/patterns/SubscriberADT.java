package patterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface SubscriberADT extends ActionListener{

	public void notify(String message);
	
	public void subscribe(ActionEvent event);
}
