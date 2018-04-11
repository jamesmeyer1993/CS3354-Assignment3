package patterns;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Singleton extends JFrame {

	protected static int alone;
	
	protected Singleton(){
		alone++;
		if(alone != 1)
			throw new IndexOutOfBoundsException();
	}

}
