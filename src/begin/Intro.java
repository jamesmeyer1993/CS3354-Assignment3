package begin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro {

	private Page cur;
	private Page next;
	
	public Intro(Page p){
		p = cur;
	}
	
	public Page getCurPage(){ return cur; }
	
	public void resetCurPage(Page p){
		next = p;
		cur.setVisible(false);
		cur.dispose();
		cur = next;
		cur.build(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(cur.getClass().equals(PageA.class)){
					
				}				
			}
		});
		cur.deploy();
	}
	
}
