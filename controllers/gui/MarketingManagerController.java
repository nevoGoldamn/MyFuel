package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.controlsfx.control.Notifications;
import org.omg.PortableInterceptor.TRANSPORT_RETRY;
import com.jfoenix.controls.JFXTimePicker;
import UserClient.Logout;
import entities.CampaignPurchases;
import entities.CampaignTemplate;
import entities.CustomerSaleCampaignRecord;
import entities.Rates;
import entities.User;
import enums.SaleCampaignStatusType;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.converter.FloatStringConverter;
import marketingManagerClient.MarketingClientController;

// TODO: Auto-generated Javadoc
/**
 * The Class MarketingManagerController.
 */
public class MarketingManagerController extends CustomerController {


	/** The menu image. */
	Image menuImage = new Image("/icon/menu.png");
	
	/** The menu image red. */
	Image menuImageRed = new Image("/icon/menuRed.png");
	
	/** The image. */
	Image image;
	
	/** The home. */
	Image home = new Image("/icon/home.png");
	
	/** The home red. */
	Image homeRed = new Image("/icon/homeRed.png");
	
	/** The stock. */
	Image stock = new Image("/icon/stock.png");
	
	/** The stock red. */
	Image stockRed = new Image("/icon/stockRed.png");
	
	/** The sell. */
	Image sell = new Image("/icon/sell2.png");
	
	/** The sell red. */
	Image sellRed = new Image("/icon/sell2Red.png");
	
	/** The employee. */
	Image employee = new Image("/icon/employe.png");
	
	/** The employee red. */
	Image employeeRed = new Image("/icon/employeRed.png");
	
	/** The setting. */
	Image setting = new Image("/icon/settings.png");
	
	/** The setting red. */
	Image settingRed = new Image("/icon/settingsRed.png");
	
	/** The about. */
	Image about = new Image("/icon/about.png");
	
	/** The about red. */
	Image aboutRed = new Image("/icon/aboutRed.png");
	// add all icons and imageviews

	/** The ac dash bord. */
	@FXML
	private AnchorPane acDashBord;

	/** The scroll pane. */
	@FXML
	private ScrollPane scrollPane;

	/** The home button. */
	@FXML
	private Button homeButton;

	/** The Sale campaign button. */
	@FXML
	private Button SaleCampaignButton;

	/** The campagin. */
	@FXML
	private ImageView campagin;

	/** The about button. */
	@FXML
	private Button aboutButton;

	/** The Set rates button. */
	@FXML
	private Button SetRatesButton;

	/** The Reports button. */
	@FXML
	private Button ReportsButton;

	/** The report. */
	@FXML
	private ImageView report;

	/** The app content. */
	@FXML
	private BorderPane appContent;

	/** The ac head. */
	@FXML
	private AnchorPane acHead;

	/** The menu button. */
	@FXML
	private MenuButton menuButton;

	/** The menu user name. */
	@FXML
	private Label menuUserName;

	/** The log out button. */
	@FXML
	private Button logOutButton;

	/** The sell 1. */
	@FXML
	private ImageView sell1;

	/** The label user name. */
	@FXML
	private Label labelUserName;

	/** The toggle button. */
	@FXML
	private ToggleButton toggleButton;

	/** The img menu btn. */
	@FXML
	private ImageView imgMenuBtn;

	/** The Titel id. */
	@FXML
	private Label TitelId;

	/** The about frame. */
	@FXML
	private AnchorPane aboutFrame;

	/** The textarea about. */
	@FXML
	private TextArea textareaAbout;

	/** The Comments report frame. */
	@FXML
	private AnchorPane CommentsReportFrame;

	/** The Sale campaign list view. */
	@FXML
	private ListView<String> SaleCampaignListView; // check

	/** The customer expense table. */
	@FXML
	private TableView<CustomerSaleCampaignRecord> customerExpenseTable;

	/** The Customer ID column. */
	@FXML
	private TableColumn<CampaignPurchases, String> CustomerIDColumn;

	/** The Expense column. */
	@FXML
	private TableColumn<CampaignPurchases, Double> ExpenseColumn;

