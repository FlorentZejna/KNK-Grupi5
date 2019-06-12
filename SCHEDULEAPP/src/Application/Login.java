package Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;

public class Login extends Application {
	
	private Connection dbConnection;
	private TextField IDtxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	public  Stage mainStage;
	private Button logInButton = new Button("Kyçu");
	private Label resetpw = new Label("Keni harruar fjalëkalimin?");
	private Stage2 stage2 = new Stage2();
	private Label shqip = new Label("Shqip");
	private Label english = new Label("English");
	private Label help = new Label("Help");
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		DBConnection db=new DBConnection();
		dbConnection=db.getConnection();
		//setConnection();
		
		BorderPane bpane = new BorderPane();
		bpane.setPadding(new Insets(70,200,70,200));
		bpane.setStyle("-fx-background-color:#efefef;");
		bpane.setPrefSize(850, 500);
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setStyle("-fx-background-color:#f2f2f2;");
		gridPane.setEffect(new DropShadow(8,Color.BLACK));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinWidth(395);
		gridPane.setMinHeight(450);

//LOGO NE LOGIN PAGE
		Image image = new Image("/images/unipr.png");
		ImageView logo = new ImageView(image);
		logo.setSmooth(true);
		gridPane.add(logo,1,0);
		
//RRESHTI PERDORUESI
		Label ID = new Label("Përdoruesi:");
		ID.setStyle("-fx-font-size:15;");
		IDtxt.setPromptText("ID");
		IDtxt.setStyle("-fx-font-size:15;");
		IDtxt.setMaxWidth(150);
		gridPane.add(ID, 0, 1);
		gridPane.add(IDtxt, 1, 1);
		
		
//RRESHTI FJALEKALIMI
		Label PW = new Label("Fjalëkalimi:");
		PW.setStyle("-fx-font-size:15;");
		passwordTxt.setStyle("-fx-font-size:15;");
		passwordTxt.setMaxWidth(150);
		gridPane.add(PW, 0, 2);
		gridPane.add(passwordTxt, 1, 2);

		
//LOGIN BUTTON
		logInButton.setPrefWidth(150);
		logInButton.setStyle("-fx-background-color:#8e1c1c;-fx-font-weight:bold;-fx-text-fill: white;");
		gridPane.add(logInButton, 1, 3);

		logInButton.setOnAction(e -> {
			loginUser();
		});
		logInButton.setOnMouseEntered(e -> {
			logInButton.setStyle("-fx-background-color:linear-gradient(#8e1c1c,#af2121);-fx-font-weight:bold;-fx-text-fill: white;");
			logInButton.setCursor(Cursor.HAND);
		});
		logInButton.setOnMouseExited(e -> {
			logInButton.setStyle("-fx-background-color:#8e1c1c;-fx-font-weight:bold;-fx-text-fill: white;");
		});
		
//RRESHTI RESET PASSWORD 
		
		resetpw.setUnderline(true);
		gridPane.add(resetpw, 1, 4);
		
		resetpw.setOnMouseClicked(e ->{
	        getHostServices().showDocument("https://notimi.uni-pr.edu/ResetPassword");
		});
		resetpw.setOnMouseEntered(e ->{
			resetpw.setCursor(Cursor.HAND);
			resetpw.setStyle("-fx-text-fill:#840000;");
		});
		resetpw.setOnMouseExited(e ->{
			resetpw.setStyle("-fx-text-fill: BLACK;");
		});
		
		
// HELP MENU 
		help.setAlignment(Pos.CENTER_LEFT);
		help.setUnderline(true);
		help.setOnMouseEntered(e ->{
			help.setCursor(Cursor.HAND);
			help.setStyle("-fx-text-fill:#840000;");
		});
			help.setOnMouseExited(e -> {
				help.setStyle("-fx-text-fill: BLACK;");
		});
		help.setOnMouseClicked(e -> {
	        	Help.about();
	       });
		
		
		
// BUTONI PER GJUHEN SHQIPE 	
		shqip.setUnderline(true);
		shqip.setOnMouseEntered(e ->{
			shqip.setCursor(Cursor.HAND);
			shqip.setStyle("-fx-text-fill:#840000;");
		});
			shqip.setOnMouseExited(e -> {
				shqip.setStyle("-fx-text-fill: BLACK;");
		});
		
//BUTONI PER GJUHEN ANGLEZE
		english.setUnderline(true);
		english.setOnMouseEntered(e ->{
			english.setCursor(Cursor.HAND);
			english.setStyle("-fx-text-fill:#840000;");
		});
		english.setOnMouseExited(e -> {
			english.setStyle("-fx-text-fill: BLACK;");
		});
		
		HBox hboxhelp = new HBox(5);
		hboxhelp.getChildren().add(help);
		gridPane.add(hboxhelp, 0, 8);
		
		HBox hbox = new HBox(5);
		gridPane.add(hbox, 3, 8);
		hbox.getChildren().addAll(shqip,  english);
		
		
		bpane.setCenter(gridPane);
		Scene scene = new Scene(bpane);
		
		primaryStage.setTitle("Sistemi Për Menaxhimin E Orarit Të Studentëve");
		primaryStage.setScene(scene);
		primaryStage.minWidthProperty().bind(gridPane.minWidthProperty());
		primaryStage.minHeightProperty().bind(gridPane.minHeightProperty());
		//primaryStage.setMinHeight(500);
		//primaryStage.setResizable(false);
		bpane.minWidthProperty().bind(primaryStage.minWidthProperty());
		bpane.minHeightProperty().bind(primaryStage.minHeightProperty());
		
		primaryStage.getIcons().add(new Image("/images/unipr.png"));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private void loginUser() { 
		String query = "Select * from users where numriid = ? AND password = ?";
	  
	  try {
	  PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
	  
	  preparedStatement.setString(1,IDtxt.getText());
	  preparedStatement.setString(2, getMd5(passwordTxt.getText()));
	  ResultSet result = preparedStatement.executeQuery();
	  if(result.next()) {	
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setResizable(false);
		  alert.setTitle("Login result");
		  alert.setHeaderText(null);
		  alert.setContentText("You are logged in!");
		  alert.showAndWait();
		  mainStage.hide();
		  String usr=String.valueOf(IDtxt.getText());
		  BigInteger bi=new BigInteger(usr);
		  BigInteger one = new BigInteger("1");
		  int test=bi.compareTo(one);
		  if(test==0){
		  try {
			  stage3admin.adminStage(mainStage);
		  	  } 
		  catch (Exception e1)
		  	{
			 e1.printStackTrace();
		  	}
		  }
		  else {
		  try {
			  Stage2.secondarystage(mainStage);
		  	  } 
		  catch (Exception e1)
		  	{
			 e1.printStackTrace();
		  	}
	  	}
	  }
	  
	    else { 
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setResizable(false);
		 alert.setTitle("Login result"); 
		 alert.setHeaderText(null);
		 alert.setContentText("Email or password is wrong!"); 
		 alert.showAndWait();
	         }
	  
	  } 
	  catch(SQLException ex) 
	  		{ 
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setResizable(false);
		  alert.setTitle("Database problem");
		  alert.setHeaderText(null);
		  alert.setContentText(ex.getMessage()); 
		  alert.showAndWait(); System.exit(0); 
	  		}
	  }
	public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
}

