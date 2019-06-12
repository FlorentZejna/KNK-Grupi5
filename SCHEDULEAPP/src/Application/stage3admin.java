package Application;
import java.sql.*;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class stage3admin {

	private static Stage mainstage;
	private static Stage mainStage;
	private static Stage primaryStage = new Stage();
	// Text fields
	private static TextField idField = new TextField();
	private static TextField subjectField = new TextField();
	private static TextField ectsField = new TextField();
	private static TextField profField = new TextField();
	private static TextField assField = new TextField();
	private static TextField LditaField = new TextField();
	private static TextField LoraField = new TextField();
	private static TextField LsallaField = new TextField();
	private static TextField UditaField = new TextField();
	private static TextField UoraField = new TextField();
	private static TextField UsallaField = new TextField();
	private static TextField nstudField = new TextField();
	private static TextField departamentiField = new TextField();
	private static TextField semField = new TextField();
	private static TextField grupiField = new TextField();
	
	
	
	// Buttons
	private static Button insertBtn = new Button("Insert");
	private static Button updateBtn = new Button("Update");
	private static Button deleteBtn = new Button("Delete");
	private static Button clearBtn = new Button("Clear");
	private static Button logoutBtn = new Button("LogOut");
	
	
	// Table views
	private static TableView OrariTbl = new TableView();
	
	
	
	public static void adminStage(Stage stage3admin)  {
		
		mainstage = stage3admin;
		// Form pane
		GridPane formPane = new GridPane();
		
		
		formPane.addRow(0, new Label("ID: "), idField);
		formPane.addRow(1, new Label("Lenda: "), subjectField);
		formPane.addRow(2, new Label("Ects: "), ectsField);
		formPane.addRow(3, new Label("Profesori: "), profField);
		formPane.addRow(4, new Label("Assistenti: "), assField);
		formPane.addRow(5, new Label("Ligj/Dita: "), LditaField);
		formPane.addRow(6, new Label("Ligj/Ora: "), LoraField);
		formPane.addRow(7, new Label("Ligj/Salla: "), LsallaField);
		formPane.addRow(8, new Label("Usht/Dita: "), UditaField);
		formPane.addRow(9, new Label("Usht/Ora: "), UoraField);
		formPane.addRow(10, new Label("Usht/Salla: "), UsallaField);
		formPane.addRow(11, new Label("Niveli stud:"), nstudField);
		formPane.addRow(12, new Label("Departamenti:"), departamentiField);
		formPane.addRow(13, new Label("Semestri:"), semField);
		formPane.addRow(14, new Label("Grupi:"), grupiField);
		
		formPane.setHgap(10);
		formPane.setVgap(10);
		
//		idField.setDisable(true);
		
		// Buttons pane
		HBox buttonsPane = new HBox(10);
		
		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn,logoutBtn);
		
		logoutBtn.setOnAction(e ->{
			stage3admin.close();
		
		});
		
		insertBtn.setOnAction(e -> {
			insertOrari();
		});
		
		clearBtn.setOnAction(e -> {
			clearOrari();
		});
		updateBtn.setOnAction(e -> {
			updateOrari(Integer.parseInt(idField.getText()),
						subjectField.getText(),
					  Integer.parseInt(ectsField.getText()),
					  profField.getText(),
					  assField.getText(),
					  LditaField.getText(),
					  LoraField.getText(),
					  Integer.parseInt(LsallaField.getText()),
					  UditaField.getText(),
					  UoraField.getText(),
					  Integer.parseInt(UsallaField.getText()),
					  nstudField.getText(),
					  departamentiField.getText(),
					  semField.getText(),
					  grupiField.getText()
					 
					  );
			{
				showOrari();
				clearOrari();
			}
		});
		deleteBtn.setOnAction(e -> {
			deleteOrari(Integer.parseInt(idField.getText()));
		});
		// Left Pane
		
		VBox leftPane = new VBox(15);
		
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		TableColumn teacher = new TableColumn("Mesimdhenesi");
		TableColumn ligjeratacol = new TableColumn("Ligjerata");
		TableColumn ushtrimecol = new TableColumn("Ushtrime");
		// Books table
		TableColumn<String, Orari> column1 = new TableColumn<>("ID:");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column1.setPrefWidth(60);
		
		TableColumn<String, Orari> column2 = new TableColumn<>("Lendet");
		column2.setCellValueFactory(new PropertyValueFactory("titlenda"));
		column2.setPrefWidth(60);
		
		TableColumn<String, Orari> column3 = new TableColumn<>("Ects");
		column3.setCellValueFactory(new PropertyValueFactory("ects"));
		column3.setPrefWidth(150);
		
		TableColumn<String, Orari> column4 = new TableColumn<>("Profesori");
		column4.setCellValueFactory(new PropertyValueFactory("profcol"));
		column4.setPrefWidth(150);
		
		TableColumn<String, Orari> column5 = new TableColumn<>("Assistenti");
		column5.setCellValueFactory(new PropertyValueFactory("asscol"));
		column5.setPrefWidth(120);
		
		TableColumn<String, Orari> column6 = new TableColumn<>("Dita");
		column6.setCellValueFactory(new PropertyValueFactory("ldita"));
		column6.setPrefWidth(120);
		
		TableColumn<String, Orari> column7 = new TableColumn<>("Ora");
		column7.setCellValueFactory(new PropertyValueFactory("lora"));
		column7.setPrefWidth(120);
		TableColumn<String, Orari> column8 = new TableColumn<>("Salla");
		column8.setCellValueFactory(new PropertyValueFactory("lsalla"));
		column8.setPrefWidth(120);
		TableColumn<String, Orari> column9 = new TableColumn<>("Dita");
		column9.setCellValueFactory(new PropertyValueFactory("udita"));
		column9.setPrefWidth(120);
		TableColumn<String, Orari> column10 = new TableColumn<>("Ora");
		column10.setCellValueFactory(new PropertyValueFactory("uora"));
		column10.setPrefWidth(120);
		TableColumn<String, Orari> column11 = new TableColumn<>("Salla");
		column11.setCellValueFactory(new PropertyValueFactory("usalla"));
		column11.setPrefWidth(120);
		
		teacher.getColumns().addAll(column4,column5);
		ligjeratacol.getColumns().addAll(column6, column7, column8);
		ushtrimecol.getColumns().addAll(column9, column10, column11);
		
		OrariTbl.getColumns().add(column2);
		OrariTbl.getColumns().add(column3);
		OrariTbl.getColumns().add(teacher);
		OrariTbl.getColumns().add(ligjeratacol);
		OrariTbl.getColumns().add(ushtrimecol);
		
		OrariTbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		
		OrariTbl.setPrefWidth(650);
		OrariTbl.setPrefHeight(200);
		
		// Main Pane
		HBox mainPane = new HBox(10);
		
		mainPane.getChildren().addAll(leftPane, OrariTbl);
		
		mainPane.setPadding(new Insets(15, 15, 15 ,15));
		
		
		Scene scene = new Scene(mainPane, 1000, 580);
		
		stage3admin.setTitle("Admin Stage");
		stage3admin.setScene(scene);
		
		showOrari();
		
		stage3admin.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void showOrari() {
		List<Orari> orariL = Orari.getOrari();
		
		ObservableList<Orari> orariList = FXCollections.observableArrayList();
		
		for(int i = 0; i < orariL.size(); i++) {
			orariList.add(orariL.get(i));
		}
		
		OrariTbl.setItems(orariList);
	}
	
	public static void insertOrari() {
		
		if(Orari.addOrari(subjectField.getText(),
						  Integer.parseInt(ectsField.getText()),
						  profField.getText(),
						  assField.getText(),
						  LditaField.getText(),
						  LoraField.getText(),
						  Integer.parseInt(LsallaField.getText()),
						  UditaField.getText(),
						  UoraField.getText(),
						  Integer.parseInt(UsallaField.getText()),
						  nstudField.getText(),
						  departamentiField.getText(),
						  semField.getText(),
						  grupiField.getText()
						  ))
		{
			showOrari();
			clearOrari();
		}
	}
	
	public static void clearOrari() {
		idField.setText("");
		subjectField.setText("");
		ectsField.setText("");
		profField.setText("");
		assField.setText("");
		LditaField.setText("");
		LoraField.setText("");
		LsallaField.setText("");
		UditaField.setText("");
		UoraField.setText("");
		UsallaField.setText("");
		nstudField.setText("");
		departamentiField.setText("");
		semField.setText("");
		grupiField.setText("");
	}
	public static boolean updateOrari(int id,String titlenda, int ects, String profcol, String asscol, String ldita, String lora, int lsalla, String udita, String uora, int usalla,String nstud, String departamenti, String sem, String grupi) {
		System.out.println(id);
		String query = "UPDATE orari SET titlenda=?, ects=?, profcol=?, asscol=?, ldita=?, lora=?, lsalla=?, udita=?, uora=?, usalla=?, nstud=?, departamenti=?, sem=?, grupi=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, titlenda);
			preparedStatement.setInt(2, ects);
			preparedStatement.setString(3, profcol);
			preparedStatement.setString(4, asscol);
			preparedStatement.setString(5, ldita);
			preparedStatement.setString(6, lora);
			preparedStatement.setInt(7, lsalla);
			preparedStatement.setString(8, udita);
			preparedStatement.setString(9, uora);
			preparedStatement.setInt(10, usalla);
			preparedStatement.setString(11, nstud);
			preparedStatement.setString(12, departamenti);
			preparedStatement.setString(13, sem);
			preparedStatement.setString(14, grupi);
			preparedStatement.setInt(15, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static boolean deleteOrari(int id) {
		String query = "Delete from orari where id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