	/** The Number customers field. */
	@FXML
	private TextField NumberCustomersField;

	/** The Sum expenses field. */
	@FXML
	private TextField SumExpensesField;

	/** The Number of customers title. */
	@FXML
	private Text NumberOfCustomersTitle;

	/** The Sum expenses title. */
	@FXML
	private Text SumExpensesTitle;

	/** The Sale campaign title. */
	@FXML
	private Text SaleCampaignTitle;

	/** The Produce comment report button. */
	@FXML
	private Button ProduceCommentReportButton;

	/** The Reports frame. */
	@FXML
	private AnchorPane ReportsFrame;

	/** The characteriz button. */
	@FXML
	private Button characterizButton;

	/** The duc 2. */
	@FXML
	private ImageView duc2;

	/** The comment report button. */
	@FXML
	private Button commentReportButton;

	/** The duc 1. */
	@FXML
	private ImageView duc1;

	/** The set rates frame. */
	@FXML
	private AnchorPane setRatesFrame;

	/** The rates table. */
	@FXML
	private TableView<Rates> ratesTable;

	/** The subscription type column. */
	@FXML
	private TableColumn<Rates, String> subscriptionTypeColumn;

	/** The price column. */
	@FXML
	private TableColumn<Rates, Float> priceColumn;

	/** The discount column. */
	@FXML
	private TableColumn<Rates, Float> discountColumn;

	/** The total column. */
	@FXML
	private TableColumn<Rates, Float> totalColumn;

	/** The send for approval button. */
	@FXML
	private Button sendForApprovalButton;

	/** The send. */
	@FXML
	private ImageView send;

	/** The Update to db button. */
	@FXML
	private Button UpdateToDbButton;

	/** The database. */
	@FXML
	private ImageView database;

	/** The sale campagin frame. */
	@FXML
	private AnchorPane saleCampaginFrame;

	/** The inactive campaigns list. */
	@FXML
	private ListView<String> inactiveCampaignsList;

	/** The activat sale campaign button. */
	@FXML
	private Button activatSaleCampaignButton;

	/** The activat. */
	@FXML
	private ImageView activat;

	/** The home frame. */
	@FXML
	private AnchorPane homeFrame;

	/** The welcome label. */
	@FXML
	private Label welcomeLabel;

	/** The Start time picker. */
	@FXML
	private JFXTimePicker StartTimePicker;

	/** The Finish time picker. */
	@FXML
	private JFXTimePicker FinishTimePicker;

	/** The Start hour text. */
	@FXML
	private Label StartHourText;

	/** The Finish hour text. */
	@FXML
	private Label FinishHourText;

	/** The user. */
	private User user;

	/** The reset flag. */
	private boolean resetFlag = false;

	/** The on edit flag. */
	private boolean onEditFlag = true;

	/** The rates. */
	private ArrayList<Rates> rates = new ArrayList<Rates>(4);

	/** The finish time. */
	//private MarketingManager marketingManager;
	private String startTime, finishTime;

	/** The campaign to activate. */
	private static String campaignToActivate;

	/** The customers expenses in sale. */
	private ObservableList<CustomerSaleCampaignRecord> customersExpensesInSale;

	/** The sale campaings name. */
	private ObservableList<String> saleCampaingsName;

	/** The inactive sale campaign names. */
	private ObservableList<String> inactiveSaleCampaignNames;

	/** The inactive sale campaigns. */
	private ArrayList<CampaignTemplate> inactiveSaleCampaigns;

	/** The sale campaigns. */
	private ArrayList<CampaignPurchases> saleCampaigns;

	/** The specific sale. */
	private CampaignPurchases specificSale;

	/** The flag. */
	private static boolean flag = true;
	
	/** The my file. */
	private static File myFile;

	/**
	 * Load welcome lable.
	 *
	 * @param user the user
	 */
	@Override
	public void loadWelcomeLable(User user) {
		this.user = user;

		welcomeLabel.setText("Welcome To MyFuel " + user.getFirstName()
		+ " " + user.getLastName());
		labelUserName.setText(user.getFirstName());

		MarketingClientController.setMarketingManagerController(this);
		MarketingClientController.getRates();

	}

