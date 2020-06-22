package gui;

import java.awt.Checkbox;
import java.net.URL;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import CustomerClient.CustomerClientController;
import UserClient.Logout;
import entities.Car;
import entities.Customer;
import entities.User;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
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
import javafx.util.Duration;
import marketingRepClient.MarketingRepClientController;

// TODO: Auto-generated Javadoc
/**
 * The Class MarketingRepController.
 */
public class MarketingRepController extends CustomerController {
	
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

	/** The registration button. */
	@FXML
	private Button registrationButton;

	/** The user. */
	@FXML
	private ImageView user;

	/** The Sale campaign button. */
	@FXML
	private Button SaleCampaignButton;

	/** The campaign. */
	@FXML
	private ImageView campaign;

	/** The analitic report burron. */
	@FXML
	private Button analiticReportBurron;

	/** The analitic. */
	@FXML
	private ImageView analitic;

	/** The settings button. */
	@FXML
	private Button settingsButton;

	/** The setting. */
	@FXML
	private ImageView setting;

	/** The Go todalkan button. */
	@FXML
	private Button GoTodalkanButton;

	/** The dalkan icon. */
	@FXML
	private ImageView dalkanIcon;

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

	/** The sale campaign frame. */
	@FXML
	private AnchorPane saleCampaignFrame;

	/** The home frame. */
	@FXML
	private AnchorPane homeFrame;

	/** The welcome label. */
	@FXML
	private Label welcomeLabel;

	/** The Dalkan frame. */
	@FXML
	private AnchorPane DalkanFrame;

	/** The add dalkan button. */
	@FXML
	private Button addDalkanButton;

	/** The home 121. */
	@FXML
	private ImageView home121;

	/** The car list dalkan. */
	@FXML
	private ListView<?> carListDalkan;

	/** The customer ID text field dalkan. */
	@FXML
	private TextField customerIDTextFieldDalkan;

	/** The remove dalkan button. */
	@FXML
	private Button removeDalkanButton;

	/** The home 1211. */
	@FXML
	private ImageView home1211;

	/** The Purchase frame. */
	@FXML
	private AnchorPane PurchaseFrame;

	/** The radio button 1. */
	@FXML
	private RadioButton radioButton1;

	/** The group 1. */
	@FXML
	private ToggleGroup group1;

	/** The radio button 2. */
	@FXML
	private RadioButton radioButton2;

	/** The radio button 3. */
	@FXML
	private RadioButton radioButton3;

	/** The radio button 4. */
	@FXML
	private RadioButton radioButton4;

	/** The submit purchase program button. */
	@FXML
	private Button submitPurchaseProgramButton;

	/** The home 1. */
	@FXML
	private ImageView home1;

	/** The home 12. */
	@FXML
	private ImageView home12;

	/** The car list purchase. */
	@FXML
	private ListView<String> carListPurchase;

	/** The customer ID text field. */
	@FXML
	private TextField customerIDTextField;

	/** The car number text field. */
	@FXML
	private TextField carNumberTextField;

	/** The add car button. */
	@FXML
	private Button addCarButton;

	/** The Back to reg button. */
	@FXML
	private Button BackToRegButton;

	/** The home 11. */
	@FXML
	private ImageView home11;

	/** The Registration frame. */
	@FXML
	private AnchorPane RegistrationFrame;

	/** The Purchase next button. */
	@FXML
	private Button PurchaseNextButton;

	/** The continue 1. */
	@FXML
	private ImageView continue1;

	/** The is private user button. */
	@FXML
	private RadioButton isPrivateUserButton;

	/** The group 2. */
	@FXML
	private ToggleGroup group2;

	/** The is company button. */
	@FXML
	private RadioButton isCompanyButton;

	/** The want A car button. */
	@FXML
	private CheckBox wantACarButton;

	/** The Submit button. */
	@FXML
	private Button SubmitButton;

	/** The submit 1. */
	@FXML
	private ImageView submit1;

	/** The User first name. */
	@FXML
	private TextField UserFirstName;

	/** The User last name. */
	@FXML
	private TextField UserLastName;

	/** The User id. */
	@FXML
	private TextField UserId;

	/** The User email. */
	@FXML
	private TextField UserEmail;
	
    /** The Campaign name TF. */
    @FXML
    private TextField CampaignNameTF;

    /** The discount TF. */
    @FXML
    private TextField discountTF;

    /** The generate campaign T button. */
    @FXML
    private Button generateCampaignTButton;

