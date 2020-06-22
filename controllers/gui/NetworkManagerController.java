package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import UserClient.Logout;
import entities.Rates;
import entities.User;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import javafx.util.converter.FloatStringConverter;
import marketingManagerClient.MarketingClientController;
import networkManagerClient.NetworkClientController;

// TODO: Auto-generated Javadoc
/**
 * The Class NetworkManagerController.
 */
public class NetworkManagerController extends CustomerController{

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

    /** The about button. */
    @FXML
    private Button aboutButton;

    /** The about. */
    @FXML
    private ImageView about;

    /** The review rates button. */
    @FXML
    private Button reviewRatesButton;

    /** The sell. */
    @FXML
    private ImageView sell;

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
    
    /** The labale for welcome. */
    @FXML
    private Label labaleForWelcome;

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

    /** The review rates frame. */
    @FXML
    private AnchorPane reviewRatesFrame;

    /** The approve button. */
    @FXML
    private Button approveButton;

    /** The employee. */
    @FXML
    private ImageView employee;

    /** The disapprov button. */
    @FXML
    private Button disapprovButton;

    /** The employee 1. */
    @FXML
    private ImageView employee1;

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

    /** The user. */
    private User user;
    
    /** The rates. */
    private ArrayList<Rates> rates = new ArrayList<Rates>(4);
    
    /**
     * Load welcome lable.
     *
     * @param user the user
     */
    public void loadWelcomeLable(User user) {
    	this.user = user;
		    	
    	labaleForWelcome.setText("Welcome To MyFuel " + user.getFirstName()
		    										  + " " + user.getLastName());
		labelUserName.setText(user.getFirstName());
		
		NetworkClientController.setNetworkManagerController(this);
		
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
	 * Initialize.
	 *
	 * @param location the location
	 * @param resources the resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	homeFrame.toFront();
		TitelId.setText("MyFuel");
		ratesTable.setEditable(false);
		discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
		subscriptionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subscriptionType"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("constFuelPrice"));
		totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
		NetworkClientController.setNetworkManagerController(this);
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


    	} else if(event.getSource() == approveButton) {
    		for(Rates r: rates) {
    			r.setApproved(true);
    		}
    		NetworkClientController.sendApproval(rates);
    		System.out.println("in between");
    		NetworkClientController.updateRates(rates);
    		ratesTable.setItems(null);

    	} else if(event.getSource() == reviewRatesButton) {
    		NetworkClientController.getTmpRates();
    		reviewRatesFrame.toFront();

    	} else if(event.getSource() == aboutButton) {
    		TitelId.setText("About");
    		aboutFrame.toFront();


    	} else if(event.getSource() == logOutButton) {
    		//logout function.

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
     * Send approval succeed.
     *
     * @param msg the msg
     */
    public void sendApprovalSucceed(String msg) {
		Platform.runLater(new Runnable() {

    		@Override
    		public void run() {
    			
    			Notifications notificationsBuilder = Notifications.create()
    					.title("Rates")
    					.text(msg)
    					.graphic(null)
    					.hideAfter(Duration.seconds((3)))
    					.position(Pos.CENTER);
    			notificationsBuilder.darkStyle();
    			notificationsBuilder.showConfirm();
    		}
    	});
    }
    
    /**
     * Send approval failed.
     *
     * @param msg the msg
     */
    public void sendApprovalFailed(String msg) {
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
    	Platform.runLater(new Runnable() {

    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			System.out.println("been in getTmpRatesSucceed ");
    			ObservableList<Rates> ratesFX = FXCollections.observableArrayList(msg);
    			boolean flag = false;
    			for(Rates r: msg) {
    				if(!r.isApproved()) {
    					flag = true;
    					break;
    				}
    			}

    			if(flag) {

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
    				alert.setContentText("there are rates to review");
    				alert.showAndWait();
    				ratesTable.setItems(ratesFX);

    			}
    		}		
    	});

    	this.rates = msg;
    	System.out.println("been in getTmpRatesSucceed ending ");
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
     * Update rates succeed.
     *
     * @param msg the msg
     */
    public void updateRatesSucceed(String msg) {

	}

	/**
	 * Update rates failed.
	 *
	 * @param msg the msg
	 */
	public void updateRatesFailed(String msg) {
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
    
}