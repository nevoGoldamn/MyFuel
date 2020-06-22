package marketingManagerClient;

import java.util.ArrayList;
import client.ClientManager;
import entities.CampaignPurchases;
import entities.CampaignTemplate;
import entities.CustomerSaleCampaignRecord;
import entities.Message;
import entities.Rates;
import enums.DBControllerType;
import enums.OperationType;
import enums.SaleCampaignStatusType;
import gui.MarketingManagerController;

// TODO: Auto-generated Javadoc
/**
 * The Class MarketingClientController.
 */
public class MarketingClientController {

	/** The client manager. */
	private static ClientManager clientManager;
	
	/** The marketing manager controller. */
	private static MarketingManagerController marketingManagerController;


	/**
	 * Sets the marketing manager controller.
	 *
	 * @param marketingMController the new marketing manager controller
	 */
	public static void setMarketingManagerController(MarketingManagerController marketingMController) {
		marketingManagerController = marketingMController;
	}

	/**
	 * Send for approval.
	 *
	 * @param rates the rates
	 */
	public static void sendForApproval(ArrayList<Rates> rates) {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.SendForApproval,rates, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}


	/**
	 * Send for approval answer.
	 *
	 * @param msg the msg
	 */
	public static void sendForApprovalAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingManagerController.sendForApprovalSucceed((String)msg.getObj());
			break;
		case Failed:
			marketingManagerController.sendForApprovalFailed((String)msg.getObj());
			break;
		}
	}

	/**
	 * Reset tmp rates.
	 */
	public static void resetTmpRates() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.RestTmpRates,null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Reset tmp rates answer.
	 *
	 * @param msg the msg
	 */
	public static void resetTmpRatesAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingManagerController.resetTmpRatesSucceed((String)msg.getObj());
			break;
		case Failed:
			marketingManagerController.resetTmpRatesFailed((String)msg.getObj());
			break;
		}
	}

	/**
	 * Gets the rates.
	 *
	 * @return the rates
	 */
	public static void getRates() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetRealRates, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}
	

	/**
	 * Gets the rates answer.
	 *
	 * @param msg the msg
	 * @return the rates answer
	 */
	public static void getRatesAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingManagerController.getRatesSucceed((ArrayList<Rates>)msg.getObj());
			break;
		case Failed:
			marketingManagerController.getRatesFailed((String)msg.getObj());
			break;
		}
	}

	/**
	 * Gets the tmp rates.
	 *
	 * @return the tmp rates
	 */
	public static void getTmpRates() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetTmpRates, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Gets the tmp rates answer.
	 *
	 * @param msg the msg
	 * @return the tmp rates answer
	 */
	@SuppressWarnings("unchecked")
	public static void getTmpRatesAnswer(Message msg) {

		switch (msg.getReturnMessageType()) {
		case Succeed:
			marketingManagerController.getTmpRatesSucceed((ArrayList<Rates>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null){
				marketingManagerController.getTmpRatesFailed("null");
			}
			marketingManagerController.getTmpRatesFailed((String)msg.getObj());
			break;
		}
	}

	/**
	 * Gets the activated sale campaigns.
	 */
	public static void GetActivatedSaleCampaigns() {//get the names of the sale

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetActivatedSaleCampaigns, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);

	}

	/**
	 * Gets the activated sale campaigns answer.
	 *
	 * @param msg the msg
	 */
	@SuppressWarnings("unchecked")
	public static void GetActivatedSaleCampaignsAnswer(Message msg){
		switch (msg.getReturnMessageType()){
		case Succeed:
			marketingManagerController.getSaleCampaignSucceeded((ArrayList<CampaignPurchases>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Campaign data wasn't found";
				marketingManagerController.getSaleCampaignFailed(str);
			}
			marketingManagerController.getSaleCampaignFailed((String)msg.getObj());
		default:
			break;
		}
	}
	
	/**
	 * Activate campaign.
	 *
	 * @param CampaignName the campaign name
	 * @param startTime the start time
	 * @param finishTime the finish time
	 */
	public static void ActivateCampaign(String CampaignName, String startTime, String finishTime) {
		clientManager = ClientManager.getClientManager();
		ArrayList<Object> dataToServer = new ArrayList<Object>();
		dataToServer.add(CampaignName);
		dataToServer.add(startTime);
		dataToServer.add(finishTime);
		Message messageToServer = new Message(OperationType.ActivateSaleCampaign, dataToServer ,DBControllerType.MarketingManager);
		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Activate campaign answer.
	 *
	 * @param msg the msg
	 */
	@SuppressWarnings("unchecked")
	public static void ActivateCampaignAnswer(Message msg){
		switch (msg.getReturnMessageType()){
		case Succeed:
			marketingManagerController.ActivateCampaignSucceeded((String)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Campaign data wasn't foun";
				marketingManagerController.ActivateCampaignFailed(str);
			}
			marketingManagerController.ActivateCampaignFailed((String)msg.getObj());
		default:
			break;
		}
	}
	
	/**
	 * Gets the inactive sale campaigns.
	 */
	public static void GetInactiveSaleCampaigns() {

		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetInactiveSaleCampaigns, null, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);

	}

	/**
	 * Gets the inactive sale campaigns answer.
	 *
	 * @param msg the msg
	 */
	@SuppressWarnings("unchecked")
	public static void GetInactiveSaleCampaignsAnswer(Message msg){
		switch (msg.getReturnMessageType()){
		case Succeed:
			marketingManagerController.getInactiveSaleCampaignSucceeded((ArrayList<CampaignTemplate>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Campaign data wasn't found";
				marketingManagerController.getInactiveSaleCampaignFailed(str);
			}
			marketingManagerController.getInactiveSaleCampaignFailed((String)msg.getObj());
		default:
			break;
		}
	}
	

	/**
	 * Update campaign status.
	 *
	 * @param Status the status
	 * @param CampaignName the campaign name
	 */
	public static void UpdateCampaignStatus(SaleCampaignStatusType Status, String CampaignName) {
		clientManager = ClientManager.getClientManager();
		ArrayList<Object> dataToServer = new ArrayList<Object>();
		dataToServer.add(Status.name());
		dataToServer.add(CampaignName);
		Message messageToServer = new Message(OperationType.UpdateCampaignStatus, dataToServer ,DBControllerType.MarketingManager);
		clientManager.ParseMessageToServer(messageToServer);
	}

	/**
	 * Update campaign status answer.
	 *
	 * @param msg the msg
	 */
	@SuppressWarnings("unchecked")
	public static void UpdateCampaignStatusAnswer(Message msg){
		switch (msg.getReturnMessageType()){
		case Succeed:
			marketingManagerController.updateCampaignStatusSucceeded((String)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Campaign data wasn't foun";
				marketingManagerController.updateCampaignStatusFailed(str);
			}
			marketingManagerController.updateCampaignStatusFailed((String)msg.getObj());
		default:
			break;
		}
	}

	/**
	 * Gets the sale purcheses by campagin ID.
	 *
	 * @param id the id
	 * @return the sale purcheses by campagin ID
	 */
	public static void getSalePurchesesByCampaginID(String id) {
		// TODO Auto-generated method stub
		clientManager = ClientManager.getClientManager();

		Message messageToServer = new Message(OperationType.GetSaleCampaignInfo, id, DBControllerType.MarketingManager);

		clientManager.ParseMessageToServer(messageToServer);
	}

	
	/**
	 * Gets the sale purcheses by campagin name answer.
	 *
	 * @param msg the msg
	 * @return the sale purcheses by campagin name answer
	 */
	@SuppressWarnings("unchecked")
	public static void getSalePurchesesByCampaginNameAnswer(Message msg){
		switch (msg.getReturnMessageType()){
		case Succeed:
			marketingManagerController.getSalePurchesesByCampaginNameSucceeded((ArrayList<CustomerSaleCampaignRecord>)msg.getObj());
			break;
		case Failed:
			if(msg.getObj() == null) {
				String str = "Campaign data wasn't found";
				marketingManagerController.getSalePurchesesByCampaginNameFailed(str);
			}
			marketingManagerController.getSalePurchesesByCampaginNameFailed((String)msg.getObj());
		default:
			break;
		}
	}
	
		
}
