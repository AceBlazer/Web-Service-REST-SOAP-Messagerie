package restproject;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
 
public class RouterApplication extends Application{
	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new respective instance of resource.
		Router router = new Router(getContext());
		// Defines only three routes
		//router.attach("/users", UserResource.class);
		//router.attach("/users/{uid}", UserResource.class);
		//router.attach("/users/{uid}/items", UserItemResource.class);
		router.attach("/login", UserLoginREST.class);
		router.attach("/send", MessageSend.class);
		router.attach("/list/{to}",ListeMessagesFrom.class);
		router.attach("/delete/{to}",DeletMessagesTo.class);
		
		//**********Service rest Utilise le composant 1 de composite****//
		
		router.attach("/delSpa/{to}",DeleteMsgWithSpam.class);
		return router;
	}
}
