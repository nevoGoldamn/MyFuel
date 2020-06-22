package UserClient;

import java.util.ArrayList;

import client.ClientManager;
import entities.Message;
import entities.*;
import enums.*;
import gui.MainWindowController;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login {

	/** The client manager. */
	private static ClientManager clientManager;
	
	/** The main window controller. */
	private static MainWindowController mainWindowController;
	
	/**
	 * Login request.
	 *
	 * @param userId the user id
	 * @param password the password
	 */
	public static void loginRequest(String userId, String password) {
		
		ArrayList<String> loginData = new ArrayList<String>();
		
		clientManager = ClientManager.getClientManager();
		
		loginData.add(userId);
		loginData.add(password);
		
		Message messageToServer = new Message(OperationType.Login, loginData, DBControllerType.User);
		clientManager.ParseMessageToServer(messageToServer);
	}
	
	
	/**
	 * Login answer.
	 *
	 * @param msg the msg
	 */
	@SuppressWarnings("unchecked")
	public static void loginAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
				mainWindowController.loginSucceeded((User)((ArrayList<User>) msg.getObj()).get(0));
			break;
		case Failed:
				// Wrong ID or password or any other problem.
				mainWindowController.loginFailed((String)((ArrayList<String>) msg.getObj()).get(1));
			break;
			default:
				mainWindowController.loginFailed("somting went wrong");
		}
	}
	
	/**
	 * Sets the main window controller.
	 *
	 * @param mainController the new main window controller
	 */
	public static void setMainWindowController(MainWindowController mainController) {
		mainWindowController = mainController;
	}
}
