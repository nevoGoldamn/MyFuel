package gui;


import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import UserClient.Logout;
import entities.Order;
import entities.Product;
import entities.Rates;
import entities.StationManager;
import entities.SupplyOrder;
import entities.Threshold;
import entities.User;
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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import stationClient.StationManagerClient;

// TODO: Auto-generated Javadoc
/**
 * The Class StationManagerController.
 */
//may extend the mainWindow controller
public class StationManagerController extends CustomerController {

    /** The Order details TA. */
    @FXML
    private TextArea OrderDetailsTA;
	
    /** The ac dash bord. */
    @FXML
    private AnchorPane acDashBord;

    /** The scroll pane. */
    @FXML
    private ScrollPane scrollPane;

    /** The home button. */
    @FXML
    private Button homeButton;

    /** The home. */
    @FXML
    private ImageView home;

    /** The Supply order button. */
    @FXML
    private Button SupplyOrderButton;

    /** The employee. */
    @FXML
    private ImageView employee;

    /** The settings button. */
    @FXML
    private Button settingsButton;

    /** The setting. */
    @FXML
    private ImageView setting;

    /** The about button. */
    @FXML
    private Button aboutButton;

    /** The about. */
    @FXML
    private ImageView about;

    /** The Set threshold button. */
    @FXML
    private Button SetThresholdButton;

    /** The sell. */
    @FXML
    private ImageView sell;

    /** The review rates button 1. */
    @FXML
    private Button reviewRatesButton1;

    /** The sell 1. */
    @FXML
    private ImageView sell1;

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

    /** The Title ID. */
    @FXML
    private Label TitleID;

    /** The settings frame. */
    @FXML
    private AnchorPane settingsFrame;

    /** The home frame. */
    @FXML
    private AnchorPane homeFrame;

    /** The about frame. */
    @FXML
    private AnchorPane aboutFrame;

    /** The textarea about. */
    @FXML
    private TextArea textareaAbout;

    /** The set threshold frame. */
    @FXML
    private AnchorPane setThresholdFrame;

    /** The employe text area 1. */
    @FXML
    private TextArea employeTextArea1;

    /** The employe text area 11. */
    @FXML
    private TextArea employeTextArea11;

    /** The supply order frame. */
    @FXML
    private AnchorPane supplyOrderFrame;

    /** The employe text area. */
    @FXML
    private TextArea employeTextArea;

    /** The Submit order button. */
    @FXML
    private Button SubmitOrderButton;

    /** The approve sign. */
    @FXML
    private ImageView approveSign;

    /** The Cancel order button. */
    @FXML
    private Button CancelOrderButton;
    
    /** The save thresholds button. */
    @FXML
    private Button saveThresholdsButton;

    /** The cancel sign. */
    @FXML
    private ImageView cancelSign;

    /** The Total order cost label. */
    @FXML
    private Label TotalOrderCostLabel;

    /** The welcome label. */
    @FXML
    private Label welcomeLabel;

    /** The Order list view. */
    @FXML
    private ListView<String> OrderListView;

    /** The Threshold table view. */
    @FXML
    private TableView<Threshold> ThresholdTableView;	// check

    /** The Prod ID thresh column. */
    @FXML
    private TableColumn<Threshold, String> ProdIDThreshColumn;
    
    /** The prod name column. */
    @FXML
    private TableColumn<Threshold, String> prodNameColumn;

    /** The Threshold column. */
    @FXML
    private TableColumn<Threshold, Double> ThresholdColumn;

    /** The user. */
    private User user;
    
    /** The selected index. */
    private int selectedIndex = -1;
    
    /** The Global order. */
    private SupplyOrder GlobalOrder;
    
    /** The list oforder product ID. */
    ObservableList<String> listOforderProductID ;
   
    /** The orders. */
    private ArrayList<SupplyOrder> orders;

//    private long currentOrderInList;

    /** The thresholds. */
private ArrayList<Threshold> thresholds = new ArrayList<Threshold>();

