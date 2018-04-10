package patterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class Publisher implements SubscriberADT{

	ArrayList<Subscriber> subscribers;
	Stack<String> op;
	
	public Publisher(Stack<String> o){
		subscribers = new ArrayList<Subscriber>();
		op = o;
	}

	public void subscribe(Subscriber s){ subscribers.add(s); }
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void notify(String message) {
		for(SubscriberADT s : subscribers)
			s.notify(message);
	}

	@Override
	public void subscribe(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}	
	
	/*@Override
	public void run() {
		boolean isRunning = true;
		do{
			if(!op.isEmpty()){
				if(op.pop().equals("OP_SENDTOALL")){
					curSender = op.pop();
					curMessage = op.pop();
				}
				else {
					System.err.print("Chatty : Unkown operation code. Exiting.\n");
					System.exit(-1);
				}
			}
			
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}while(isRunning);
	}*/
}
