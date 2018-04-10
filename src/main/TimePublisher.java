package main;

import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class TimePublisher {
    
    ArrayList<ISubscriber> subscribers = new ArrayList<ISubscriber>();
    
    ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               String now = new Date().toString();
               for (ISubscriber s : subscribers) s.notify(now);
            }
         };        

    Timer t = new Timer(1000, listener);

    public void subscribe(ISubscriber newsub) {
        subscribers.add(newsub);
    }
    public TimePublisher() { t.start(); }
}
