# Design Patterns
##### By James Meyer

## Subscriber-Publisher

### SubscriberADT
Methods:
 - notify( String message )	**--->**	Used by the publisher to set the text 
 - subscribe( Subscriber s )	**--->**	Used by self to receive message

## PublisherADT

The publisher functions almost exactly like the standard pub-sub model, only with an additional method.

 - notify( String message )
 - recieve( String to, String from, String message )

> recieve is for a more complext messaging system that I was unable to implement in time. The idea was to have "to" restrict the receivers of the message. This would enable a variety of recipent lists to be devised.

 - subscribe( SubscribeADT s )
