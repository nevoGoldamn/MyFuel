package gui;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import org.controlsfx.control.Notifications;

import UserClient.Login;
import UserClient.Logout;
import client.ClientManager;
import entities.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;


/**
 * The Class MainWindowController.
 */
public class MainWindowController extends Application implements Initializable{

	/** The user text. */
	@FXML
	private TextField userText;

	/** The pass text. */
	@FXML
	private PasswordField passText;

	/** The login button. */
	@FXML
	private Button loginButton;

	@FXML
	private Button fuelingDemoButton;

	private ActionEvent event;

	/**
	 * Login request.
	 *
	 * @param event the event
	 */

	@Override
	public void start(Stage primaryStage) {

		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
			AnchorPane pane = (AnchorPane)loader.load();//root of the fxml file
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("/MyFuelCss/Application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle("MyFuel");
			primaryStage.setScene(scene);
						primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
							@Override
							public void handle(WindowEvent event) {
								ClientManager.getClientManager().quit();
								System.exit(0);
							}
						});
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void loginRequest(ActionEvent event) {

		this.event = event;
		if(event.getSource() == loginButton) {
			if(userText.getText().trim().length() == 0 || passText.getText().trim().length() == 0) {//not empty data

				Image img = new Image("icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Login")
						.text("All fields must be enterd")
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();

			} else {

				Login.loginRequest(userText.getText(), passText.getText());
			}
			
		} else if(event.getSource() == fuelingDemoButton) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Fueling.fxml"));//set the permission on DB when register																		                                                        
						AnchorPane pane = (AnchorPane)loader.load();
						FulingController fulingController = (FulingController)loader.getController();
						Scene scene = new Scene(pane);
						scene.getStylesheets().add(getClass().getResource("/MyFuelCss/Application.css").toExternalForm());// look up
						Stage primaryStage = (Stage)loginButton.getScene().getWindow();// maybe we will use this, i don't know, so i save it for this time.
						primaryStage.setScene(scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
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
		loginButton.setDisable(false);
		Login.setMainWindowController(this);
	}

	public void loginSucceeded(User user) {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Image img = new Image("/icon/mark.png");
					Notifications notificationsBuilder = Notifications.create()
							.title("Login")
							.text("Login succeeded")
							.graphic(new ImageView(img))
							.hideAfter(Duration.seconds((4)))
							.position(Pos.CENTER);
					notificationsBuilder.darkStyle();
					notificationsBuilder.show();
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + user.getPermission() + ".fxml"));//set the permission on DB when register																		                                                        
					AnchorPane pane = (AnchorPane)loader.load();
					CustomerController CustomerController = (CustomerController)loader.getController();
					CustomerController.loadWelcomeLable(user);
					Scene scene = new Scene(pane);
					scene.getStylesheets().add(getClass().getResource("/MyFuelCss/Application.css").toExternalForm());
					Stage primaryStage = (Stage)loginButton.getScene().getWindow();
					primaryStage.setScene(scene);
					

					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void loginFailed(String msg) {

		Platform.runLater(new Runnable() {
			String textMsg ;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(msg.contains("Wrong")) {
					textMsg = "Login Failed > Wrong ID or Password";

				} else if(msg.contains("User")) {
					textMsg = "Login Failed > User is already logged in";
				}

				Image img = new Image("/icon/error.png");
				Notifications notificationsBuilder = Notifications.create()
						.title("Login")
						.text(textMsg)
						.graphic(new ImageView(img))
						.hideAfter(Duration.seconds((2)))
						.position(Pos.CENTER);
				notificationsBuilder.darkStyle();
				notificationsBuilder.show();
				userText.setText("");
				passText.setText("");
			}
		});

	}

}