	/** The User credit card. */
	@FXML
	private TextField UserCreditCard;
	
    @FXML
    private AnchorPane weekReportFrame;

    @FXML
    private Button analiticButton;
	
	/** The flag. */
	private boolean flag = false;
	
	/** The new user. */
	private User newUser;
	
	/** The user. */
	private User theUser;
	
	/** The selected index. */
	private int selectedIndex = 0;
	
	private String selectedItem;
	
	/** The is private. */
	private boolean isPrivate;
	
	/** The I ds. */
	private ArrayList<String> IDs;
	
	/** The car number list. */
	ObservableList<String> carNumberList = FXCollections.observableArrayList();

	/** The cars. */
	private ArrayList<Car> cars = new ArrayList<Car>();

	/** The customer. */
	private Customer customer;

	/**
	 * Load welcome lable.
	 *
	 * @param user the user
	 */
	@Override
	public void loadWelcomeLable(User user) {
		// TODO Auto-generated method stub
		this.theUser = user;

		welcomeLabel.setText("Welcome To MyFuel " + user.getFirstName()
		+ " " + user.getLastName());
		labelUserName.setText(user.getFirstName());

		MarketingRepClientController.setMarketingRepController(this);
	}

	/**
	 * Log out operation.
	 */
	@Override
	protected void logOutOperation() {
		// TODO Auto-generated method stub
    	Logout.setMainWindowController(this);
    	Logout.logoutRequest(theUser);
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
     * R bclick.
     *
     * @param event the event
     */
    @FXML
    void RBclick(ActionEvent event) {
    	if(event.getSource() == isPrivateUserButton) {
    		isPrivate = true;
    		
    	} else if(event.getSource() == isCompanyButton) {
    		isPrivate = false;
    	}
    }
	
	/**
	 * Handel clicks.
	 *
	 * @param event the event
	 */
	@FXML
	void handelClicks(ActionEvent event) {
		
		if (event.getSource() == homeButton) {
			setImages(event);
		} else if(event.getSource() == generateCampaignTButton){
			try{
				if(checkDiscountValidity((Double.valueOf(discountTF.getText().toString()))))
					MarketingRepClientController.GenerateCampaignTemplate(CampaignNameTF.getText(), (Double.valueOf(discountTF.getText())/100));
				else{
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							Image img = new Image("/icon/error.png");
							Notifications notificationsBuilder = Notifications.create()
									.title("Discount invalid")
									.text("Wrong discount input, please enter Integer discount between the range of 0-99")
									.graphic(new ImageView(img))
									.hideAfter(Duration.seconds((3)))
									.position(Pos.CENTER);
							notificationsBuilder.darkStyle();
							notificationsBuilder.show();
						}
					});
				}
			} catch(NumberFormatException e){
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						Image img = new Image("/icon/error.png");
						Notifications notificationsBuilder = Notifications.create()
								.title("Discount invalid")
								.text("Wrong input, this is not a number. Please enter Integer discount between the range of 0-99")
								.graphic(new ImageView(img))
								.hideAfter(Duration.seconds((3)))
								.position(Pos.CENTER);
						notificationsBuilder.darkStyle();
						notificationsBuilder.show();
					}
				});
			}

		} else if (event.getSource() == SaleCampaignButton ) {
			setImages(event);
			
		} else if (event.getSource() == analiticReportBurron ) {
			weekReportFrame.toFront();
			
		} else if (event.getSource() == analiticButton ) {
			MarketingRepClientController.produceAnalitic();
			
		} else if (event.getSource() == GoTodalkanButton) {
			setImages(event);

		} else if (event.getSource() == registrationButton) {
			setImages(event);


		} else if (event.getSource() == logOutButton) {
			// logout function.
			logOutOperation();

		} else if (event.getSource() == SubmitButton) {
			if(checkValidity()) {
				submit1.setImage(submitRed);
				//thread sleep 1000 and set regular image
				setCustomerNoCars();
				if(IDs.contains(customer.getPassword())) {
					Image img = new Image("/icon/error.png");
					Notifications notificationsBuilder = Notifications.create()
							.title("Registration")
							.text("ID all ready exists in the system")
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((3)))
							.position(Pos.CENTER);
					notificationsBuilder.darkStyle();
					notificationsBuilder.show();
					UserId.clear();
				} else {
					MarketingRepClientController.addCustomer(customer);
				}
				//add customer to DB send as Customer make the notification on the way back
			} else {

				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Registration")
						.text("All fields must be enterd")
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}

		} else if (event.getSource() == wantACarButton) {

			if(!wantACarButton.isSelected()) {
				PurchaseNextButton.setDisable(true);
				SubmitButton.setDisable(false);
				continue1.setImage(nextView);
			}
			if(wantACarButton.isSelected()) {
				SubmitButton.setDisable(true);
				PurchaseNextButton.setDisable(false);
				continue1.setImage(nextView);
			}

		} else if (event.getSource() == PurchaseNextButton) {
			setCustomerNoCars();// saved the data of the costumer

			if(checkValidity())	
			{
				continue1.setImage(nextRed);
				PurchaseFrame.toFront();
				TitelId.setText("Purchase Program and Dalkan");
				customerIDTextField.setText(UserId.getText().toString());
			} else {
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Registration")
						.text("All fields must be enterd")
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
		}
		else if (event.getSource() == BackToRegButton) {

			if(carNumberList.size() > 0) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Back");
				alert.setContentText("This function will delete all cars");
				Optional<ButtonType> result = alert.showAndWait();
				if(result.get() == ButtonType.OK) {
					continue1.setImage(nextView);
					RegistrationFrame.toFront();
					cars.clear();
					carNumberList.clear();
				} else if(result.get() == ButtonType.CANCEL) {
					event.consume();
				}
			} else {
				continue1.setImage(nextView);
				RegistrationFrame.toFront();
			}

		} else if (event.getSource() == addCarButton) {
			String msg = checkValidCarNumber();
			if(msg == "ok") {
				carNumberList.add(carNumberTextField.getText().toString());
				carListPurchase.setItems(carNumberList);
				addNewCar();
			} else {
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Car")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
			}
			if(carNumberList.size() > 0) {
				submitPurchaseProgramButton.setDisable(false);
			}

			if(carNumberList.size() >= 2 ) {
				radioButton3.setDisable(false);
				radioButton4.setDisable(false);
			}

		} else if (event.getSource() == addDalkanButton) {
			String thisCarNumber = carNumberList.get(selectedIndex);
			
			for(Car c: cars) {
				if(c.getCarID().equals(thisCarNumber)) {
					c.setNFC(true);
					System.out.println("is nfc");
				}
			} //small pop up to confirm ?
			
		} else if (event.getSource() == submitPurchaseProgramButton) {
			customer.setListOfCars(cars);
			MarketingRepClientController.addCustomerWithCar(customer);

	}
	}

		private boolean checkDiscountValidity(Double discount) {
			if (discount < 0 || discount >= 99)
				return false;
			return true;
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
	// add all icons and imageviews

	/**
	 * Handle radio buttons.
	 *
	 * @param event the event
	 */
	@FXML
	void handleRadioButtons(ActionEvent event) {

		if (event.getSource() == radioButton1) {
			flag = true;
			this.customer.setPurchaseProgram("Intermediate");

		} else if (event.getSource() == radioButton2 ) {
			flag = true;
			this.customer.setPurchaseProgram("Regular");

		} else if (event.getSource() == radioButton3 ) {
			flag = true;
			this.customer.setPurchaseProgram("Plurality of Cars");

		} else if (event.getSource() == radioButton4 ) {
			flag = true;
			this.customer.setPurchaseProgram("Full");

		}
	}

	/**
	 * Handle mouse click.
	 *
	 * @param event the event
	 */
	@FXML
	void handleMouseClick(MouseEvent event) {
		selectedIndex = carListPurchase.getSelectionModel().getSelectedIndex();
		selectedItem = carListPurchase.getSelectionModel().getSelectedItem();
		
	}

	/**
	 * Adds the new car.
	 */
	private void addNewCar() {
		Car car = new Car(customer.getPassword(),
				carNumberTextField.getText().toString(),false);
		cars.add(car);
	}

	/**
	 * Check valid car number.
	 *
	 * @return the string
	 */
	private String checkValidCarNumber() {
		String msg = "";
		String str = carNumberTextField.getText().toString();
		if(str.length() > 0) {
			//    		try {  
			//    		    Double.parseDouble(str); 
			//    		  } catch(NumberFormatException e){  
			//    		    return "invalid car number";  
			//    		  }  
			msg = "ok";
			for(String s: carNumberList) {
				if(s.equals(str)) {
					msg = "duplicate car number";
				}
			}
			return msg;
		}

		return "must enter car number";
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
	 * Adds the customer succeed.
	 *
	 * @param msg the msg
	 */
	public void addCustomerSucceed(String msg) {
		resetRegistrationFrame();
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("/icon/mark.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Registration")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
				resetPurchaseFrame();
			}
		});
	}

	/**
	 * Adds the customer failed.
	 *
	 * @param msg the msg
	 */
	public void addCustomerFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Registration")
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
	 * Reset registration frame.
	 */
	private void resetRegistrationFrame() {
		UserCreditCard.clear();
		UserFirstName.clear();
		UserLastName.clear();
		UserId.clear();
		UserEmail.clear();
		radioButton3.setDisable(true);
		radioButton4.setDisable(true);
		submitPurchaseProgramButton.setDisable(true);
		//clear observable list
	}
	
	/**
	 * Reset purchase frame.
	 */
	private void resetPurchaseFrame() {
		customerIDTextField.clear();
		carNumberTextField.clear();
		cars.clear();
		carNumberList.clear();
		RegistrationFrame.toFront();
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
		PurchaseNextButton.setDisable(true);
		submitPurchaseProgramButton.setDisable(true);
		MarketingRepClientController.setMarketingRepController(this);
		MarketingRepClientController.getAllCustomerID();
		radioButton3.setDisable(true);
		radioButton4.setDisable(true);
	}

	/**
	 * Sets the customer no cars.
	 */
	private void setCustomerNoCars() {


		Customer customer = new Customer(
				UserFirstName.getText().toString(),
				UserLastName.getText().toString(),
				UserEmail.getText().toString(),
				UserCreditCard.getText().toString(),
				UserId.getText().toString(),
				isPrivate);
		this.customer = customer;
	}


	/**
	 * Sets the images.
	 *
	 * @param event the new images
	 */
	private void setImages(ActionEvent event) {
		if(event.getSource() == homeButton) {
			homeFrame.toFront();
			TitelId.setText("MyFuel");
			home.setImage(homeRed);
			user.setImage(registrationView);
			analitic.setImage(anliticView);
			campaign.setImage(campaignView);

			dalkanIcon.setImage(dalkanIconView);

		} else if(event.getSource() == SaleCampaignButton) {
			saleCampaignFrame.toFront();
			TitelId.setText("Sale Campaign");
			campaign.setImage(campaignRed);
			user.setImage(registrationView);
			home.setImage(homeView);
			analitic.setImage(anliticView);
			dalkanIcon.setImage(dalkanIconView);

		} else if(event.getSource() == GoTodalkanButton) {
			DalkanFrame.toFront();
			TitelId.setText("Dalkan");
			dalkanIcon.setImage(dalkanIconRed);
			user.setImage(registrationView);
			home.setImage(homeView);
			analitic.setImage(anliticView);
			campaign.setImage(campaignView);

		} else if(event.getSource() == registrationButton) {
			RegistrationFrame.toFront();
			TitelId.setText("Registration");
			user.setImage(registrationRed);
			home.setImage(homeView);
			analitic.setImage(anliticView);
			campaign.setImage(campaignView);
			dalkanIcon.setImage(dalkanIconView);

		} 
	}

	/**
	 * Check validity.
	 *
	 * @return true, if successful
	 */
	//only for submit
	private boolean checkValidity() {
		if ((UserFirstName.getText().toString().length() > 0)
				|| (UserLastName.getText().toString().length() > 0) 
				|| (UserId.getText().toString().length() > 0 ) 
				|| (UserEmail.getText().toString().length() > 0)
				|| (UserCreditCard.getText().toString().length() > 0)
				|| (isCompanyButton.isSelected()) 
				|| (isPrivateUserButton.isSelected())){

			return true;

		}

		return false;
	}

	public void GenerateCampaignTemplateSucceeded(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("/icon/mark.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Generated New Sale Template Successfully")
						.text(msg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
				
			}
		});

	}

	public void GenerateCampaignTemplateFailed(String msg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Generate Campaign")
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
	 * Sets the customer I ds.
	 *
	 * @param IDsArrayList the new customer I ds
	 */
	public void setCustomerIDs(ArrayList<String> IDsArrayList) {
		// TODO Auto-generated method stub
		this.IDs = IDsArrayList;
	}

	/**
	 * Gets the all customer ID failed.
	 *
	 * @param str the str
	 * @return the all customer ID failed
	 */
	public void getAllCustomerIDFailed(String str) {
		// TODO Auto-generated method stub
		IDs = null;
		System.out.println("been to getAllCustomerIDFailed");
	}

}
