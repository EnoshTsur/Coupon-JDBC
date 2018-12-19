package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConnectionPool {

	// Class attributes
	private Set<Connection> connections = new HashSet<>();

	// Create one instance of an object
	private static ConnectionPool instance;

	// URL for connections
	private static final int MAX_CON = 15;
	private String url = "jdbc:derby://localhost:1527/CouponSystem;create=true";

	/***
	 * Private CTR
	 */
	private ConnectionPool() {
		for (int i = 0; i < MAX_CON; i++) {
			try {
				Connection con = DriverManager.getConnection(url);
				connections.add(con);
			} catch (SQLException e) {
				System.err.println("Could not get the connection1");
				System.err.println(e.getMessage());
			}
		}
	}

	/***
	 * Get the connections
	 * 
	 * @return
	 * @throws SQLException
	 */
	public synchronized Connection getConnection() {
		while (connections.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Some one interrupted waiting");
			}
		}

		Iterator<Connection> it = connections.iterator();
		Connection con = it.next();
		it.remove();
		return con;
	}

	/***
	 * Return connection parameter
	 * 
	 * @param c
	 *            (Connection)
	 * @return
	 */
	public synchronized void returnConnection(Connection c) {
		connections.add(c);
		notify();
	}

	/***
	 * Close all connections
	 */
	public synchronized void closeAllConnections() {
		// Counter for checking if all connections are close
		int counter = 0;

		// Checking if the remove-counter less the max connections
		while (counter < MAX_CON) {

			// While its empty wait..
			while (connections.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.err.println("Someone interrupt waiting");
				}
			}
			// Running over the available connections
			// Closing the connection and adding 1 to the counter
			Iterator<Connection> itCon = connections.iterator();
			while (itCon.hasNext()) {
				Connection currentConnection = itCon.next();

				try {
					currentConnection.close();
					counter++;
				} catch (SQLException e) {
					System.err.println("Couldnt close the current connection");
				}
			}
		}
	}

	/***
	 * Get the one connection pool object
	 * 
	 * @return
	 */
	public synchronized static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
}