	/**
	 * Log out operation.
	 */
	@Override
	protected void logOutOperation() {
		// TODO Auto-generated method stub
		Logout.setMainWindowController(this);
		Logout.logoutRequest(user);
	}

	/**
	 * Logout succeeded.
	 */
	@Override
	public void logoutSucceeded() {
		// TODO Auto-generated method stub
		super.logoutSucceeded();
	}

	/**
	 * Logout failed.
	 */
	@Override
	public void logoutFailed() {
		// TODO Auto-generated method stub
		super.logoutFailed();
	}


	/**
	 * Edits the discount.
	 *
	 * @param editEvent the edit event
	 */
	@FXML
	void editDiscount(CellEditEvent<Rates, Float> editEvent) {

		try {

			if(isNumeric(editEvent.getNewValue().toString()) == 0) {
				throw new Exception("Not a number");
			}
			if(editEvent.getNewValue().floatValue() < 0 || editEvent.getNewValue().floatValue() > 0.9){
				throw new Exception("Invalid input");
			}
			Rates rate = (Rates) ratesTable.getSelectionModel().getSelectedItem();
			rate.setDiscount(editEvent.getNewValue().floatValue());

			//			if(onEditFlag) {
			//				MarketingClientController.resetTmpRates();
			//				System.out.println("been to resetTmpRates");
			//				onEditFlag = false;
			//			}

			switch (rate.getSubscriptionType()) {
			case Intermediate:
				rates.set(0, rate);
				break;
			case Regular:
				rates.set(1, rate);
				break;
			case PluralityOfCars:
				rates.set(2, rate);
				break;
			case Full:
				rates.set(3, rate);
				break;
			}

		} catch (Exception e) {

			// TODO Auto-generated method stub
			Image img = new Image("icon/error.png");
			Notifications notificationsBuilder = Notifications.create()
					.title("Rates")
					.text(e.getMessage())
					.graphic(new ImageView(img))
					.hideAfter(Duration.seconds((3)))
					.position(Pos.CENTER);
			notificationsBuilder.darkStyle();
			notificationsBuilder.show();
		}

	}

	/**
	 * Checks if is numeric.
	 *
	 * @param str the str
	 * @return the float
	 */
	public static float isNumeric(String str) { 
		try {  
			Float.parseFloat(str);  
			return Float.parseFloat(str);  
		} catch(NumberFormatException e){  
			return 0;  
		}  
	}

	/**
	 * Handel clicks.
	 *
	 * @param event the event
	 */
	@FXML
	void handelClicks(ActionEvent event) {

		if(event.getSource() == homeButton) {
			TitelId.setText("MyFuel");
			homeFrame.toFront();

		} else if(event.getSource() == SaleCampaignButton) {
			TitelId.setText("Sale Activation");
			saleCampaginFrame.toFront();
			MarketingClientController.GetInactiveSaleCampaigns();
			if(flag) {
				activatSaleCampaignButton.setDisable(false);
			}

		} else if(event.getSource() == sendForApprovalButton) {
			MarketingClientController.sendForApproval(rates);
			onEditFlag = true;


		} else if(event.getSource() == SetRatesButton) {
			//check if any approval had came from manager
			TitelId.setText("Rates");
			setRatesFrame.toFront();
			MarketingClientController.getTmpRates();


		} else if(event.getSource() == aboutButton) {
			TitelId.setText("About");
			aboutFrame.toFront();

		} else if(event.getSource() == commentReportButton) {
			TitelId.setText("Comment Report");
			CommentsReportFrame.toFront();
			MarketingClientController.GetActivatedSaleCampaigns();

		} else if(event.getSource() == ReportsButton) {
			TitelId.setText("Reports");
			ReportsFrame.toFront();

		} else if(event.getSource() == activatSaleCampaignButton && flag){

			campaignToActivate = inactiveCampaignsList.getSelectionModel().getSelectedItem();
			if(StartTimePicker.getValue() != null && FinishTimePicker.getValue() != null){
				//ADD CHECK COMPARING TO CURRENT CLOCK TIME, maybe needs InProgress instead of Approved
				startTime = StartTimePicker.getValue().toString();
				finishTime = FinishTimePicker.getValue().toString();
				MarketingClientController.ActivateCampaign(campaignToActivate, startTime, finishTime);

			}

		} else if(event.getSource() == ProduceCommentReportButton){
			myFile = new File("CommentReportForCampaignID-" + specificSale.getCampaignID() + ".txt");
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(myFile);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			writer.print("");
			writer.close();
			writeLineToTextFile("Comment Report for: " + specificSale.getCampaignName()
			+ System.lineSeparator() + "Number of Customers purchased in this sale campaign: " +
			NumberCustomersField.getText() + System.lineSeparator() +
			"Total sum of customer expenses: " + SumExpensesField.getText()
			+ System.lineSeparator() + "List of customers and their expense in the campaign: "
			+ System.lineSeparator() + customersExpensesInSale);
		} else if(event.getSource() == logOutButton) {
			//logout function.
			logOutOperation();
		}    	   	
	}



