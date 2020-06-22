package networkManagerClient;

import java.util.ArrayList;
import client.ClientManager;
import entities.Message;
import entities.Rates;
import enums.DBControllerType;
import enums.OperationType;
import gui.NetworkManagerController;

public class NetworkClientController {

	private static ClientManager clientManager;
	private static NetworkManagerController networkManagerController;

	public static void setNetworkManagerController(NetworkManagerController networkManager) {
		networkManagerController = networkManager;
	}
	
	
	public static void updateRates(ArrayList<Rates> rates) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.UpdateRates,rates, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	@SuppressWarnings("unchecked")
	public static void updateRatesAnswer(Message msg) {
		
		switch (msg.getReturnMessageType()) {
		case Succeed:
			System.out.println("been in updateRatesAnswer s ");
			networkManagerController.updateRatesSucceed((String)msg.getObj());
			System.out.println("been in updateRatesAnswer afterrr sss ");
			break;
		case Failed:
			networkManagerController.updateRatesFailed((String)msg.getObj());
			break;
		}
	}

	public static void sendApproval(ArrayList<Rates> rates) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.SendApproval,rates, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	public static void sendApprovalAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			networkManagerController.sendApprovalSucceed((String)msg.getObj());
			break;
		case Failed:
			networkManagerController.sendApprovalFailed((String)msg.getObj());
			break;
		}
	}

	public static void getTmpRates() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetTmpRatesNet, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	public static void getTmpRatesAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			networkManagerController.getTmpRatesSucceed((ArrayList<Rates>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null){
				networkManagerController.getTmpRatesFailed("null");
			}
			networkManagerController.getTmpRatesFailed((String)msg.getObj());
			break;
		}
	}
}
