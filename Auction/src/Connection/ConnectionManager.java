package Connection;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionManager {
	static Connection conn=null;
	public static Properties loadPropertiesFile()throws Exception{
		//property file for modular coding
		Properties prop=new Properties();//Object for Properties class
		InputStream in=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Auction\\resources\\jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
		
	}
	public Connection getConnection() throws Exception
	{
		Properties prop=loadPropertiesFile();
		final String driver=prop.getProperty("driver");
		final String url=prop.getProperty("url");
		final String username=prop.getProperty("username");
		final String password=prop.getProperty("password");
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		try {
			conn=DriverManager.getConnection(url,username,password);
			/*if (conn != null)
			{
				System.out.println("Connected");
			}
			else
			{
				System.out.println("not Connected");
			}*/
		
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Connection failed! check output console");
			e.printStackTrace();
			throw e;
		}
		return conn;
		
	}

}