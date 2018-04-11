package begin;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import patterns.Singleton;

@SuppressWarnings("serial")
public class PageUserForm extends Singleton {

	protected int status;
	private int size;
	private JLabel lbl[];
	private JButton btnCreate; // create new user button
	private JTextField fldUserName;
	private JPasswordField pfldPass0;
	private JPasswordField pfldPass1; // for verifying the password
	private JPanel pnlBackground;
	
	public PageUserForm(int s){
		super();
		this.size = s << 1;
		
		Dimension dim = new Dimension(size << 1, size);
		this.setPreferredSize(dim);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* GUI Object Instantiation */
		pnlBackground = new JPanel(
				new FlowLayout(FlowLayout.CENTER, size >> 4, size >> 4));
		pnlBackground.setPreferredSize(dim);
		
		lbl = new JLabel[3];
		lbl[0] = new JLabel("Name : ");
		lbl[1] = new JLabel("Password : ");
		lbl[2] = new JLabel("Retype Password : ");
		fldUserName = new JTextField(2 << 5);
		pfldPass0 = new JPasswordField(2 << 5);
		pfldPass1 = new JPasswordField(2 << 5);
		btnCreate = new JButton("Create");
		
		/* Objects are added the the panel*/
		pnlBackground.add(lbl[0]);		pnlBackground.add(fldUserName);
		pnlBackground.add(lbl[1]);		pnlBackground.add(pfldPass0);
		pnlBackground.add(lbl[2]);		pnlBackground.add(pfldPass1);
		pnlBackground.add(btnCreate);
		
		this.add(pnlBackground);
		this.setVisible(true);
		this.pack();
	}
}
