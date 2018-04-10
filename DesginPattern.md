# Design Patterns

The program revolves entirely around the publisher / subscriber model. In the case of this program, both the publisher and the subscriber are subscribers.

## SubscriberADT (Interface)

The interface contains the two methods:

 - notify(String message)
 - subscribe(ActionEvent event)

When a user sends a message, the **notify** function is executed, alerting the publisher. The publisher then iterates through its list of subscribers and uses **notify** to update the additional subscribers.