    /**
     * Load welcome lable.
     *
     * @param user the user
     */
    @Override
	public void loadWelcomeLable(User user) {
		// TODO Auto-generated method stub
    	this.user = user;

		welcomeLabel.setText("Welcome To MyFuel " + user.getFirstName()
		    										  + " " + user.getLastName());
		labelUserName.setText(user.getFirstName());

		StationManagerClient.setManagerController(this);
		StationManagerClient.getSupplyOrders(user.getPassword());
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
	 * Handle mouse click.
	 *
	 * @param event the event
	 */
	@FXML
    void handleMouseClick(MouseEvent event) {
    	SubmitOrderButton.setDisable(false);
    	selectedIndex = OrderListView.getSelectionModel().getSelectedIndex();
    	for(SupplyOrder order: orders) {
    		if(order.getProduct().getProductID() == OrderListView.getSelectionModel().getSelectedItem()) {
    			GlobalOrder = order;
    			showOrder(order);
    		}
    	}
    }
//
//    private void showOrder(SupplyOrder order) {
//    	ObservableList<Product> listOfProfucts = FXCollections.observableArrayList();
//    	ArrayList<Product> products = order.getProducts();
//
//    	for(Product p: products) {
//    		listOfProfucts.add(p);
//    	}
//    	tableViewOrderDetails.setItems(listOfProfucts);
//    }

    /**
 * Initialize.
 *
 * @param location the location
 * @param resources the resources
 */
@Override
	public void initialize(URL location, ResourceBundle resources) {
    	homeFrame.toFront();
    	TitleID.setText("MyFuel");
    	SubmitOrderButton.setDisable(true);
    	OrderListView.setEditable(true);
    	ThresholdTableView.setEditable(true);
    	ThresholdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    	ProdIDThreshColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
    	ThresholdColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
    	prodNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
    	StationManagerClient.setManagerController(this);
	}

    /**
     * Sets the threshold.
     *
     * @param editEvent the edit event
     */
    @FXML
    void SetThreshold(CellEditEvent<Threshold, Double> editEvent) {
    	Threshold thresholdSelected = ThresholdTableView.getSelectionModel().getSelectedItem();
    	thresholdSelected.setLevel(editEvent.getNewValue().doubleValue());
    	thresholdSelected.setStationManagerID(this.user.getPassword());
    	
    	switch (thresholdSelected.getProductID()) {
		case "1":
			thresholds.set(0, thresholdSelected);
			break;
		case "2":
			thresholds.set(1, thresholdSelected);
			break;
		case "3":
			thresholds.set(2, thresholdSelected);
			break;
		}
    }

	/**
	 * Handel clicks.
	 *
	 * @param event the event
	 */
	@FXML
    void handelClicks(ActionEvent event) {
		if(event.getSource() == SetThresholdButton){
			TitleID.setText("Set Threshold");
			setThresholdFrame.toFront();
			StationManagerClient.getThresholdProducts(user.getPassword());
		}
    	if(event.getSource() == SupplyOrderButton) {
			TitleID.setText("Supply Order");
			supplyOrderFrame.toFront();
			StationManagerClient.getSupplyOrders(user.getPassword());
			
		} else if(event.getSource() == saveThresholdsButton) {
			StationManagerClient.setThresholdProducts(thresholds);

		} else if(event.getSource() == homeButton) {

			TitleID.setText("MyFuel");
			homeFrame.toFront();

		} else if(event.getSource() == aboutButton) {

			TitleID.setText("About MyFuel");
			aboutFrame.toFront();

		} else if(event.getSource() == SubmitOrderButton) {
			StationManagerClient.updateSupplyAmount(GlobalOrder, user.getPassword());

		} else if(event.getSource() == logOutButton) {
			//logout handling

		}
    }
//
//	private void removeLocalOrder(long orderNumber) {
//		System.out.println("been in removeLocalOrder");
//		for(SupplyOrder o: this.orders) {
//			if(o.getOrderNumber() == orderNumber) {
//				this.orders.remove(o);
//			}
//		}
//	}

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
     * Sets the threshold succeed.
     *
     * @param msg the new threshold succeed
     */
    public void setThresholdSucceed(String msg) {
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
    		}
    	});
    }
    
    /**
     * Sets the threshold failed.
     *
     * @param msg the new threshold failed
     */
    public void setThresholdFailed(String msg) {
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
     * Update supply succeed.
     *
     * @param msg the msg
     */
    public void updateSupplySucceed(String msg) {
    	
    	System.out.println("been in updateSupplySucceed befor");
    	
    	for(SupplyOrder s: orders) {
    		if(s.equals(GlobalOrder)) {
    			orders.remove(s);
    			System.out.println("been in updateSupplySucceed in for loop");
    			break;
    		}
    	}
    	System.out.println("been in updateSupplySucceed after for loop");
    	
    	listOforderProductID.remove(selectedIndex);
    	OrderDetailsTA.clear(); 
    	
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
    		}
    	});
    	System.out.println("been in updateSupplySucceed after");
    }
    
    /**
     * Update supply failed.
     *
     * @param msg the msg
     */
    public void updateSupplyFailed(String msg) {
    	
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
    
//
//    public void removeOrderSucceed(long msg) {
//    	System.out.println("been in removeOrderSucceed");
//
//    	System.out.println("been in removeOrderSucceed back here");
//    	// figure out how to refresh the list view !!!!!
//    	//go with remove !!!!
//    	StationManagerClient.getSupplyOrders(user.getPassword());
//    	OrderListView.refresh();
//
//    	System.out.println("been in removeOrderSucceed.... after");
//
//
//    	Image img = new Image("icon/mark.png");
//    	Notifications notificationsBuilder = Notifications.create()
//    			.title("Order")
//    			.text("delete successful")
//    			.graphic(new ImageView(img))
//    			.hideAfter(Duration.seconds((2)))
//    			.position(Pos.CENTER);
//    	notificationsBuilder.darkStyle();
//    	notificationsBuilder.show();
//
//    	Platform.runLater(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				removeLocalOrder(msg);
//			}
//		});
//
//    }
//
//    public void removeOrderFailed(String msg) {
//    	Platform.runLater(new Runnable() {
//
//    		@Override
//    		public void run() {
//    			Image img = new Image("icon/error.png");
//    			Notifications notificationsBuilder = Notifications.create()
//    					.title("Order")
//    					.text(msg)
//    					.graphic(new ImageView(img))
//    					.hideAfter(Duration.seconds((3)))
//    					.position(Pos.CENTER);
//    			notificationsBuilder.darkStyle();
//    			notificationsBuilder.show();
//    		}
//    	});
//    }
//
    
    /**
 * Gets the orders succeed.
 *
 * @param orders the orders
 * @return the orders succeed
 */
public void getOrdersSucceed(ArrayList<SupplyOrder> orders) {
    	
    	

    	ArrayList<String> orderNumbers = new ArrayList<String>();

    	for(SupplyOrder o: orders) {
    		orderNumbers.add(o.getProduct().getProductID());
    	}

    	listOforderProductID = FXCollections.observableArrayList(orderNumbers);
    	OrderListView.setItems(listOforderProductID);
    	this.orders = orders;
    }

    /**
     * Gets the orders failed.
     *
     * @param msg the msg
     * @return the orders failed
     */
    public void getOrdersFailed(String msg) {
    	Platform.runLater(new Runnable() {

    		@Override
    		public void run() {
    			Image img = new Image("/icon/error.png");
    			Notifications notificationsBuilder = Notifications.create()
    					.title("Order")
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
     * Gets the threshold succeed.
     *
     * @param thresholds the thresholds
     * @return the threshold succeed
     */
    public void getThresholdSucceed(ArrayList<Threshold> thresholds) {	// check
    	System.out.println("been in getThresholdSucceed");
    	
    	ObservableList<Threshold> listOfThresholds ;

    	listOfThresholds = FXCollections.observableArrayList(thresholds);
    	
    	ThresholdTableView.setItems(listOfThresholds);
    	
    	this.thresholds = thresholds;
	}

	/**
	 * Gets the threshold failed.
	 *
	 * @param msg the msg
	 * @return the threshold failed
	 */
	public void getThresholdFailed(String msg) {
		Platform.runLater(new Runnable() {

    		@Override
    		public void run() {
    			Image img = new Image("/icon/error.png");
    			Notifications notificationsBuilder = Notifications.create()
    					.title("Order")
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
 	 * Show order.
 	 *
 	 * @param order the order
 	 */
 	private void showOrder(SupplyOrder order) {
	    	StringBuilder sBuilder = new StringBuilder();
	    	sBuilder.append("Product name: ");
	    	sBuilder.append(order.getProduct().getProductName());
	    	sBuilder.append("\n---------------\n");
	    	sBuilder.append("Product ID: ");
			sBuilder.append(order.getProduct().getProductID());
			sBuilder.append("\n---------------\n");
			sBuilder.append("Amount to order:  ");
			sBuilder.append(order.getAmount());
			sBuilder.append("\n---------------\n");

			OrderDetailsTA.setText(sBuilder.toString());
	    }

}
