package begin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Page extends JFrame{

	private Intro begin;
	private Page next;
	private Dimension dim;
	
	private JPanel pnlBackground;
	private JButton btnNext;
	
	public Page(Intro b){ 
		begin = b;
	}
	
	public Page(Intro b, Page p, int w, int h){
		this(b);
		next = p;
		dim = new Dimension(w, h);
		
		this.setPreferredSize(dim);
		pnlBackground = new JPanel();
		pnlBackground.setPreferredSize(dim);
		btnNext = new JButton("Next");
	}

	public void build(ActionListener act){
		
		if(act == null){
			act = new ActionListener(){
				public void actionPerformed(ActionEvent event) {
					begin.getCurPage().ontoNext(next);	
				}
			};
		}
		
		btnNext.addActionListener(act);
		pnlBackground.add(btnNext);
	}
	
	public void deploy(){
		this.pack();
		this.setVisible(true);
	}
	
	public void ontoNext(Page n){ begin.resetCurPage(n); }
}
