package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.text.DefaultStyledDocument;

import org.controlsfx.control.Notifications;

import CustomerClient.CustomerClientController;
import entities.CampaignPurchases;
import entities.CampaignTemplate;
import entities.Car;
import entities.Customer;
import entities.Order;
import entities.Purchase;
import entities.Rates;
import fueling.FuelingClientController;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

// TODO: Auto-generated Javadoc
/**
 * The Class FulingController.
 */
public class FulingController extends CustomerController{


    /** The back to main button. */
    @FXML
    private Button backToMainButton;
	
	/** The ac dash bord. */
	@FXML
	private AnchorPane acDashBord;

	/** The scroll pane. */
	@FXML
	private ScrollPane scrollPane;

	/** The about button. */
	@FXML
	private Button aboutButton;

	/** The img about. */
	@FXML
	private ImageView imgAbout;

	/** The fueling button. */
	@FXML
	private Button fuelingButton;

	/** The img products. */
	@FXML
	private ImageView imgProducts;

	/** The app content. */
	@FXML
	private BorderPane appContent;

	/** The ac head. */
	@FXML
	private AnchorPane acHead;

	/** The menu button. */
	@FXML
	private MenuButton menuButton;

	/** The menu role. */
	@FXML
	private Label menuRole;

	/** The log out button. */
	@FXML
	private Button logOutButton;

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

	/** The Fuling frame. */
	@FXML
	private AnchorPane FulingFrame;

	/** The customer IDTF fueling. */
	@FXML
	private TextField customerIDTFFueling;

	/** The Button next fuleing. */
	@FXML
	private Button ButtonNextFuleing;

	/** The img next 1. */
	@FXML
	private ImageView imgNext1;

	/** The Fuling frame 2. */
	@FXML
	private AnchorPane FulingFrame2;

	/** The Button 95. */
	@FXML
	private Button Button95;

	/** The Button 98. */
	@FXML
	private Button Button98;

	/** The Button soler. */
	@FXML
	private Button ButtonSoler;

	/** The Fuling frame 4. */
	@FXML
	private AnchorPane FulingFrame4;

	/** The summery TA. */
	@FXML
	private TextArea summeryTA;

	/** The cash R button. */
	@FXML
	private RadioButton cashRButton;

	/** The group 2. */
	@FXML
	private ToggleGroup group2;

	/** The end simulation button. */
	@FXML
	private Button endSimulationButton;

	/** The img treck 1. */
	@FXML
	private ImageView imgTreck1;

	/** The Fuling frame 3. */
	@FXML
	private AnchorPane FulingFrame3;

	/** The amount for fuel TF. */
	@FXML
	private TextField amountForFuelTF;

	/** The next for pay button. */
	@FXML
	private Button nextForPayButton;

	/** The img next 11. */
	@FXML
	private ImageView imgNext11;

	/** The customer. */
	private Customer customer;
	
	/** The number of cars. */
	private int numberOfCars;

	/** The rates. */
	private ArrayList<Rates> rates = new ArrayList<Rates>();

	/** The fuel prices. */
	private ArrayList<Double> fuelPrices = new ArrayList<Double>();

	/** The campaign. */
	private CampaignTemplate campaign;
	
	/** The fuel type. */
	private String fuelType = "";
	
	/** The product ID. */
	private String productID = "";
	
	/** The amount. */
	private double amount;
	
	/** The car ID. */
	private String carID = "";
	
	/** The current amount. */
	private double currentAmount;
	
	/** The station ID. */
	private String stationID = "1234";
	
	/** The Price to pay. */
	private double PriceToPay;

	/** The time. */
	private Date time = Calendar.getInstance().getTime();  
	
	/** The date. */
	private Date date = Calendar.getInstance().getTime();  
	
	/** The flag campain. */
	private boolean flagPurchases,flagCampain;

