package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Subscriber implements ISubscriber, ActionListener {

	private JFrame jf;
    private JTextField jtf;
	private TimePublisher tp;
	
	public Subscriber(int winNum, TimePublisher tp) {
		this.tp = tp;
		jf = new JFrame();
        jf.setSize(600,150);
        jf.setLocation(0,(winNum-1)*150);
        jtf = new JTextField(20);
        jtf.setFont(new Font("SansSerif", Font.BOLD, 32));
        jf.setTitle("Subscriber " + Integer.toString(winNum));
        jf.setLayout(new FlowLayout());
        jf.add(jtf);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jb = new JButton("Subscribe");    
        jb.addActionListener( this );
        
        jf.getContentPane().add(jb);
        jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) { tp.subscribe(this); }
	
	public void notify(String now) { jtf.setText(now); }
	
	public void subscribe(ActionEvent arg0) { tp.subscribe(this); }
	
}
