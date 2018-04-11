package begin;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import patterns.Singleton;

public class PageBegin extends Singleton {

	protected int status;
	private int size;	// window size
	
	//private Controller ctrl;
	private JButton btnNewUser;
	private JPanel pnlBackground;
	
	public PageBegin(int s){
		super();
		this.size = s;
		
		Dimension dim = new Dimension(size/9 * 12, size);
		this.setPreferredSize(dim);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlBackground = new JPanel(
				new FlowLayout(FlowLayout.CENTER, size/10, size/10));
		pnlBackground.setPreferredSize(dim);
		
		btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				if(event.getSource().getClass().equals(JButton.class)){
					if(event.getSource().equals(btnNewUser)){
						PageUserForm uf = new PageUserForm(size);
						uf.pack();
						uf.setVisible(true);
					}
				}
			}
		});
		
		pnlBackground.add(btnNewUser);
		this.add(pnlBackground);
		this.pack();
		this.setVisible(true);
		
		
	}
}