	/**
	 * Handel clicks.
	 *
	 * @param event the event
	 */
	@FXML
	void handelClicks(ActionEvent event) {

		if(event.getSource() == fuelingButton) {
			FulingFrame.toFront();

		} else if(event.getSource() == ButtonNextFuleing) {
			String msg = "";
			if(customerIDTFFueling.getText().toString().trim().length() == 0) {
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Car ID")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
				customerIDTFFueling.clear();
			} else {
				carID = customerIDTFFueling.getText().toString();
				FuelingClientController.getCustomer(customerIDTFFueling.getText().toString());
			}

		} else if(event.getSource() == Button95) {
			FuelingClientController.getCurrentAmount(stationID,"1");
			fuelType = "95";
			productID = "1";
			FulingFrame3.toFront();	

		} else if(event.getSource() == Button98) {
			FuelingClientController.getCurrentAmount(stationID,"2");
			fuelType = "98";
			productID = "2";
			FulingFrame3.toFront();	

		} else if(event.getSource() == ButtonSoler) {
			FuelingClientController.getCurrentAmount(stationID,"3");
			fuelType = "soler";
			productID = "3";
			FulingFrame3.toFront();	

		} else if(event.getSource() == nextForPayButton) {
			amount = getAmount(amountForFuelTF.getText().toString());
			if(amount == 0 || amount > currentAmount) {
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Amount")
						.text("Invalid Amount")
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
				amountForFuelTF.clear();
			} else {
				
				calculatePricePerLiter();
				FulingFrame4.toFront();	
				try {
					showOrder();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					Image img = new Image("/icon/error.png");
					Notifications notificationsBuilder = Notifications.create()
							.title("Amount")
							.text("System Time/Date error")
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((2)))
							.position(Pos.CENTER);
					notificationsBuilder.darkStyle();
					notificationsBuilder.show();
					amountForFuelTF.clear();
				}
			}
			
		} else if (event.getSource() == endSimulationButton) {
			//enter to purchases
			 int quorter = 0;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm");
			String timeStamp = simpleTimeFormat.format(time);
			String dateStamp = simpleDateFormat.format(date);
			Date date1 = null;
			Date date2 = null;
			Date date3 = null;
			Date date4 = null;
			Date date5 = null;

			try {
				 date1 = simpleDateFormat.parse("01.01.2020");
				 date2 =  simpleDateFormat.parse("01.04.2020");
				 date3 =  simpleDateFormat.parse("01.07.2020");
				 date4 =  simpleDateFormat.parse("01.10.2020");
				 date5 =  simpleDateFormat.parse("01.01.2021");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			if(isBetween(date1,date2)) {
				quorter = 1;
			} else if(isBetween(date2,date3)) {
				quorter = 2;
			} else if(isBetween(date3,date4)) {
				quorter = 3;
			} else if(isBetween(date4,date5)) {
				quorter = 4;
			}
			
			Purchase purchase = new Purchase(timeStamp, dateStamp, amount, quorter, productID, customer.getPassword(), PriceToPay, stationID);
			//insert into purchases
			if(campaign != null) {
				//enter to campaign
				CampaignPurchases campaignP = new CampaignPurchases(campaign.getCampaignID(), campaign.getCampaignName(), customer.getPassword(), PriceToPay);
				FuelingClientController.updateCampainPurchases(campaignP);
				//insert into salecampaignpurchases	
			}
			
			FuelingClientController.updatePurchases(purchase);

			FuelingClientController.updateStock(amount,productID,stationID);

		}
	}
	
	/**
	 * Checks if is between.
	 *
	 * @param d the d
	 * @param d1 the d 1
	 * @return true, if is between
	 */
	private boolean isBetween(Date d, Date d1) {
		return date.after(d)&&date.before(d1);
	}
	
