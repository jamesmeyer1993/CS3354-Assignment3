package patterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Subscriber implements SubscriberADT, ActionListener {

	private User usr;
	private Publisher pub;
	private Stack<String> op;
	
	private JFrame frm;
	private JPanel pnl;
	private JTextArea txtRecieve, txtSend;
	private JButton btnSend;
	
	public Subscriber(User u, Publisher p, Stack<String> o){
		
		usr = u;
		pub = p;
		op = o;
		
		this.subscribe(new ActionEvent(new Object(), 0, ""));
		
		frm = new JFrame("Chatty User : " + u.getName());
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl = new JPanel();
		
		txtRecieve = new JTextArea(8, 16);	
		txtRecieve.setLineWrap(true);
		txtSend = new JTextArea(8, 16);
		txtSend.setLineWrap(true);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				pub.notify(usr.getName() + " : " + txtSend.getText());
			}			
		});
		
		pnl.add(txtRecieve);
		pnl.add(txtSend);
		pnl.add(btnSend);
		frm.add(pnl);
		frm.pack();
		frm.setVisible(true);
	}

	public void notify(String message) { txtRecieve.setText(message); }

	public void subscribe(ActionEvent event) { pub.subscribe(this); }

	public void actionPerformed(ActionEvent event) { pub.subscribe(this); }
}
