package gui;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import org.controlsfx.control.Notifications;
import com.jfoenix.controls.JFXTimePicker;
import CustomerClient.CustomerClientController;
import UserClient.Logout;
import enums.OrderType;
import enums.Payment;
import entities.*;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
// TODO: Auto-generated Javadoc

/**
 * The Class CustomerController.
 */

public class CustomerController extends MainWindowController implements Initializable {

    /** The ac dash bord. */
    @FXML
    private AnchorPane acDashBord;

    /** The scroll pane. */
    @FXML
    private ScrollPane scrollPane;

    /** The home button. */
    @FXML
    private Button homeButton;

    /** The img home. */
    @FXML
    private ImageView imgHome;

    /** The home fuel button. */
    @FXML
    private Button homeFuelButton;

    /** The img fuel. */
    @FXML
    private ImageView imgFuel;

    /** The settings button. */
    @FXML
    private Button settingsButton;

    /** The img setting. */
    @FXML
    private ImageView imgSetting;

    /** The about button. */
    @FXML
    private Button aboutButton;

    /** The img about. */
    @FXML
    private ImageView imgAbout;

    /** The tracking button. */
    @FXML
    private Button trackingButton;

    /** The img treck. */
    @FXML
    private ImageView imgTreck;

    /** The products button. */
    @FXML
    private Button productsButton;

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

    /** The menu user name. */
    @FXML
    private Label menuUserName;

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

    /** The settings frame. */
    @FXML
    private AnchorPane settingsFrame;

    /** The about frame. */
    @FXML
    private AnchorPane aboutFrame;

    /** The textarea about. */
    @FXML
    private TextArea textareaAbout;

    /** The home frame. */
    @FXML
    private AnchorPane homeFrame;

    /** The welcome label. */
    @FXML
    private Label welcomeLabel;

    /** The Home fuel frame. */
    @FXML
    private AnchorPane HomeFuelFrame;

    /** The time of delivery TF. */
    @FXML
    private JFXTimePicker timeOfDeliveryTF;

    /** The date ofdelivery TF. */
    @FXML
    private DatePicker dateOfdeliveryTF;

    /** The amount TF. */
    @FXML
    private TextField amountTF;

    /** The Order summry. */
    @FXML
    private TextArea OrderSummry;

    /** The proceed to payment button. */
    @FXML
    private Button proceedToPaymentButton;

    /** The employee 1. */
    @FXML
    private ImageView employee1;

    /** The check order button. */
    @FXML
    private Button checkOrderButton;

    /** The employee 11. */
    @FXML
    private ImageView employee11;

    /** The Track order frame. */
    @FXML
    private AnchorPane TrackOrderFrame;

    /** The order number TF. */
    @FXML
    private TextField orderNumberTF;

    /** The order list. */
    @FXML
    private ListView<Long> orderList;

    /** The order details TA. */
    @FXML
    private TextArea orderDetailsTA;

    /** The products frame. */
    @FXML
    private AnchorPane productsFrame;
    
    /** The payment frame. */
    @FXML
    private AnchorPane paymentFrame;

    /** The back to home fuel button. */
    @FXML
    private Button backToHomeFuelButton;
    
    /** The Submit order button. */
    @FXML
    private Button SubmitOrderButton;

    /** The time label. */
    @FXML
    private Label timeLabel;

    /** The date label. */
    @FXML
    private Label dateLabel;

    /** The amount label. */
    @FXML
    private Label amountLabel;

    /** The total label. */
    @FXML
    private Label totalLabel;

    /** The credir card TF. */
    @FXML
    private TextField credirCardTF;

    /** The chash R button. */
    @FXML
    private RadioButton chashRButton;

    /** The group 1. */
    @FXML
    private ToggleGroup group1;
   
    /** The ac content. */
    @FXML
    private StackPane acContent;
    
    /** The credit R button. */
    @FXML
    private RadioButton creditRButton;
    
    /** The order. */
    private Order order;
    
    /** The event. */
    private ActionEvent event;
    
    /** The user. */
    private User user;
    
    /** The customer. */
    private Customer customer;
    
    /** The last order. */
    private long lastOrder;
    
