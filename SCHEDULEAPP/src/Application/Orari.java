package Application;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class Orari {

			private int id;
			private String titlenda;
			private int ects;
			private String profcol;
			private String asscol;
			
			private String ldita;
			private String lora; 
			private int lsalla;
			
			private String udita;
			private String uora;
			private int usalla;
			
			private String nstud;
			private String departamenti;
			private String sem;
			private String grupi;
			

		    public Orari(int id,String titlenda, int ects, String profcol, String asscol,String ldita, String lora, int lsalla,String udita, String uora, int usalla,String nstud, String departamenti, String sem, String grupi) {
		        this.id = id;
		    	this.titlenda = titlenda;
		        this.ects = ects;
		        this.profcol = profcol;
		        this.asscol = asscol;
		        this.ldita = ldita;
		        this.lora = lora;
		        this.lsalla = lsalla;
		        this.udita = udita;
		        this.uora = uora;
		        this.usalla = usalla;
		        this.nstud = nstud;
		        this.departamenti = departamenti;
		        this.sem = sem;
		        this.grupi = grupi;
		    }

		    public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
		    public String getTitlenda() {
		        return titlenda;
		    }
		    public void setTitlenda(String titlenda) {
		    	this.titlenda= titlenda;
		    }
		    public int getEcts() {
		    	return ects;
		    }
		    public void setEcts(int ects) {
		    	this.ects = ects;
		    }
		    public String getProfcol() {
		        return profcol;
		    }
		    public void setProfcol(String profcol) {
		    	this.profcol = profcol;
		    }
		    public String getAsscol() {
		        return asscol;
		    }
		    public void setAsscol(String asscol) {
		    	this.asscol = asscol;
		    }
		    public String getLdita() {
		        return ldita;
		    }
		    public void setLdita(String ldita) {
		    	this.ldita = ldita;
		    }
		    public String getLora() {
		        return lora;
		    }
		    public void setLora(String lora) {
		    	this.lora = lora;
		    }
		    public int getLsalla() {
		    	return lsalla;
		    }
		    public void setLsalla(int lsalla) {
		    	this.lsalla=lsalla;
		    }
		    public String getUdita() {
		        return udita;
		    }
		    public void setUdita(String udita) {
		    	this.udita = udita;
		    }
		    public String getUora() {
		        return uora;
		    }
		    public void setUora(String uora) {
		    	this.uora = uora;
		    }
		    public int getUsalla() {
		    	return usalla;
		    }
		    public void setUsalla(int usalla) {
		    	this.usalla=usalla;
		    }

		    
		    public String getNstud() {
		        return nstud;
		    }
		    public void setNstud(String nstud) {
		    	this.nstud = nstud;
		    }
		    public String getDepartamenti() {
		        return departamenti;
		    }
		    public void setDepartamenti(String departamenti) {
		    	this.departamenti = departamenti;
		    }
		    public String getSem() {
		        return sem;
		    }
		    public void setSem(String sem) {
		    	this.sem = sem;
		    }
		    public String getGrupi() {
		        return grupi;
		    }
		    public void setGrupi(String grupi) {
		    	this.grupi = grupi;
		    }
		    
		    
		    
		    
		    
		    
	 public static boolean addOrari(String titlenda, int ects, String profcol, String asscol, String ldita, String lora, int lsalla, String udita, String uora, int usalla,String nstud, String departamenti, String sem, String grupi) {
				String query = "INSERT INTO orari(titlenda, ects, profcol, asscol, ldita, lora, lsalla, udita, uora, usalla, nstud, departamenti,sem, grupi) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
					
					
					return (preparedStatement.executeUpdate() > 0);
				} catch(SQLException ex) {
					ex.printStackTrace();
					return false;	
				}
			}
	 public static boolean updateOrari(int id,String titlenda, int ects, String profcol, String asscol, String ldita, String lora, int lsalla, String udita, String uora, int usalla,String nstud, String departamenti, String sem, String grupi) {
		System.out.println("id "+id);	
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
	 
	 public static List<Orari> getOrari() {
			List<Orari> orariList = new ArrayList();
			
			String query = "Select * from orari";
			
			try {
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Orari orari = new Orari(
											resultSet.getInt(1),
											resultSet.getString(2),
											resultSet.getInt(3),
											resultSet.getString(4),
											resultSet.getString(5),
											resultSet.getString(6),
											resultSet.getString(7),
											resultSet.getInt(8),
											resultSet.getString(9),
											resultSet.getString(10),
											resultSet.getInt(11),
											resultSet.getString(12),
											resultSet.getString(13),
											resultSet.getString(14),
											resultSet.getString(15)
											);
					orariList.add(orari);
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return orariList;
		}
	 
		    
}
