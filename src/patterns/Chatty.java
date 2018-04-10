/* James Meyer
 * CS3354
 * 2018-04-10
 * Assignment 3
 */

package patterns;
import java.util.Stack;

public class Chatty {

	static Stack<String> opStack = new Stack<String>();
	static Publisher pub = new Publisher(opStack);
	
	public static void main(String[] args){
		
		Subscriber sub[] = new Subscriber[3];
		sub[0] = new Subscriber(new User("Robert Paulson"), pub, opStack);
		sub[1] = new Subscriber(new User("Tyler Durden"), pub, opStack);
		sub[2] = new Subscriber(new User("Marla Singer"), pub, opStack);
	
	}
}
