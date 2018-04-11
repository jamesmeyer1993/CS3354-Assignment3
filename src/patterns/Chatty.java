/* James Meyer
 * CS3354
 * 2018-04-10
 * Assignment 3
 */

package patterns;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chatty implements ActionListener{

	static Publisher pub = new Publisher();
	static ArrayList<Subscriber> sublist;
	
	JFrame frm;
	Dimension dim;
	JPanel pnlA, pnlB;
	JTextField fldA, fldB[];
	JButton btnA, btnB;
	
	public void begin(ArrayList<Subscriber> s){
		dim = new Dimension(400, 400);
		frm = new JFrame("Chatty : James Meyer");
		frm.setPreferredSize(dim);
		
		pnlA = new JPanel();
		pnlA.setPreferredSize(dim);
		fldA = new JTextField(16);
		btnA = new JButton("Next");
		btnA.addActionListener(this);
		
		pnlA.add(new JLabel("Enter the number of users to simulate :"));
		pnlA.add(fldA);
		pnlA.add(btnA);
		
		frm.add(pnlA);
		frm.pack();
		frm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(btnA)){
			frm.setVisible(false);
			int userCount = Integer.parseInt(fldA.getText());
			frm.dispose();
			
			pnlB = new JPanel();
			pnlB.setPreferredSize(dim);
			pnlB.add(new JLabel("Enter the names of the users : "));
			fldB = new JTextField[userCount];
			for(int i = 0; i < Integer.parseInt(fldA.getText()); i++){
				fldB[i] = new JTextField(16);
				pnlB.add(fldB[i]);
			}
			
			btnB = new JButton("Next");
			btnB.addActionListener(this);
			pnlB.add(btnB);
			
			frm = new JFrame();
			frm.setPreferredSize(dim);
			frm.add(pnlB);
			frm.pack();
			frm.setVisible(true);
		}
		else if(event.getSource().equals(btnB)){
			
			if( sublist==null || pub==null )
				throw new NullPointerException();
			
			for(JTextField fld : fldB)
				sublist.add(new Subscriber(new User(fld.getText()), pub));
			
			frm.setVisible(false);
			frm.dispose();
		}
	}
	
	public static void main(String[] args){
		
		sublist = new ArrayList<Subscriber>();
		Chatty chat = new Chatty();
		chat.begin(sublist);
	}
	
}