    /** The order nums. */
    private ArrayList<Long> orderNums = new ArrayList<Long>();
    
    /** The total price. */
    private double totalPrice;
    
    /**
     * Load welcome lable.
     *
     * @param user the user
     */
    public void loadWelcomeLable(User user) {
    	this.user = user;
		    	
		welcomeLabel.setText("Welcome To MyFuel " + user.getFirstName()
		    										  + " " + user.getLastName());
		labelUserName.setText(user.getFirstName());
		
		CustomerClientController.setCustomerController(this);
		CustomerClientController.getCustomer(user.getPassword());
		
	}
    

	/** The menu image. */
	Image menuImage = new Image("/icon/menu.png");
	
	/** The menu image red. */
	Image menuImageRed = new Image("/icon/menuRed.png");
	
	/** The campaign view. */
	Image campaignView= new Image("/icon/sell2.png");
	
	/** The campaign red. */
	Image campaignRed = new Image("/icon/sell2Red.png");
	
	/** The dalkan icon view. */
	Image dalkanIconView= new Image("/icon/gas.png");
	
	/** The dalkan icon red. */
	Image dalkanIconRed= new Image("/icon/gasRed.png"); 
	
	/** The anlitic view. */
	Image anliticView= new Image("/icon/clipboard.png");
	
	/** The registration red. */
	Image registrationRed= new Image("/icon/addRed.png");
	
	/** The registration view. */
	Image registrationView= new Image("/icon/adduser.png");
	
	/** The home view. */
	Image homeView = new Image("/icon/home.png");
	
	/** The home red. */
	Image homeRed = new Image("/icon/homeRed.png");
	
	/** The stock. */
	Image stock = new Image("/icon/stock.png");
	
	/** The stock red. */
	Image stockRed = new Image("/icon/stockRed.png");
	
	/** The sell. */
	Image sell = new Image("/icon/sell2.png");
	
	/** The employee. */
	Image employee = new Image("/icon/employe.png");
	
	/** The employee red. */
	Image employeeRed = new Image("/icon/employeRed.png");
	
	/** The setting view. */
	Image settingView = new Image("/icon/settings.png");
	
	/** The setting red. */
	Image settingRed = new Image("/icon/settingsRed.png");
	
	/** The about. */
	Image about = new Image("/icon/about.png");
	
	/** The about red. */
	Image aboutRed = new Image("/icon/aboutRed.png");
	
	/** The submit view. */
	Image submitView= new Image("/icon/v.png");
	
	/** The submit red. */
	Image submitRed= new Image("/icon/vRed.png");
	
	/** The next view. */
	Image nextView= new Image("/icon/arrow.png");
	
	/** The next red. */
	Image nextRed= new Image("/icon/arrowRed.png");
	
	/** The gas. */
	Image gas = new Image("/icon/gas.png");
	
