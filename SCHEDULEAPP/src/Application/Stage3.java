package Application;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import java.util.ArrayList;
import java.util.List;


public class Stage3 {
	
		//private Stage2 stage2 = new Stage2();
		private static Stage mainstage;
		public static TableView<Orari> table = new TableView<Orari>();
		private static Button backbtn = new Button("Back");
		
		
		//Kolona e pare me emertimet per permbajtjen e tabeles
		private static TableColumn idcol = new TableColumn();
		private static TableColumn titlenda = new TableColumn("TITULLI I LËNDËS");
		private static TableColumn ects = new TableColumn("ECTS");
		private static TableColumn teacher = new TableColumn("MËSIMDHËNËSI");
		private static TableColumn profcol = new TableColumn("PROFESORI");
		private static TableColumn asscol = new TableColumn("ASISTENTI");
		
		
		private static TableColumn ligjeratacol = new TableColumn("LIGJËRATA");
		private static TableColumn ldita = new TableColumn("DITA");
		private static TableColumn lora = new TableColumn("ORA");
		private static TableColumn lsalla = new TableColumn("SALLA");
		
		private static TableColumn ushtrimecol = new TableColumn("USHTRIME");
		private static TableColumn udita = new TableColumn("DITA");
		private static TableColumn uora = new TableColumn("ORA");
		private static TableColumn usalla = new TableColumn("SALLA");
		
		private static Label placeholder = new Label("No visible columns and/or data exist.");
	
		
		public static void thirdstage(Stage stage3){
			 
		mainstage = stage3;
		
//Krijimi i BorderPane per Background
		BorderPane bpane = new BorderPane();
		bpane.setPadding(new Insets(20,25,50,25));
		bpane.setStyle("-fx-background-color:#efefef;");
		

		
		table.setPrefSize(480, 115);
		titlenda.setMinWidth(130);
		ects.setPrefWidth(40);
		ects.setMinWidth(40);
		teacher.setMinWidth(250);
		profcol.setMinWidth(125);
		asscol.setMinWidth(125);
		ligjeratacol.setMinWidth(180);
		ldita.setMinWidth(80);
		lora.setMinWidth(50);
		lsalla.setMinWidth(50);
		ushtrimecol.setMinWidth(180);
		udita.setMinWidth(80);
		uora.setMinWidth(50);
		usalla.setMinWidth(50);

	    if(table.getColumns().size()==0) {
	   table.getItems().clear();
	   teacher.getColumns().addAll(profcol,asscol);
		
		ligjeratacol.getColumns().addAll(ldita, lora, lsalla);
		ushtrimecol.getColumns().addAll(udita, uora, usalla);
	    
		//TableColumn<String, Orari> titlenda = new TableColumn<>("ects");
		idcol.setCellValueFactory(new PropertyValueFactory("id"));
		titlenda.setCellValueFactory(
	       new PropertyValueFactory<Orari, String>("titlenda"));
	    ects.setCellValueFactory(
	 	       new PropertyValueFactory<Orari, String>("ects"));
	    teacher.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("teacher"));
	    profcol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("profcol"));
	    asscol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("asscol"));
	    
	    ligjeratacol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("ligjeratacol"));
	    ldita.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("ldita"));
	    lora.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("lora"));
	    lsalla.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("lsalla"));
	    ushtrimecol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("ushtrimecol"));
	    udita.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("udita"));
	    uora.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("uora"));
	    usalla.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("usalla"));

	    
	    
	    table.setPlaceholder(placeholder);
	    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    table.getItems().clear();
	    }
	    table.setItems( Stage2.showOrarin());
		table.getColumns().addAll(titlenda, ects, teacher,ligjeratacol,ushtrimecol);
		table.setEditable(false);
	    
		
//BUTONI BACK DHE EVENT HANDLERS
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,1));
		hbox.getChildren().add(backbtn);
		backbtn.setPrefHeight(30);
		backbtn.setPrefWidth(70);
		backbtn.setStyle("-fx-background-color:#8e1c1c;-fx-font-weight:bold;-fx-text-fill: white;");
		
		backbtn.setOnAction(e ->{
			stage3.hide();
		//	table.getColumns().clear();
			//table.getItems().clear();
			
			
			try {
				Stage2.secondarystage(mainstage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		backbtn.setOnMouseEntered(e ->{
			backbtn.setStyle("-fx-background-color:linear-gradient(#8e1c1c,#af2121);-fx-font-weight:bold;-fx-text-fill: white;");
			backbtn.setCursor(Cursor.HAND);
		});
		backbtn.setOnMouseExited(e -> {
			backbtn.setStyle("-fx-background-color:#8e1c1c;-fx-font-weight:bold;-fx-text-fill: white;");
		});
		
		
		
//PANE KRYESORE,SCENE DHE STAGE
		Insets tblinsets = new Insets (10,1,10,1);
		bpane.setMargin(table, tblinsets);
		bpane.setTop(hbox);
		bpane.setCenter(table);
		bpane.setMinHeight(400);
		bpane.setMinWidth(835);

		
		Scene scene = new Scene(bpane,835,400);
		
		bpane.minWidthProperty().bind(stage3.minWidthProperty());
		bpane.minHeightProperty().bind(stage3.minHeightProperty());
		stage3.setTitle("Sistemi Për Menaxhimin E Orarit Të Studentëve");
		stage3.setScene(scene);
		stage3.getIcons().add(new Image("/images/unipr.png"));
		stage3.show();
		
		
	}
		public static void shfaqVlerat(ObservableList<Orari> orariList) {
			System.out.println(orariList);
			table.setItems(orariList);
		}
		public static ObservableList<Orari> data(ObservableList<Orari> orariList) {
			System.out.println(orariList);
			table.setItems(orariList);
			return orariList;
		}

		
}


