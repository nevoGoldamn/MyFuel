package fueling;

import java.util.ArrayList;

import client.ClientManager;
import entities.CampaignPurchases;
import entities.CampaignTemplate;
import entities.Customer;
import entities.Message;
import entities.Purchase;
import entities.Rates;
import enums.DBControllerType;
import enums.OperationType;
import gui.FulingController;

public class FuelingClientController {

	private static ClientManager clientManager;
	private static FulingController fulingController;

	public static void getCustomer(String CarId) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetCustomerByCarID,CarId, DBControllerType.Customer);

		clientManager.ParseMessageToServer(messageToServer);
	}

	@SuppressWarnings("unchecked")
	public static void getCustomerAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			if(((ArrayList<Customer>) msg.getObj()).get(0).getListOfCars() == null)
				fulingController.setCustomer((Customer)((ArrayList<Customer>)msg.getObj()).get(0));
			else
				fulingController.setCustomer((Customer)((ArrayList<Customer>)msg.getObj()).get(0));
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Customer data was'nt found";
				fulingController.getCustomerFailed(str);
			}
			fulingController.getCustomerFailed((String)msg.getObj());
			break;
		}
	}

	public static void getRates() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetRates, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	@SuppressWarnings("unchecked")
	public static void getRatesAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			fulingController.getRatesSucceed((ArrayList<Rates>)msg.getObj());
			break;
		case Failed:
			fulingController.getRatesFailed((String)msg.getObj());
			break;
		}
	}

	public static void getFuelPrices() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetFuelPrices, null, DBControllerType.Customer);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	@SuppressWarnings("unchecked")
	public static void getFuelPricesAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			fulingController.getFuelPricesSucceed((ArrayList<Double>)msg.getObj());
			break;
		case Failed:
			fulingController.getFuelPricesFailed((String)msg.getObj());
			break;
		}
	}

	public static void GetActivatedSaleCampaigns() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetActivatedSale, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);

	}

	@SuppressWarnings("unchecked")
	public static void GetActivatedSaleCampaignsAnswer(Message msg){
		switch (msg.getReturnMessageType()){
		case Succeed:
			fulingController.getSaleCampaignSucceeded(((ArrayList<CampaignTemplate>)msg.getObj()).get(0));
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Campaign data wasn't found";
				fulingController.getSaleCampaignFailed(str);
			}
			fulingController.getSaleCampaignFailed((String)msg.getObj());
		default:
			break;
		}
	}
	
	public static void getCurrentAmount(String stationID,String productID) {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add(stationID);
		data.add(productID);
		
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetCurrentAmount,data ,DBControllerType.StationManager);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	@SuppressWarnings("unchecked")
	public static void getCurrentAmountAnswer(Message msg) {
		
		switch (msg.getReturnMessageType()) {
		case Succeed:
			fulingController.getCurrentAmountSucceeded((Double)msg.getObj());
			break;
		case Failed:
			fulingController.getCurrentAmountFailed((String)msg.getObj());
			break;
		}
	}

	public static void setFulingController(FulingController fulingC) {
		fulingController = fulingC;
	}

	public static void updateCampainPurchases(CampaignPurchases campaignP) {
		// TODO Auto-generated method stub
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.updateCampainPurchases,campaignP ,DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	
	public static void updateCampainPurchasesAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			fulingController.updateCampainPurchasesSuccess((String)msg.getObj());
			break;
		case Failed:
			fulingController.updateCampainPurchasesFailed((String)msg.getObj());
			break;
		}
	}

	public static void updatePurchases(Purchase purchase) {
		// TODO Auto-generated method stub
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.updatePurchases,purchase ,DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	public static void updatePurchasesAnswer(Message msg) {
		switch (msg.getReturnMessageType()) {
		case Succeed:
			fulingController.updatePurchasesSuccess((String)msg.getObj());
			break;
		case Failed:
			fulingController.updatePurchasesFailed((String)msg.getObj());
			break;
		}
	}

	public static void updateStock(double amount,String productID,String stationID) {
		
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(amount);
		data.add(productID);
		data.add(stationID);
		
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.updateCurrentAmountInStock, data,DBControllerType.StationManager);

		clientManager.ParseMessageToServer(messageToServer);
	}
	
	public static void updateStockAnswer(Message msg) {
	
		switch (msg.getReturnMessageType()) {
		case Succeed:
			fulingController.updateStockSuccess((String)msg.getObj());
			break;
		case Failed:
			fulingController.updateStockFailed((String)msg.getObj());
			break;
		}
	}
	
}