	/**
	 * Show order.
	 *
	 * @throws ParseException the parse exception
	 */
	private void showOrder() throws ParseException {
    	StringBuilder sBuilder = new StringBuilder();
    	String timeStamp = new SimpleDateFormat("[HH:mm:ss]").format(Calendar.getInstance().getTime());
    	String dateStamp = new SimpleDateFormat("[dd.MMM.yyyy]").format(Calendar.getInstance().getTime());
    	
    	String strDouble = String.format("%.2f", PriceToPay); 
    	
    	sBuilder.append("Purchase Program: " + customer.getPurchaseProgram());
    	sBuilder.append("\n\n");
    	if(campaign != null) {
    		sBuilder.append("Campign: " + campaign.getCampaignName());
			sBuilder.append("\n\n");
    	}
		sBuilder.append("FuelType: " + fuelType);
		sBuilder.append("\n---------------\n");
		sBuilder.append("Total: " + strDouble);
		sBuilder.append("\n\n\n");
		sBuilder.append(timeStamp + " " + dateStamp);//date and time
		summeryTA.setText(sBuilder.toString());
    }
	
	/**
	 * Gets the amount.
	 *
	 * @param str the str
	 * @return the amount
	 */
	private static double getAmount(String str) { 
		//check in stock
		double number;
		try {  
			number = Double.parseDouble(str);  
			if(number <= 0) {
				return 0;
			}
			return Double.parseDouble(str);  
		} catch(NumberFormatException e){  
			return 0;  
		}  
	}
	
