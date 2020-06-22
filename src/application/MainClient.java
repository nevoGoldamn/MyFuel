package application;

import java.io.IOException;
import java.net.*;
import client.ClientManager;
import gui.MainWindowController;
import gui.ServerController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
//initialize the program

/**
 * The Class MainClient.
 */
public class MainClient extends Application {
	
	/** The object. */
	private static Object object = new Object();
	
	/** The port. */
	private static int port;
	
	/** The host. */
	private static String host;
	
	/**
	 * Start.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void start(Stage arg0) {

	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				establishConnection(args);
			}
		});
		thread.start();
		synchronized (object) {
			object.wait();
	        Platform.runLater(() -> {
	        	new MainWindowController().start(new Stage());
//	        	launch(args);
	        });
		
		}
	}

	
	/**
 * Establish connection.
 *
 * @param args the args
 */
private static void establishConnection(String[] args) {
		
		//to-do
		// later on we will need to get the IP from args. 
		if(args.length == 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		
		try {
			port = 5555; //Default port, not for all clients
			host = GetMyIp();
			ClientManager.getClientManager(host,port);
			synchronized (object) {
				object.notifyAll();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Stop.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void stop() throws Exception {
		
		ClientManager.getClientManager().quit();
	}
	
	 /**
 	 * Gets the ip.
 	 *
 	 * @return the string
 	 */
 	// Returns local ip (String).
    private static String GetMyIp() {
	try (final DatagramSocket socket = new DatagramSocket()) {
	    socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
	    return socket.getLocalAddress().getHostAddress();
	} catch (UnknownHostException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SocketException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	return null;
    }
}