	/**
	 * Specific sale campaign clicked.
	 *
	 * @param event the event
	 */
	@FXML
	void SpecificSaleCampaignClicked(MouseEvent event) {
		double totalCustomersExpenses = 0;
		//CustomerSaleCampaignRecord customerInfo;

		for(CampaignPurchases s: saleCampaigns) {
			if(s.getCampaignName() == SaleCampaignListView.getSelectionModel().getSelectedItem()) {
				specificSale = s;
				break;
			}
		}
		MarketingClientController.getSalePurchesesByCampaginID(specificSale.getCampaignID());
		//		 
		//		 ArrayList<CustomerSaleCampaignRecord> cscrs = new ArrayList<CustomerSaleCampaignRecord>();
		//		 double total;
		//		 Map<String, Double> totalExpensPerCustomer = new HashMap<String, Double>();
		//		 ArrayList<String> ids = new ArrayList<String>();
		//		 
		//		 for(CustomerSaleCampaignRecord c : specificSale.getCustomers()) {
		//			 ids.add(c.getCustomerID());
		//		 }
		//		 
		//		 ids = removeDuplicates(ids);
		//		 for(String s: ids) {
		//			 totalExpensPerCustomer.put(s,(double)0);
		//		 }
		//		 
		//		 for(int i = 0; i < ids.size(); i++) {
		//			 for(CustomerSaleCampaignRecord c : specificSale.getCustomers()) {
		//				 if(c.getCustomerID().equals(ids.get(i))) {
		//					 total = totalExpensPerCustomer.get(ids.get(i));
		//					 total += c.getTotalAmount();
		//					 totalExpensPerCustomer.put(ids.get(i),total);
		//					 total = 0;
		//				 }
		//			 }
		//		 }
		//		 
		//		 for(String s : ids) {
		//			 CustomerSaleCampaignRecord cscr = new CustomerSaleCampaignRecord(s,totalExpensPerCustomer.get(s));
		//			 cscrs.add(cscr);
		//		 }
		//		
		//		 customersExpensesInSale = FXCollections.observableArrayList(cscrs);
		//		 customerExpenseTable.setItems(customersExpensesInSale);
		//		 NumberCustomersField.setText(Integer.toString((ids.size())));//fix to ids.size()
		//
		//		 for(CustomerSaleCampaignRecord c: specificSale.getCustomers()){//fixxxx
		//			 totalCustomersExpenses += c.getTotalAmount();
		//		 }
		//		 SumExpensesField.setText(Double.toString(totalCustomersExpenses));
	}

	/**
	 * Side menu toggle btn on C lick.
	 *
	 * @param event the event
	 */
	@FXML
	void sideMenuToggleBtnOnCLick(ActionEvent event) {
		if (toggleButton.isSelected()) {
			imgMenuBtn.setImage(menuImageRed);
			TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
			sideMenu.setByX(-130);
			sideMenu.play();
			acDashBord.getChildren().clear();
		} else {
			imgMenuBtn.setImage(menuImage);
			TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
			sideMenu.setByX(130);
			sideMenu.play();
			acDashBord.getChildren().add(scrollPane);
		}
	}

