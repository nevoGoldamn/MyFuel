//package stationClient;
//
//import java.util.ArrayList;
//
//import client.ClientManager;
//import entities.Message;
//import entities.SupplyOrder;
//import enums.DBControllerType;
//import enums.OperationType;
//import gui.StationManagerController;
//
//public class StationManagerClient {
//	
//	private static ClientManager clientManager = null;
//	private static StationManagerController managerController = null;
//
//	public static void setManagerController(StationManagerController manager) {
//		
//		managerController = manager;
//	}
//
//	/*case GetSupplyOrders:
//
//		case SendSupplyOrder:
//
//		case DeleteSupplyOrder:
//
//		case SetSupplierID:*/
//	/*
//	public static void getEmployees() {
//
//		clientManager = ClientManager.getClientManager();
//
//		Message messageToServer = new Message(OperationType.GetEmployees, null, DBControllerType.NetworkManager,managerController.getManagerController());
//
//		clientManager.ParseMessageToServer(messageToServer);
//
//	}
//
//	*/
//	
//	public static void getSupplyOrders(String id) {
//		
//		clientManager = ClientManager.getClientManager();
//		
//		Message messageToServer = new Message(OperationType.GetSupplyOrders,id, DBControllerType.StationManager);
//		
//		clientManager.ParseMessageToServer(messageToServer);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static void getSupplyOrdersAnswer(Message msg){
//		switch (msg.getReturnMessageType()) {
//		case Succeed:
//			managerController.getOrdersSucceed((ArrayList<SupplyOrder>)msg.getObj());
//			break;
//		case Failed:
//			if(msg.getObj() == null) {
//				String str = "Supply order data was'nt found";
//				managerController.getOrdersFailed(str);
//			}
//			managerController.getOrdersFailed((String)msg.getObj());
//		default:
//			break;
//		}
//	}
//	
//	public static void removeOrder(long orderNumber) {
//		
//		clientManager = ClientManager.getClientManager();
//		
//		Message messageToServer = new Message(OperationType.DeleteSupplyOrder, orderNumber, DBControllerType.StationManager);
//		
//		clientManager.ParseMessageToServer(messageToServer);
//	}
//	
//	public static void removeOrderAnswer(Message msg) {
//		switch (msg.getReturnMessageType()) {
//		case Succeed:
//			managerController.removeOrderSucceed((long)msg.getObj());
//			break;
//		case Failed:
//			managerController.removeOrderFailed((String)msg.getObj());
//		default:
//			break;
//		}
//
//	}
//	
//	public static void updateSupplyAmount(SupplyOrder order) {
//
//		clientManager = ClientManager.getClientManager();
//		
//		Message messageToServer = new Message(OperationType.SetAmountForSupply,(Object)order, DBControllerType.StationManager);
//		
//		clientManager.ParseMessageToServer(messageToServer);
//
//	}
//
//	public static void updateSupplyAmountAnswer(Message msg){
//		switch (msg.getReturnMessageType()) {
//		case Succeed:
//			
//			break;
//		case Failed:
//			
//		default:
//			break;
//		}
//	}
//}

package stationClient;

import java.util.ArrayList;

import client.ClientManager;
import entities.Message;
import entities.Rates;
import entities.SupplyOrder;
import entities.Threshold;
import enums.DBControllerType;
import enums.OperationType;
import gui.StationManagerController;

// TODO: Auto-generated Javadoc
/**
 * The Class StationManagerClient.
 */
public class StationManagerClient {

	/** The client manager. */
	private static ClientManager clientManager = null;
	
	/** The manager controller. */
	private static StationManagerController managerController = null;

	/**
	 * Sets the manager controller.
	 *
	 * @param manager the new manager controller
	 */
	public static void setManagerController(StationManagerController manager) {

		managerController = manager;
	}

