// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;
import entities.*;
import ocsf.client.*;
import main.ClientParser;
import java.io.*;
import java.util.ArrayList;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ClientManager extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   * 
   */
   private static ClientManager clientManager = null;
   private ClientParser clientParser;
   private String host;
   private int port;

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
   //this is a singleton ClientManager
  private ClientManager(String host, int port) throws Exception {
    super(host, port); //Call the superclass constructor
    openConnection();
    clientParser = new ClientParser();
	this.host = host;
	this.port = port;
  }

  public static ClientManager getClientManager() {
	return clientManager;
  }
  
  public static ClientManager getClientManager(String host,int port) throws Exception {
	  if(clientManager == null) {
		  clientManager = new ClientManager(host, port);
	  }
	  return clientManager;
  }
  
  //Instance methods ************************************************
    

/**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    if(msg instanceof Message) {
    	clientParser.parseMessage((Message)msg);
    	
    }
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void ParseMessageToServer(Object message)  
  {
    try
    {
    	sendToServer(message);
    }
    catch(Exception e)
    {
    	//tell the user that the sending failed
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }

}
//End of ChatClient class