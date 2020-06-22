package UserClient;

import client.ClientManager;
import entities.Message;
import entities.User;
import enums.DBControllerType;
import enums.OperationType;
import gui.CustomerController;
import gui.MainWindowController;


// TODO: Auto-generated Javadoc
/**
 * The Class Logout.
 */
public class Logout {

	/** The client manager. */
	private static ClientManager clientManager;
	
	/** The Controller. */
	private static CustomerController Controller;

	/**
	 * Logout request.
	 *
	 * @param user the user
	 */
	public static void logoutRequest(User user) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.Logout, user, DBControllerType.User);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	/**
	 * Logout answer.
	 *
	 * @param msg the msg
	 */
	public static void logoutAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			Controller.logoutSucceeded();
			break;
		case Failed:
			Controller.logoutFailed();
			break;

		}
	}
	
	/**
	 * Sets the main window controller.
	 *
	 * @param mainWindowC the new main window controller
	 */
	public static void setMainWindowController(CustomerController mainWindowC) {
		Controller = mainWindowC;
	}

	
}