	/**
	 * Initialize.
	 *
	 * @param location the location
	 * @param resources the resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FulingFrame.toFront();
		FuelingClientController.setFulingController(this);
		FuelingClientController.getRates();
		FuelingClientController.getFuelPrices();
		FuelingClientController.GetActivatedSaleCampaigns();
	}

	/**
	 * Side menu toogle btn on C lick.
	 *
	 * @param event the event
	 */
	@FXML
	void sideMenuToogleBtnOnCLick(ActionEvent event) {
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
	 * Checks if is car.
	 *
	 * @param customer the customer
	 * @return the string
	 */
	private String isCar(Customer customer) {
		ArrayList<Car> cars = customer.getListOfCars();
		for(Car c: cars) {
			if(c.getCarID().equals(carID)) {
				if(c.isNFC()) {
					return "ok";
				} 
				break;
			}
		}
		return "Car doesn't have NFC";
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
		numberOfCars = customer.getListOfCars().size();
		System.out.println(customer.getListOfCars().get(0).toString());
		String msg = isCar(customer);
		if(!msg.contains("ok")) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					Image img = new Image("/icon/error.png");
					Notifications notificationsBuilder = Notifications.create()
							.title("Customer")
							.text(msg)
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((3)))
							.position(Pos.CENTER);
					notificationsBuilder.darkStyle();
					notificationsBuilder.show();
				}
			});
			customerIDTFFueling.clear();

		} else {
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					FulingFrame2.toFront();
				}
			});
			
		}

	}

	/**
	 * Gets the customer failed.
	 *
	 * @param str the str
	 * @return the customer failed
	 */
	public void getCustomerFailed(String str) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Customer")
						.text(str)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((3)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});
		customerIDTFFueling.clear();
	}

	/**
	 * Gets the rates succeed.
	 *
	 * @param msg the msg
	 * @return the rates succeed
	 */
	public void getRatesSucceed(ArrayList<Rates> msg) {

		this.rates = msg;
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
	 * Gets the fuel prices succeed.
	 *
	 * @param msg the msg
	 * @return the fuel prices succeed
	 */
	public void getFuelPricesSucceed(ArrayList<Double> msg) {

		this.fuelPrices = msg;
	}

	/**
	 * Gets the fuel prices failed.
	 *
	 * @param msg the msg
	 * @return the fuel prices failed
	 */
	public void getFuelPricesFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Fuel")
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
	 * Gets the sale campaign succeeded.
	 *
	 * @param campaign the campaign
	 * @return the sale campaign succeeded
	 */
	public void getSaleCampaignSucceeded(CampaignTemplate campaign) {
		this.campaign = campaign;
	}
	
	/**
	 * Calculate price per liter.
	 */
	private void calculatePricePerLiter() {
		double ratesDiscount = 0;
		switch (customer.getPurchaseProgram()) {
		case "Intermediate":
			switch (fuelType) {
			case "95":
				ratesDiscount = getDiscountFromRates("Intermediate");
				PriceToPay = fuelPrices.get(0) - fuelPrices.get(0) * ratesDiscount;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				break;
			case "98":
				ratesDiscount = getDiscountFromRates("Intermediate");
				PriceToPay = fuelPrices.get(1) - fuelPrices.get(1) * ratesDiscount;//perliter
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				break;
			case "soler":
				ratesDiscount = getDiscountFromRates("Intermediate");
				PriceToPay = fuelPrices.get(2) - fuelPrices.get(2) * ratesDiscount;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				break;
			}
			break;
		case "Regular":
			switch (fuelType) {
			case "95":
				ratesDiscount = getDiscountFromRates("Regular");
				PriceToPay = fuelPrices.get(0) - fuelPrices.get(0) * ratesDiscount;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				break;
			case "98":
				ratesDiscount = getDiscountFromRates("Regular");
				PriceToPay = fuelPrices.get(1) - fuelPrices.get(1) * ratesDiscount;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				break;
			case "soler":
				ratesDiscount = getDiscountFromRates("Regular");
				PriceToPay = fuelPrices.get(2) - fuelPrices.get(2) * ratesDiscount;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				break;
			}
			break;
		case "Plurality of Cars":
			switch (fuelType) {
			case "95":
				
				ratesDiscount = getDiscountFromRates("Plurality of Cars");
				PriceToPay = fuelPrices.get(0) - fuelPrices.get(0) * ratesDiscount * numberOfCars ;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				PriceToPay =  PriceToPay - PriceToPay * 0.1;
				break;
			case "98":
				ratesDiscount = getDiscountFromRates("Plurality of Cars");
				PriceToPay = fuelPrices.get(1) - fuelPrices.get(1) * ratesDiscount * numberOfCars ;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				PriceToPay =  PriceToPay - PriceToPay * 0.1;
				break;
			case "soler":
				ratesDiscount = getDiscountFromRates("Plurality of Cars");
				PriceToPay = fuelPrices.get(2) - fuelPrices.get(2) * ratesDiscount * numberOfCars ;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				PriceToPay =  PriceToPay - PriceToPay * 0.1;
				break;
			}
			break;
		case "Full":
			switch (fuelType) {
			case "95":
				ratesDiscount = getDiscountFromRates("Full");
				PriceToPay = fuelPrices.get(0) - fuelPrices.get(0) * ratesDiscount * numberOfCars ;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				PriceToPay =  PriceToPay - PriceToPay * 0.1;
				PriceToPay =  PriceToPay - PriceToPay * 0.03;
				break;
			case "98":
				ratesDiscount = getDiscountFromRates("Full");
				PriceToPay = fuelPrices.get(1) - fuelPrices.get(1) * ratesDiscount * numberOfCars ;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				PriceToPay =  PriceToPay - PriceToPay * 0.1;
				PriceToPay =  PriceToPay - PriceToPay * 0.03;
				break;
			case "soler":
				ratesDiscount = getDiscountFromRates("Full");
				PriceToPay = fuelPrices.get(2) - fuelPrices.get(2) * ratesDiscount * numberOfCars ;
				PriceToPay *= amount;
				if(campaign != null) {
					PriceToPay = PriceToPay - PriceToPay * campaign.getDiscount();
				}
				PriceToPay =  PriceToPay - PriceToPay * 0.1;
				PriceToPay =  PriceToPay - PriceToPay * 0.03;
				break;
			}
			break;
		}
	}

	/**
	 * Gets the discount from rates.
	 *
	 * @param msg the msg
	 * @return the discount from rates
	 */
	private double getDiscountFromRates(String msg) {
		msg = msg.replaceAll("\\s", "");
		
		for(Rates r: rates) {
			if(r.getSubscriptionType().name().toLowerCase().equals(msg.toLowerCase())) {
				return r.getDiscount();
			}
		}
		return 0;
	}
	
	/**
	 * Gets the sale campaign failed.
	 *
	 * @param msg the msg
	 * @return the sale campaign failed
	 */
	public void getSaleCampaignFailed(String msg) {
		// TODO Auto-generated method stub
		this.campaign = null;
		flagCampain = true;
	}

	/**
	 * Gets the current amount succeeded.
	 *
	 * @param current the current
	 * @return the current amount succeeded
	 */
	public void getCurrentAmountSucceeded(Double current) {
		// TODO Auto-generated method stub
		this.currentAmount = current;
	}

	/**
	 * Gets the current amount failed.
	 *
	 * @param msg the msg
	 * @return the current amount failed
	 */
	public void getCurrentAmountFailed(String msg) {
		// TODO Auto-generated method stub
		currentAmount = -1;
	}

	/**
	 * Update campain purchases success.
	 *
	 * @param obj the obj
	 */
	public void updateCampainPurchasesSuccess(String obj) {
		// TODO Auto-generated method stub
		flagCampain = true;
		
	}

	/**
	 * Update campain purchases failed.
	 *
	 * @param obj the obj
	 */
	public void updateCampainPurchasesFailed(String obj) {
		// TODO Auto-generated method stub
		//flag ? 
	}

	/**
	 * Update purchases success.
	 *
	 * @param obj the obj
	 */
	public void updatePurchasesSuccess(String obj) {
		// TODO Auto-generated method stub
		flagPurchases = true;
	}

	/**
	 * Update purchases failed.
	 *
	 * @param obj the obj
	 */
	public void updatePurchasesFailed(String obj) {
		// TODO Auto-generated method stub
		//flag ? 
	}

	/**
	 * Update stock success.
	 *
	 * @param obj the obj
	 */
	public void updateStockSuccess(String obj) {
		// TODO Auto-generated method stub
		
		System.out.println("been in updateStockSuccess");
		if(campaign != null) {
			if(flagPurchases) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {

						Image img = new Image("/icon/mark.png");
						Notifications notificationsBuilder = Notifications.create()
								.title("Simulation")
								.text("Simulation Succeeded")
								.graphic(new ImageView(img))
								.hideAfter(Duration.seconds((3)))
								.position(Pos.CENTER);
						notificationsBuilder.darkStyle();
						notificationsBuilder.show();
						FulingFrame.toFront();
						System.out.println("been in updateStockSuccess in platform");
					}
				});
				flagPurchases = false;
				flagCampain = false;
				customerIDTFFueling.clear();
			}
		} else if(flagCampain && flagPurchases) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {

					Image img = new Image("/icon/mark.png");
					Notifications notificationsBuilder = Notifications.create()
							.title("Simulation")
							.text("Simulation Succeeded")
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((3)))
							.position(Pos.CENTER);
					notificationsBuilder.darkStyle();
					notificationsBuilder.show();
					FulingFrame.toFront();
				}
			});
			flagPurchases = false;
			flagCampain = false;
			customerIDTFFueling.clear();

		} else {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {

					Image img = new Image("/icon/error.png");
					Notifications notificationsBuilder = Notifications.create()
							.title("Simulation")
							.text("Simulation Faild")
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((3)))
							.position(Pos.CENTER);
					notificationsBuilder.darkStyle();
					notificationsBuilder.show();
				}
			});
		}

	}

	/**
	 * Update stock failed.
	 *
	 * @param obj the obj
	 */
	public void updateStockFailed(String obj) {
		// TODO Auto-generated method stub
		
	}


}
