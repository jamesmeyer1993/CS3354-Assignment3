package patterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class Publisher implements PublisherADT{

	ArrayList<SubscriberADT> subscribers;
	//Stack<String> op;
	
	public Publisher(){
		subscribers = new ArrayList<SubscriberADT>();
	}

	public void subscribe(SubscriberADT s){ subscribers.add(s); }

	public void notify(String message) {
		for(SubscriberADT s : subscribers)
			s.notify(message);
	}

	@Override
	public void receive(String to, String from, String message) {
		
		char l[] = new char[4];
		for(int i = 0; i < 4; i++)
			l[i] = to.charAt(i);
		
		/* Two Notification Cases */
		if( ( l[1] == 'l' )&&( l[2] == 'l' ) )
			notify(from+" : "+message);
		else if(subscribers.contains(to) && subscribers.contains(from))
			subscribers.get(subscribers.indexOf(to)).notify(message);
		
	}	
}