	/**
	 * Initialize.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		homeFrame.toFront();
		TitelId.setText("MyFuel");
		ratesTable.setEditable(true);
		discountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
		discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
		subscriptionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subscriptionType"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("constFuelPrice"));
		totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
		CustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		ExpenseColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
		MarketingClientController.setMarketingManagerController(this);
		UpdateToDbButton.setDisable(true);
		NumberCustomersField.setEditable(false);
		SumExpensesField.setEditable(false);
	}

	/**
	 * Gets the rates succeed.
	 *
	 * @param msg the msg
	 * @return the rates succeed
	 */
	public void getRatesSucceed(ArrayList<Rates> msg) {
		//need to put in the table

		// TODO Auto-generated method stub
		System.out.println("been in getRatesSucceed ");
		this.rates = msg;
		ObservableList<Rates> ratesFX = FXCollections.observableArrayList(rates);
		ratesTable.setItems(ratesFX);


		System.out.println("been in getRatesSucceed  after rates=msg");
	}

	/**
	 * Gets the rates failed.
	 *
	 * @param msg the msg
	 * @return the rates failed
	 */
	public void getRatesFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Rates")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});
	}

	/**
	 * Send for approval succeed.
	 *
	 * @param msg the msg
	 */
	public void sendForApprovalSucceed(String msg) {
		System.out.println("been to sendForApprovalSucceed");
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				ratesTable.setEditable(false);
				Image img = new Image("icon/mark.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Rates")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});
	}



	/**
	 * Send for approval failed.
	 *
	 * @param msg the msg
	 */
	public void sendForApprovalFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Rates")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});
	}

	/**
	 * Gets the tmp rates succeed.
	 *
	 * @param msg the msg
	 * @return the tmp rates succeed
	 */
	public void getTmpRatesSucceed(ArrayList<Rates> msg) {

		// TODO Auto-generated method stub
		System.out.println("been in getTmpRatesSucceed ");
		boolean flag = false;
		for(Rates r: msg) {
			if(r.isApproved()) {
				flag = true;
				resetFlag = true;
				break;
			}
		}

		if(flag) {

			for(Rates r: msg) {
				r.setApproved(false);
			}

			ratesTable.setEditable(true);
			this.rates = msg;
			ObservableList<Rates> ratesFX = FXCollections.observableArrayList(rates);
			ratesTable.setItems(ratesFX);

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Image img = new Image("/icon/mark.png");
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Rates");
					alert.setGraphic(new ImageView(img));
					alert.setContentText("The network manager Approved the Rates");
					alert.showAndWait();

				}
			});

			MarketingClientController.resetTmpRates();

		} else {

			System.out.println("been in getTmpRatesSucceed ELSE");
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("No messages from the manager");
					alert.setTitle("Rates");
					alert.setContentText("you can edit the discount column");
					alert.showAndWait();
					ratesTable.setEditable(true);
				}
			});
			// TODO Auto-generated method stub

		}

		//		Platform.runLater(new Runnable() {
		//			
		//			@Override
		//			public void run() {
		//				// TODO Auto-generated method stub
		//				System.out.println("been in reset ");
		//				
		//			}
		//		});

	}

	/**
	 * Gets the tmp rates failed.
	 *
	 * @param msg the msg
	 * @return the tmp rates failed
	 */
	public void getTmpRatesFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Rates")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});

	}

	/**
	 * Reset tmp rates succeed.
	 *
	 * @param msg the msg
	 */
	public void resetTmpRatesSucceed(String msg) {

	}

	/**
	 * Reset tmp rates failed.
	 *
	 * @param msg the msg
	 */
	public void resetTmpRatesFailed(String msg) {

	}

	/**
	 * Gets the sale campaign succeeded.
	 *
	 * @param campaigns the campaigns
	 * @return the sale campaign succeeded
	 */
	public void getSaleCampaignSucceeded(ArrayList<CampaignPurchases> campaigns) {

		this.saleCampaigns = campaigns;

		ArrayList<String> saleCampaigns = new ArrayList<String>();
		for(CampaignPurchases cp: campaigns) {
			saleCampaigns.add(cp.getCampaignName());
		}
		saleCampaigns = removeDuplicates(saleCampaigns);

		saleCampaingsName = FXCollections.observableArrayList(saleCampaigns);

		SaleCampaignListView.setItems(saleCampaingsName);

	}

	/**
	 * Removes the duplicates.
	 *
	 * @param list the list
	 * @return the array list
	 */
	private static ArrayList<String> removeDuplicates(ArrayList<String> list) 
	{ 

		// Create a new ArrayList 
		ArrayList<String> newList = new ArrayList<String>(); 

		// Traverse through the first list 
		for (String element : list) { 

			// If this element is not present in newList 
			// then add it 
			if (!newList.contains(element)) { 

				newList.add(element); 
			} 
		} 
		// return the new list 
		return newList; 
	} 

	/**
	 * Gets the sale campaign failed.
	 *
	 * @param msg the msg
	 * @return the sale campaign failed
	 */
	public void getSaleCampaignFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Sale Campaigns")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});

	}

	//	public void setMarketingManager(MarketingManager marketingM) {
	//		// TODO Auto-generated method stub
	//		this.marketingManager = marketingM;
	//
	//	}

	/**
	 * Gets the marketing manager failed.
	 *
	 * @param msg the msg
	 * @return the marketing manager failed
	 */
	public void getMarketingManagerFailed(String msg) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Gets the inactive sale campaign succeeded.
	 *
	 * @param inactiveCampaigns the inactive campaigns
	 * @return the inactive sale campaign succeeded
	 */
	public void getInactiveSaleCampaignSucceeded(ArrayList<CampaignTemplate> inactiveCampaigns) {
		inactiveSaleCampaigns = inactiveCampaigns;
		ArrayList<String> saleCampaigns = new ArrayList<String>();
		for(CampaignTemplate cp: inactiveCampaigns) {
			saleCampaigns.add(cp.getCampaignName());
		}
		inactiveSaleCampaignNames = FXCollections.observableArrayList(saleCampaigns);
		inactiveCampaignsList.setItems(inactiveSaleCampaignNames);
	}

	/**
	 * Gets the inactive sale campaign failed.
	 *
	 * @param msg the msg
	 * @return the inactive sale campaign failed
	 */
	public void getInactiveSaleCampaignFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Sale Campaigns")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});

	}
	
	/**
	 * Activate campaign succeeded.
	 *
	 * @param msg the msg
	 */
	public void ActivateCampaignSucceeded(String msg) {
		// check this function
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("icon/mark.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Campaign status updated and activated successfully")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
				
			}
		});
		
		String result = startTime;
		result = result.split(":")[0];
		int HH = Integer.parseInt(result);
		result = startTime;
		result = result.split(":")[1];
		int MM = Integer.parseInt(result);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,HH);
		calendar.set(Calendar.MINUTE, MM);
		
		String result1 = finishTime;
		result1 = result1.split(":")[0];
		int HH1 = Integer.parseInt(result1);
		result1 = finishTime;
		result1 = result1.split(":")[1];
		int MM1 = Integer.parseInt(result1);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.HOUR_OF_DAY,HH1);
		calendar1.set(Calendar.MINUTE, MM1);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.HOUR_OF_DAY,22);
		calendar2.set(Calendar.MINUTE,28);
		

		Date start = calendar.getTime();
		Date finish = calendar1.getTime();

		Date durationFinish = calendar2.getTime();
		flag = false;
		activatSaleCampaignButton.setDisable(true);

		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {@Override
			public void run() {
			// TODO Auto-generated method stub
				MarketingClientController.UpdateCampaignStatus(SaleCampaignStatusType.InProgress,campaignToActivate);
			}
		},start);
		
		
		timer.schedule(new TimerTask() {@Override
		public void run() {
			// TODO Auto-generated method stub
			MarketingClientController.UpdateCampaignStatus(SaleCampaignStatusType.Inactive,campaignToActivate);
		}},finish);
		
		timer.schedule(new MyTimeTaskDuration(),durationFinish);
		
		
		
	}