	/** The gas red. */
	Image gasRed = new Image("/icon/gasRed.png");
    
	

	
    /**
     * Handel clicks.
     *
     * @param event the event
     */
    @FXML
    void handelClicks(ActionEvent event) {
    	if(event.getSource() == homeButton) {
    		TitelId.setText("MyFuel");
    		resetHomeFuelFrame();
    		setImages(event);
    		
    	} else if(event.getSource() == trackingButton) {
    		TitelId.setText("Tracking");
    		resetHomeFuelFrame();
    		orderDetailsTA.clear();
    		setImages(event);
    		CustomerClientController.getOrder(user.getPassword());
    	
    	} else if(event.getSource() == checkOrderButton) {
    		CustomerClientController.getLastOrderNumber();
    		orderDetailsTA.clear();
    		String time = null;
    		String date = null;
    		String amount = amountTF.getText().toString();
    		if(timeOfDeliveryTF.getValue() != null){
    			time = timeOfDeliveryTF.getValue().toString();
    		}
    		
    		if(dateOfdeliveryTF.getValue() != null){
    			date = dateOfdeliveryTF.getValue().toString();
    		}
    		
    		try {
    			String msg = checkValidity(time, date, amount);
				if(msg.contains("ok")) { 
					//dialog
					OrderSummry.setText(generateOrder(time,date,amount));
					proceedToPaymentButton.setDisable(false);
				} else {
					Image img = new Image("/icon/error.png");
		    		Notifications notificationsBuilder = Notifications.create()
							.title("Wrong input")
							.text(msg)
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((2)))
							.position(Pos.CENTER);
		    		notificationsBuilder.darkStyle();
					notificationsBuilder.show();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	} else if(event.getSource() == proceedToPaymentButton) {
    		paymentFrame.toFront();
    		TitelId.setText("Payment");
    		setPaymentFrame();
    		//CustomerClientController.getCustomer(user.getPassword());
    		OrderSummry.clear();
    		
    	} else if(event.getSource() == backToHomeFuelButton) {
    		TitelId.setText("Home Fuel");
    		CustomerClientController.getLastOrderNumber();
    		proceedToPaymentButton.setDisable(true);
    		SubmitOrderButton.setDisable(true);
    		HomeFuelFrame.toFront();
    		
    	} else if(event.getSource() == creditRButton) {
    		SubmitOrderButton.setDisable(false);
			order.setPayment(Payment.Credit);
			
			
		}else if(event.getSource() == chashRButton) {
			SubmitOrderButton.setDisable(false);
			order.setPayment(Payment.Cash);
    		
    	} else if(event.getSource() == SubmitOrderButton) {

    		order.setOrderNumber(Order.getOrderCount() + 1);
    		
    		CustomerClientController.setOrder(this.order);

    		
    	} else if(event.getSource() == homeFuelButton) {
    		TitelId.setText("Home Fuel");
    		CustomerClientController.getLastOrderNumber();
    		resetHomeFuelFrame();
    		setImages(event);
    		
    		
    	} else if(event.getSource() == aboutButton) {
    		TitelId.setText("About");
    		resetHomeFuelFrame();
    		setImages(event);
    		
    	} else if(event.getSource() == productsButton) {
    		TitelId.setText("Products/Shope");
    		resetHomeFuelFrame();
    		setImages(event);
    		
    	} else if(event.getSource() == logOutButton) {
    		//logout function.
    		this.event = event;
    		logOutOperation();
    		
    	}    	   	
    }
    
    /**
     * Log out operation.
     */
    protected void logOutOperation() {
    	Logout.setMainWindowController(this);
    	Logout.logoutRequest(user);
    }
    
    /**
     * Handle mouse click.
     *
     * @param event the event
     */
    @FXML
    void handleMouseClick(MouseEvent event) {
    	ArrayList<Order> orders = customer.getListOfOrders();
    	for(Order order: orders) {
    		if(order.getOrderNumber() == orderList.getSelectionModel().getSelectedItem()) {
    			showOrder(order);
    		}
    	}
    }
    
    /**
     * Show order.
     *
     * @param order the order
     */
    private void showOrder(Order order) {
    	StringBuilder sBuilder = new StringBuilder();
 
    	sBuilder.append(order.getDateOfDelivery());
    	sBuilder.append("\n");
		sBuilder.append(order.getTimeOfDelivery());
		sBuilder.append("\n");
		sBuilder.append(order.getAmount());
		sBuilder.append("\n---------------\n");
		sBuilder.append(order.getTotalPrice());
		sBuilder.append("\n");
		sBuilder.append(order.getStatus());
		orderDetailsTA.setText(sBuilder.toString());
    }
    
//    private String isCar() {
//    	if(customerIDTFFueling.getText().toString().trim().length() == 0) {
//    		return "Must fill all fields";
//    	}
//    	
//    	for(Car c: customer.getListOfCars()) {
//    		if(c.getCarID() == customerIDTFFueling.getText().toString()) {
//    			if(c.isNFC()) {
//    				return "ok";
//    			} 
//    			break;
//    		}
//    	}
//    	return "Car doesn't have NFC";
//    }
    
    /**
 * Sets the customer.
 *
 * @param customer the customer
 * @param withCar the with car
 */
public void setCustomer(Customer customer,boolean withCar) {
    	credirCardTF.setText(customer.getCreditCard());
    	this.customer = customer;
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
    					.hideAfter(Duration.seconds((5)))
    					.position(Pos.CENTER);
    			notificationsBuilder.darkStyle();
    			notificationsBuilder.show();
    		}
    	});
    }

    /**
     * Order submite success.
     *
     * @param msg the msg
     */
    public void orderSubmiteSuccess(String msg) {
    	Platform.runLater(new Runnable() {

    		@Override
    		public void run() {
    			Image img = new Image("/icon/mark.png");
    			Notifications notificationsBuilder = Notifications.create()
    					.title("Order")
    					.text(msg)
    					.graphic(new ImageView(img))
    					.hideAfter(Duration.seconds((2)))
    					.position(Pos.CENTER);
    			notificationsBuilder.darkStyle();
    			notificationsBuilder.show();
    			HomeFuelFrame.toFront();
    		}
    	});
    	CustomerClientController.getLastOrderNumber();
		proceedToPaymentButton.setDisable(true);
		SubmitOrderButton.setDisable(true);
		
    }
    
    /**
     * Order submite failed.
     *
     * @param msg the msg
     */
    public void orderSubmiteFailed(String msg) {
    	Platform.runLater(new Runnable() {

    		@Override
    		public void run() {
    			Image img = new Image("/icon/error.png");
    			Notifications notificationsBuilder = Notifications.create()
    					.title("Order")
    					.text(msg)
    					.graphic(new ImageView(img))
    					.hideAfter(Duration.seconds((2)))
    					.position(Pos.CENTER);
    			notificationsBuilder.darkStyle();
    			notificationsBuilder.show();
    		}
    	});
    }
    
    /**
     * Gets the order succeed.
     *
     * @param orders the orders
     * @return the order succeed
     */
    public void getOrderSucceed(ArrayList<Order> orders) {

    	ObservableList<Long> listOforderNums ;
    	ArrayList<Long> orderNumbers = new ArrayList<Long>();

    	for(Order o: orders) {
    		orderNumbers.add(o.getOrderNumber());
    	}

    	listOforderNums = FXCollections.observableArrayList(orderNumbers);

    	orderList.setItems(listOforderNums);
    	System.out.println("bben to getOrderSucceed");
    	this.customer.setListOfOrders(orders);

//    	setOrderNums();
//    	TextFields.bindAutoCompletion(orderNumberTF,orderNums);
    	System.out.println("bben to getOrderSucceed");
    }

    /**
     * Gets the order failed.
     *
     * @param msg the msg
     * @return the order failed
     */
    public void getOrderFailed(String msg) {
//    	Platform.runLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				Image img = new Image("icon/error.png");
//    			Notifications notificationsBuilder = Notifications.create()
//    					.title("Order")
//    					.text(msg)
//    					.graphic(new ImageView(img))
//    					.hideAfter(Duration.seconds((2)))
//    					.position(Pos.CENTER);
//    			notificationsBuilder.darkStyle();
//    			notificationsBuilder.show();
//			}
//		});
    }
    
    /**
     * Gets the last order number.
     *
     * @param msg the msg
     * @return the last order number
     */
    public void getLastOrderNumber(long msg) {
    	Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Order.setOrderCount(msg);
				System.out.println("print if you been to getLastOrder");
			}
		});
    	
    }

    /**
     * Gets the last order number failed.
     *
     * @param msg the msg
     * @return the last order number failed
     */
    public void getLastOrderNumberFailed(String msg) {

    	if(msg == "1") {
    		Order.setOrderCount(0);
    	} else {

//    		Platform.runLater(new Runnable() {
//
//    			@Override
//    			public void run() {
//    				// TODO Auto-generated method stub
//    				Image img = new Image("icon/error.png");
//    				Notifications notificationsBuilder = Notifications.create()
//    						.title("Order")
//    						.text(msg)
//    						.graphic(new ImageView(img))
//    						.hideAfter(Duration.seconds((2)))
//    						.position(Pos.CENTER);
//    				notificationsBuilder.darkStyle();
//    				notificationsBuilder.show();
//    			}
//    		});
    	}
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
	 * Initialize.
	 *
	 * @param location the location
	 * @param resources the resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		proceedToPaymentButton.setDisable(true);
		homeFrame.toFront();
		TitelId.setText("MyFuel");
		SubmitOrderButton.setDisable(true);
		CustomerClientController.setCustomerController(this);
	}
	
	/**
	 * Sets the payment frame.
	 */
	private void setPaymentFrame() {
		timeLabel.setText(timeOfDeliveryTF.getValue().toString());
		dateLabel.setText(dateOfdeliveryTF.getValue().toString());
		amountLabel.setText(amountTF.getText().toString());
		totalLabel.setText(Double.toString(totalPrice));
	}
	
	/**
	 * Check validity.
	 *
	 * @param time the time
	 * @param date the date
	 * @param amount the amount
	 * @return the string
	 * @throws ParseException the parse exception
	 */
	private String checkValidity(String time, String date,String amount) throws ParseException {
		String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		String dateStampString = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm");
		
		if(time == null || amount == null || date == null)
			return "Must enter All parmeters";
		
		Date d1,d2,t1,t2;
		d1 = simpleDateFormat.parse(date);
		d2 = simpleDateFormat.parse(dateStampString);
		t1 = simpleTimeFormat.parse(time);
		t2 = simpleTimeFormat.parse(timeStamp);
	

		if(!isInteger(amount) || Integer.parseInt(amount) <=0) {
			return "Amount not valid";
		}
		
		if(d1.compareTo(d2) == 0) {
			if(t1.compareTo(t2) < 0)
				return "Invalid time";
		}
		
		if(d1.compareTo(d2) < 0) {
			return "Invalid date";
		}
		
		return "ok";
	}

	
	/**
	 * Checks if is integer.
	 *
	 * @param s the s
	 * @return true, if is integer
	 */
	private static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	/**
	 * Reset home fuel frame.
	 */
	private void resetHomeFuelFrame() {
		timeOfDeliveryTF.setValue(null);
		dateOfdeliveryTF.setValue(null);
		amountTF.setText("");
		OrderSummry.clear();
	}
	
