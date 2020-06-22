package main;

import CustomerClient.CustomerClientController;
import UserClient.Login;
import UserClient.Logout;
import client.ClientManager;
import entities.Message;
import fueling.FuelingClientController;
import gui.MarketingManagerController;
import networkManagerClient.NetworkClientController;
import stationClient.StationManagerClient;
import marketingManagerClient.MarketingClientController;
import marketingRepClient.MarketingRepClientController;


// TODO: Auto-generated Javadoc
/**
 * The Class ClientParser.
 */
public class ClientParser {

	/** The client manager. */
	private static ClientManager clientManager = null;
	
	/**
	 * Instantiates a new client parser.
	 */
	public ClientParser() {
		clientManager = ClientManager.getClientManager();
	}
	
	/**
	 * Parses the message.
	 *
	 * @param msg the msg
	 */
	public void parseMessage(Message msg) {
		
		switch(msg.getOperationType()) {
//		case GetEmployees:
//			EmployeeController.getEmployeesAnswer(msg);
//			break;
		case Login:
			Login.loginAnswer(msg);
			break;
		case Logout:
			Logout.logoutAnswer(msg);
			break;
		case RegistrationNoCar:
			MarketingRepClientController.addCustomerAnswer(msg);
			break;
		case GetCustomersIDs:
			MarketingRepClientController.getAllCustomerIDAnswer(msg);
			break;
		case GetCars:

		case AddDalkan:
			break;
		case ProduceAnalitic:
			MarketingRepClientController.produceAnaliticAnswer(msg);
			break;
		case GetSaleCampaignInfo:
			MarketingClientController.getSalePurchesesByCampaginNameAnswer(msg);
			break;
		case updateCurrentAmountInStock:
			FuelingClientController.updateStockAnswer(msg);
			break;
		case updatePurchases:
			FuelingClientController.updatePurchasesAnswer(msg);
			break;
		case updateCampainPurchases:
			FuelingClientController.updateCampainPurchasesAnswer(msg);
			break;
		case UpdateCampaignStatus:
			MarketingClientController.UpdateCampaignStatusAnswer(msg);
			break;
		case GetCurrentAmount:
			FuelingClientController.getCurrentAmountAnswer(msg);
			break;
		case GetActivatedSale:
			FuelingClientController.GetActivatedSaleCampaignsAnswer(msg);
			break;
		case GetRates:
			FuelingClientController.getRatesAnswer(msg);
			break;
		case GetFuelPrices:
			FuelingClientController.getFuelPricesAnswer(msg);
			break;
		case GetCustomerByCarID:
			FuelingClientController.getCustomerAnswer(msg);
			break;
		case GetCustomer:
			CustomerClientController.getCustomerAnswer(msg);
			break;
		case RegistrationWithCar:
			MarketingRepClientController.addCustomerWithCarAnswer(msg);
			break;
		case SubmitHomeFuelOrder:
			CustomerClientController.setOrderAnswer(msg);
			break;
		case GetCustomerOrders:
			CustomerClientController.getOrderAnswer(msg);
			break;
		case GetSupplyOrders:
			StationManagerClient.getSupplyOrdersAnswer(msg);
			break;
		case getLastOrderNumber:
			CustomerClientController.getLastOrderNumberAnswer(msg);
			break;
		case ReSupplyStock:
			StationManagerClient.updateSupplyAmountAnswer(msg);
			break;
		case RestTmpRates:
			MarketingClientController.resetTmpRatesAnswer(msg);
			break;
		case SendForApproval:
			MarketingClientController.sendForApprovalAnswer(msg);
			break;
		case UpdateRates:
			NetworkClientController.updateRatesAnswer(msg);
			break;
		case GetRealRates:
			MarketingClientController.getRatesAnswer(msg);
			break;
		case GetTmpRates:
			MarketingClientController.getTmpRatesAnswer(msg);
			break;
		case GetTmpRatesNet:
			NetworkClientController.getTmpRatesAnswer(msg);
			break;
		case SendApproval:
			NetworkClientController.sendApprovalAnswer(msg);
			break;
		case SetTotal:
			
		case GetThresholdProducts:
			StationManagerClient.getThresholdProductsAnswer(msg);
			break;
		case SetThresholdLevel:
			StationManagerClient.setThresholdProductsAnswer(msg);
			break;
			
		case GetActivatedSaleCampaigns:
			MarketingClientController.GetActivatedSaleCampaignsAnswer(msg);
			break;
			
		case GetInactiveSaleCampaigns:
			MarketingClientController.GetInactiveSaleCampaignsAnswer(msg);
			break;

		case ActivateSaleCampaign:
			MarketingClientController.ActivateCampaignAnswer(msg);
			break;
		case GenerateCampaignTemplate:
			MarketingRepClientController.GenerateCampaignTemplateAnswer(msg);
			break;
		}
		
	}

	
}
