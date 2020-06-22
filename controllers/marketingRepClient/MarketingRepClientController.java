package marketingRepClient;

import java.util.ArrayList;

import client.ClientManager;
import entities.Customer;
import entities.Message;
import enums.DBControllerType;
import enums.OperationType;
import gui.MarketingRepController;

// TODO: Auto-generated Javadoc
/**
 * The Class MarketingRepClientController.
 */
public class MarketingRepClientController {

	/** The client manager. */
	private static ClientManager clientManager;
	
	/** The marketing rep controller. */
	private static MarketingRepController marketingRepController;

	/**
	 * Sets the marketing rep controller.
	 *
	 * @param marketingRepC the new marketing rep controller
	 */
	public static void setMarketingRepController(MarketingRepController marketingRepC) {
		marketingRepController = marketingRepC;
	}

	/**
	 * Adds the customer.
	 *
	 * @param customer the customer
	 */
	public static void addCustomer(Customer customer) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.RegistrationNoCar,customer, DBControllerType.MarketingRep);

		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Adds the customer answer.
	 *
	 * @param msg the msg
	 */
	public static void addCustomerAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingRepController.addCustomerSucceed((String)msg.getObj());
			break;
		case Failed:
			//check if duplicate
			marketingRepController.addCustomerFailed((String)msg.getObj());
			break;
		}
	}
	
	/**
	 * Adds the customer with car.
	 *
	 * @param customer the customer
	 */
	public static void addCustomerWithCar(Customer customer) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.RegistrationWithCar,customer, DBControllerType.MarketingRep);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	/**
	 * Adds the customer with car answer.
	 *
	 * @param msg the msg
	 */
	public static void addCustomerWithCarAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingRepController.addCustomerSucceed((String)msg.getObj());
			break;
		case Failed:
			marketingRepController.addCustomerFailed((String)msg.getObj());
			break;
		}
	}

	/**
	 * Gets the all customer ID.
	 *
	 * @return the all customer ID
	 */
	public static void getAllCustomerID() {
		// TODO Auto-generated method stub
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetCustomersIDs,null, DBControllerType.MarketingRep);

		clientManager.ParseMessageToServer(messageToServer);
		
	}

	/**
	 * Gets the all customer ID answer.
	 *
	 * @param msg the msg
	 * @return the all customer ID answer
	 */
	@SuppressWarnings("unchecked")
	public static void getAllCustomerIDAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingRepController.setCustomerIDs(((ArrayList<String>)msg.getObj()));
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Customer data was'nt found";
				marketingRepController.getAllCustomerIDFailed(str);
			}
			marketingRepController.getAllCustomerIDFailed((String)msg.getObj());
			break;
		}
	}
	
	public static void GenerateCampaignTemplate(String campaignName, Double discount) {
		clientManager = ClientManager.getClientManager();

		ArrayList<Object> sendToServer = new ArrayList<Object>();
		sendToServer.add(campaignName);
		sendToServer.add(discount);
		Message messageToServer = new Message(OperationType.GenerateCampaignTemplate,sendToServer, DBControllerType.MarketingRep);

		clientManager.ParseMessageToServer(messageToServer);

	}

	public static void GenerateCampaignTemplateAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingRepController.GenerateCampaignTemplateSucceeded(((String)msg.getObj()));
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = " data wasn't found";
				marketingRepController.GenerateCampaignTemplateFailed(str);
			}
			marketingRepController.GenerateCampaignTemplateFailed((String)msg.getObj());
			break;
		}

	}

	public static void produceAnalitic() {
		// TODO Auto-generated method stub
		clientManager = ClientManager.getClientManager();
		ArrayList<Object> datArrayList = new ArrayList<Object>();
		datArrayList.add("21.6.2020");
		datArrayList.add("21.10.2020");

		Message messageToServer = new Message(OperationType.ProduceAnalitic,datArrayList, DBControllerType.Analitic);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	public static void produceAnaliticAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			break;
		case Failed:
			break;
		default: break;
		
		}
	}
}
