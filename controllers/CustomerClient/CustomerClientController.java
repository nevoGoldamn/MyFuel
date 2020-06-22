package CustomerClient;

import java.util.ArrayList;
import client.ClientManager;
import entities.Customer;
import entities.Message;
import entities.Order;
import enums.DBControllerType;
import enums.OperationType;
import gui.CustomerController;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomerClientController.
 */
public class CustomerClientController {
	
	/** The client manager. */
	private static ClientManager clientManager;
	
	/** The customer controller. */
	private static CustomerController customerController;
	
	/**
	 * Gets the customer.
	 *
	 * @param id the id
	 * @return the customer
	 */
	public static void getCustomer(String id) {
		
		clientManager = ClientManager.getClientManager();
		
		Message messageToServer = new Message(OperationType.GetCustomer,id, DBControllerType.Customer);
		
		clientManager.ParseMessageToServer(messageToServer);
	}
	
	/**
	 * Gets the customer answer.
	 *
	 * @param msg the msg
	 * @return the customer answer
	 */
	@SuppressWarnings("unchecked")
	public static void getCustomerAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			if(((ArrayList<Customer>) msg.getObj()).get(0).getListOfCars() == null)
				customerController.setCustomer((Customer)((ArrayList<Customer>)msg.getObj()).get(0),false);
			else
				customerController.setCustomer((Customer)((ArrayList<Customer>)msg.getObj()).get(0),true);
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Customer data was'nt found";
				customerController.getCustomerFailed(str);
			}
			customerController.getCustomerFailed((String)msg.getObj());
			break;
		}
	}
	
	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public static void setOrder(Order order) {
		clientManager = ClientManager.getClientManager();
		
		Message messageToServer = new Message(OperationType.SubmitHomeFuelOrder,order, DBControllerType.Customer);
		
		clientManager.ParseMessageToServer(messageToServer);
	}
	
	/**
	 * Sets the order answer.
	 *
	 * @param msg the new order answer
	 */
	public static void setOrderAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			customerController.orderSubmiteSuccess((String)msg.getObj());
			break;
		case Failed:
			customerController.orderSubmiteFailed((String)msg.getObj());
			break;
		}
	}
	
	/**
	 * Gets the order.
	 *
	 * @param id the id
	 * @return the order
	 */
	public static void getOrder(String id) {
		clientManager = ClientManager.getClientManager();
		
		Message messageToServer = new Message(OperationType.GetCustomerOrders, id, DBControllerType.Customer);
		
		clientManager.ParseMessageToServer(messageToServer);
	}
	
	
	/**
	 * Gets the order answer.
	 *
	 * @param msg the msg
	 * @return the order answer
	 */
	@SuppressWarnings("unchecked")
	public static void getOrderAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			customerController.getOrderSucceed((ArrayList<Order>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "There are no open orders";
				customerController.getOrderFailed(str);
			}
			customerController.getOrderFailed((String)msg.getObj());
			break;
		}
	}
	
	/**
	 * Gets the last order number.
	 *
	 * @return the last order number
	 */
	public static void getLastOrderNumber() {
		
		clientManager = ClientManager.getClientManager();
		
		Message messageToServer = new Message(OperationType.getLastOrderNumber, null, DBControllerType.Customer);
		
		clientManager.ParseMessageToServer(messageToServer);
	}
	
	/**
	 * Gets the last order number answer.
	 *
	 * @param msg the msg
	 * @return the last order number answer
	 */
	@SuppressWarnings("unchecked")
	public static void getLastOrderNumberAnswer(Message msg) {
		System.out.println("print if you been to getLastOrderNumberAnswer");
		switch (msg.getReturnMessageType()) {
		case Succeed:
			customerController.getLastOrderNumber((Long)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String number = "1";
				customerController.getLastOrderNumberFailed(number);
			}
			customerController.getLastOrderNumberFailed((String)msg.getObj());
			break;
		}
	}
	
	/**
	 * Sets the customer controller.
	 *
	 * @param customerControllerSent the new customer controller
	 */
	public static void setCustomerController(CustomerController customerControllerSent) {
		customerController = customerControllerSent;
	}
	
	
	
}