	/**
	 * Gets the threshold products.
	 *
	 * @param id the id
	 * @return the threshold products
	 */
	public static void getThresholdProducts(String id) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetThresholdProducts,id, DBControllerType.StationManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Gets the threshold products answer.
	 *
	 * @param msg the msg
	 * @return the threshold products answer
	 */
	@SuppressWarnings("unchecked")
	public static void getThresholdProductsAnswer(Message msg){
		switch (msg.getReturnMessageType()) {
		case Succeed:
			managerController.getThresholdSucceed((ArrayList<Threshold>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Threshold data wasn't found";
				managerController.getThresholdFailed(str);
			}
			managerController.getThresholdFailed((String)msg.getObj());
		default:
			break;
		}
	}

	/**
	 * Sets the threshold products.
	 *
	 * @param threshold the new threshold products
	 */
	public static void setThresholdProducts(ArrayList<Threshold> threshold) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.SetThresholdLevel,threshold, DBControllerType.StationManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Sets the threshold products answer.
	 *
	 * @param msg the new threshold products answer
	 */
	public static void setThresholdProductsAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			managerController.setThresholdSucceed((String)msg.getObj());
			break;
		case Failed:
			managerController.setThresholdFailed((String)msg.getObj());
			break;
		}
	}

	/**
	 * Gets the supply orders.
	 *
	 * @param id the id
	 * @return the supply orders
	 */
	public static void getSupplyOrders(String id) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetSupplyOrders,id, DBControllerType.StationManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Gets the supply orders answer.
	 *
	 * @param msg the msg
	 * @return the supply orders answer
	 */
	@SuppressWarnings("unchecked")
	public static void getSupplyOrdersAnswer(Message msg){
		System.out.println("been in getSupplyOrdersAnswer");
		switch (msg.getReturnMessageType()) {
		case Succeed:
			managerController.getOrdersSucceed((ArrayList<SupplyOrder>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Supply order data was'nt found";
				managerController.getOrdersFailed(str);
			}
			managerController.getOrdersFailed((String)msg.getObj());
		default:
			break;
		}
	}

	/**
	 * Update supply amount.
	 *
	 * @param order the order
	 * @param id the id
	 */
	public static void updateSupplyAmount(SupplyOrder order,String id) {

		ArrayList<Object> dataToServer = new ArrayList<Object>();
		dataToServer.add(order);
		dataToServer.add(id);
		
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.ReSupplyStock,dataToServer ,DBControllerType.StationManager);

		clientManager.ParseMessageToServer(messageToServer);

	}

	/**
	 * Update supply amount answer.
	 *
	 * @param msg the msg
	 */
	public static void updateSupplyAmountAnswer(Message msg){
		
		switch (msg.getReturnMessageType()) {
		case Succeed:
			managerController.updateSupplySucceed((String)msg.getObj());
			break;
		case Failed:
			managerController.updateSupplyFailed((String)msg.getObj());
		default:
			break;
		}
	}
}
//package stationClient;
//
//import java.util.ArrayList;
//
//import client.ClientManager;
//import entities.Message;
//import entities.SupplyOrder;
//import enums.DBControllerType;
//import enums.OperationType;
//import gui.StationManagerController;
//
//public class StationManagerClient {
//	
//	private static ClientManager clientManager = null;
//	private static StationManagerController managerController = null;
//
//	public static void setManagerController(StationManagerController manager) {
//		
//		managerController = manager;
//	}
//
//	/*case GetSupplyOrders:
//
//		case SendSupplyOrder:
//
//		case DeleteSupplyOrder:
//
//		case SetSupplierID:*/
//	/*
//	public static void getEmployees() {
//
//		clientManager = ClientManager.getClientManager();
//
//		Message messageToServer = new Message(OperationType.GetEmployees, null, DBControllerType.NetworkManager,managerController.getManagerController());
//
//		clientManager.ParseMessageToServer(messageToServer);
//
//	}
//
//	*/
//	

//	

//	
//	public static void removeOrder(long orderNumber) {
//		
//		clientManager = ClientManager.getClientManager();
//		
//		Message messageToServer = new Message(OperationType.DeleteSupplyOrder, orderNumber, DBControllerType.StationManager);
//		
//		clientManager.ParseMessageToServer(messageToServer);
//	}
//	
//	public static void removeOrderAnswer(Message msg) {
//		switch (msg.getReturnMessageType()) {
//		case Succeed:
//			managerController.removeOrderSucceed((long)msg.getObj());
//			break;
//		case Failed:
//			managerController.removeOrderFailed((String)msg.getObj());
//		default:
//			break;
//		}
//
//	}
//	
//}