//	private static class MyTimeTaskOpen extends TimerTask
//	{
//
//		public void run()
//		{
//			//write your code here
//			MarketingClientController.UpdateCampaignStatus(SaleCampaignStatusType.InProgress,campaignToActivate);
//		}
//	}
//
//	private static class MyTimeTaskClose extends TimerTask
//	{
//
//		public void run()
//		{
//			//write your code here
//			MarketingClientController.UpdateCampaignStatus(SaleCampaignStatusType.Inactive,campaignToActivate);
//		}
//	}

	/**
 * The Class MyTimeTaskDuration.
 */
private static class MyTimeTaskDuration extends TimerTask
	{

		/**
		 * Run.
		 */
		public void run()
		{
			//write your code here
			flag = true;
			
		}
		
	}

	/**
	 * Activate campaign failed.
	 *
	 * @param msg the msg
	 */
	public void ActivateCampaignFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Sale Campaigns")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});

	}

	/**
	 * Write line to text file.
	 *
	 * @param message the message
	 */
	private static void writeLineToTextFile(String message) {
		try {
			// Open given file in append mode.
			BufferedWriter out = new BufferedWriter(
					new FileWriter(myFile, true));
			out.write(message);
			out.close();
		}
		catch (IOException e) {
			System.out.println("exception occoured" + e);
		}

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("icon/mark.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Comment Report")
						.text("Comment Report produced successfully")
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});
	}

	/**
	 * Gets the sale purcheses by campagin name succeeded.
	 *
	 * @param obj the obj
	 * @return the sale purcheses by campagin name succeeded
	 */
	public void getSalePurchesesByCampaginNameSucceeded(ArrayList<CustomerSaleCampaignRecord> obj) {
		double totalCustomersExpenses = 0;

		ArrayList<CustomerSaleCampaignRecord> cscrs = new ArrayList<CustomerSaleCampaignRecord>();
		double total;
		Map<String, Double> totalExpensPerCustomer = new HashMap<String, Double>();
		ArrayList<String> ids = new ArrayList<String>();


		for(CustomerSaleCampaignRecord c : obj) {
			ids.add(c.getCustomerID());
		}

		ids = removeDuplicates(ids);
		for(String s: ids) {
			totalExpensPerCustomer.put(s,(double)0);
		}

		for(int i = 0; i < ids.size(); i++) {
			for(CustomerSaleCampaignRecord c : obj) {
				if(c.getCustomerID().equals(ids.get(i))) {
					total = totalExpensPerCustomer.get(ids.get(i));
					total += c.getTotalAmount();
					totalExpensPerCustomer.put(ids.get(i),total);
					total = 0;
				}
			}
		}

		for(String s : ids) {
			CustomerSaleCampaignRecord cscr = new CustomerSaleCampaignRecord(s,totalExpensPerCustomer.get(s));
			cscrs.add(cscr);
		}
		// TODO Auto-generated method stub
		customersExpensesInSale = FXCollections.observableArrayList(cscrs);
		customerExpenseTable.setItems(customersExpensesInSale);
		NumberCustomersField.setText(Integer.toString((ids.size())));//fix to ids.size()

		for(CustomerSaleCampaignRecord c: obj){//fixxxx
			totalCustomersExpenses += c.getTotalAmount();
		}
		SumExpensesField.setText(Double.toString(totalCustomersExpenses));
	}

	/**
	 * Gets the sale purcheses by campagin name failed.
	 *
	 * @param str the str
	 * @return the sale purcheses by campagin name failed
	 */
	public void getSalePurchesesByCampaginNameFailed(String str) {
		// TODO Auto-generated method stub

	}

	/**
	 * Update campaign status succeeded.
	 *
	 * @param obj the obj
	 */
	public void updateCampaignStatusSucceeded(String obj) {
		// TODO Auto-generated method stub
		System.out.println("YYYAAAYYYY");
	}

	/**
	 * Update campaign status failed.
	 *
	 * @param str the str
	 */
	public void updateCampaignStatusFailed(String str) {
		// TODO Auto-generated method stub
		System.out.println("Failllll");
	}
}
