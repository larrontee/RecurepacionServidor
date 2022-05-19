package conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class PoolDB {

	public DataSource dataSource;

	public PoolDB() {
		initDataSource();
	}

	private void initDataSource() {
		BasicDataSource basicDataSources = new BasicDataSource();
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("bdPool.properties"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		basicDataSources.setDriverClassName(properties.getProperty("db.classForName"));
		basicDataSources.setUsername(properties.getProperty("db.username"));
		basicDataSources.setPassword(properties.getProperty("db.password"));
		String url = properties.getProperty("db.url") + "//" + properties.getProperty("db.host") + ":"
				+ properties.getProperty("db.port") + "/" + properties.getProperty("db.dbname");
		basicDataSources.setUrl(url);
		basicDataSources.setMaxTotal(Integer.parseInt(properties.getProperty("db.pool.maxTotal")));
		basicDataSources.setMaxIdle(Integer.parseInt(properties.getProperty("db.pool.maxIdle")));
		dataSource = basicDataSources;
	}

	public Connection getConnection() {
		Connection result = null;
		try {
			result = dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}