//	private void setOrderNums() {
//		orderNums.clear();
//		ArrayList<Order> ordersTmp = customer.getListOfOrders();
//		for(Order o: ordersTmp) {
//			orderNums.add(o.getOrderNumber());
//		}
//	}
	
	/**
 * Generate order.
 *
 * @param time the time
 * @param date the date
 * @param amount the amount
 * @return the string
 * @throws ParseException the parse exception
 */
private String generateOrder(String time, String date,String amount) throws ParseException {
		String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		String dateStampString = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm");
		Date d1,d2,t1,t2;
		int amounttmp = Integer.parseInt(amount);
		long thisTime;
		
		d1 = simpleDateFormat.parse(date);
		d2 = simpleDateFormat.parse(dateStampString);
		t1 = simpleTimeFormat.parse(time);
		t2 = simpleTimeFormat.parse(timeStamp);
		
		String tmpString = "";
		StringBuilder sBuilder = new StringBuilder();
		thisTime = t1.getTime() - t2.getTime();
		int state = 0;
		double fixedFuelPrice = Float.parseFloat(Fuel.getFixedPrice());
		double sumOfdiscount = 0;
		double totalPrice = 0;
		
		if(d1.compareTo(d2) == 0 && thisTime <= 6) {
			sumOfdiscount -= 0.2;
			if(amounttmp >= 600 && amounttmp < 800) {
				state = 1;
				tmpString = "Urgent delivery & medium amount purchase: 1% discount";
				sumOfdiscount += 0.3;
			}
			if(amounttmp >= 800) {
				state = 1;
				tmpString = "Urgent delivery & large amount purchase: 2% discount";
				sumOfdiscount += 0.4;
			}
			
			switch (state) {
			case 0:
				sBuilder.append("Urgent delivery: 2% addition");
				sBuilder.append("\n");
				break;
			case 1:
				sBuilder.append(tmpString);
				sBuilder.append("\n");
				break;
			}
		}
		state = 0;
		
		if(amounttmp >= 600 && amounttmp < 800) {
			state = 1;
			tmpString = "medium amount purchase: 3% discount";
			sumOfdiscount += 0.3;
		}
		if(amounttmp >= 800) {
			state = 1;
			tmpString = "large amount purchase: 4% discount";
			sumOfdiscount += 0.4;
		}
		
		switch (state) {
		case 0:
			sBuilder.append("regular amount purchase: regular price");
			sBuilder.append("\n");
			break;
		case 1:
			sBuilder.append(tmpString);
			sBuilder.append("\n");
			break;
		}
		
		if(sumOfdiscount < 0) {
			totalPrice = Math.abs(fixedFuelPrice * sumOfdiscount * amounttmp ) + fixedFuelPrice * amounttmp;
		}
		totalPrice = fixedFuelPrice *amounttmp - fixedFuelPrice * sumOfdiscount * amounttmp ;
		
		this.totalPrice = totalPrice;
		
		sBuilder.append("Time choosen: " + time);
		sBuilder.append("\n");
		sBuilder.append("Date choosen: " + date);
		sBuilder.append("\n");
		sBuilder.append("Amount choosen: " + amount);
		sBuilder.append("\n\n-----------------\n");
		sBuilder.append("Total Price of Purchase: " + totalPrice);
		sBuilder.append("\n\n");
		long count = Order.getOrderCount() + 1;
		sBuilder.append(count);//need to fix here (get last order number from DB)// get order number (DBorderNumber + 1)
		
		this.order = new Order(time, date, amount,"Accepted", OrderType.HomeFule, user.getPassword(),totalPrice);
		return sBuilder.toString();
	}
	

	/**
	 * Logout succeeded.
	 */
	public void logoutSucceeded() {
		// TODO Auto-generated method stub
		System.out.println("been in logoutSucceeded");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("been in logoutSucceeded try");
					Stage primaryStage = new Stage();//wrap around of a new window.
					//set the permission on DB when register	
					
					AnchorPane pane = (AnchorPane)loader.load();
					MainWindowController Controller = (MainWindowController)loader.getController();
					Scene scene = new Scene(pane);
					scene.getStylesheets().add(getClass().getResource("/MyFuelCss/Application.css").toExternalForm());// look up
					primaryStage = (Stage) menuButton.getScene().getWindow();// maybe we will use this, i don't know, so i save it for this time.
					primaryStage.setScene(scene);
					primaryStage.show();

					//((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("been in logoutSucceeded exception");
				}
			}
		});
	}


	/**
	 * Logout failed.
	 */
	public void logoutFailed() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Logout")
						.text("Logout failed")
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((4)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		});
	}
		
	/**
	 * Sets the images.
	 *
	 * @param event the new images
	 */
	private void setImages(ActionEvent event) {
		if(event.getSource() == homeButton) {
			homeFrame.toFront();
			imgHome.setImage(homeRed);
			imgTreck.setImage(stock);
			imgFuel.setImage(gas);
			//imgProducts.setImage();
			imgAbout.setImage(about);
			
		} else if(event.getSource() == homeFuelButton) {
    		HomeFuelFrame.toFront();
			imgHome.setImage(homeView);
			imgTreck.setImage(stock);
			imgFuel.setImage(gasRed);
			//imgProducts.setImage();
			imgAbout.setImage(about);
    		
    		
    	} else if(event.getSource() == aboutButton) {
    		aboutFrame.toFront();
			imgHome.setImage(homeView);
			imgTreck.setImage(stock);
			imgFuel.setImage(gas);
			//imgProducts.setImage();
			imgAbout.setImage(aboutRed);
//    		
//    	} else if(event.getSource() == productsButton) {
//    		productsFrame.toFront();
//			imgHome.setImage(homeView);
//			imgTreck.setImage(stock);
//			imgFuel.setImage(gas);
//			//imgProducts.setImage();
//			imgAbout.setImage(about);
    		
    	} else if(event.getSource() == trackingButton) {
        	TrackOrderFrame.toFront();
			imgHome.setImage(homeView);
			imgTreck.setImage(stockRed);
			imgFuel.setImage(gas);
			//imgProducts.setImage();
			
			imgAbout.setImage(about);
    	}
	}
}