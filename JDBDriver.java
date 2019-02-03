JDBCConnection.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static Connection getConnection1() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "victoria", "Kodak123");
		} catch (Exception e) {
			System.out.println("Error in connection" + e);
		}
		return con;
	}

	private void showMenu() {
		int userType;
		int choice;
		boolean quit;

		quit = false;
		Connection con = getConnection1();

		try {
			// disable auto commit mode
			con.setAutoCommit(false);

			System.out.print("Welcome to our Arena!\n");

			System.out.print("\n\nWhat kind of user are you? \n");
			System.out.print("1.  Attendee\n");
			System.out.print("2.  Attraction\n");
			System.out.print("3.  Sponsor\n");
			System.out.print("4.  Employee\n");
			System.out.print("5.  For demo only: all queries in deliverable order\n>>");
			userType = Integer.parseInt(in.readLine());

			while (!quit) {

				// also we need TYPE CHECKING when we are getting user input!!!!!
				// we can group these in ways that make more sense later.

				// need error handling for duplicate key

				// Deliverables from Formal Project Specification

				if (userType == 1) {
					// event attendees
					// deliverable 2
					System.out.print("1.  Create (insert) a new event attendee\n");
					// deliverable 4
					System.out.print("2.  Update credit card information\n");
					System.out.print("3.  Purchase a ticket\n");
					// deliverable 10, select attractions by their genres/sport
					System.out.print("4.  View (select) all available attractions of a given genre\n");
					// deliverable 11, create view
					System.out.print("5.  View concerts occuring within the next month (view)\n");
					// deliverable 6, 2 table join
					System.out.print("6.  View eventID based off genre (join)\n");
					System.out.print("7.  Quit\n>> ");

					choice = Integer.parseInt(in.readLine());

					System.out.println(" ");

					switch (choice) {
					case 1:
						CustomerQueries.insertNewAttendee();
						break;
					case 2:
						CustomerQueries.updateAttendee();
						break;
					case 3:
						CustomerQueries.purchaseTicket();
						break;
					case 4:
						CustomerQueries.viewAvailableAttractions();
						break;
					case 5:
						CustomerQueries.createNextMonthView();
						CustomerQueries.viewNextMonthEvents();
						break;
					case 6:
						EmployeeQueries.getEventsFromGenre();
						break;
					case 7:
						quit = true;
					}
				}

				if (userType == 2) {
					// attractions
					// deliverable 3
					System.out.print("1.  Create (insert) an event booking\n");
					System.out.print("2.  Cancel (delete) an EVENT BOOKING by ID\n");
					// deliverable 7, group by gender and age
					System.out.print("3.  View demographic (AVG age and gender) statistics of attendees\n");
					System.out.print("4.  Quit\n>> ");

					choice = Integer.parseInt(in.readLine());

					System.out.println(" ");

					switch (choice) {
					case 1:
						CustomerQueries.createEventBooking();
						break;
					case 2:
						CustomerQueries.cancelEventBooking();
						break;
					case 3:
						CustomerQueries.viewDemographicStatistics();
						break;
					case 4:
						quit = true;
					}
				}

				if (userType == 3) {
					// sponsors
					System.out.print("1.  Sponsor a sporting event\n");
					System.out.print("2.  Sponsor a concert event\n");
					// deliverable 7, group by gender and age
					System.out.print("3.  View demographic (AVG age and gender) statistics of attendees\n");
					// deliverable 10, group attractions by their genres/sport
					System.out.print("4.  View (select) all available attractions of a given genre/sport\n");
					System.out.print("5.  Quit\n>> ");

					choice = Integer.parseInt(in.readLine());

					System.out.println(" ");

					switch (choice) {
					case 1:
						SponsorQueries.insertSportingEventSponsor();
						break;
					case 2:
						SponsorQueries.insertConcertEventSponsor();
						break;
					case 3:
						CustomerQueries.viewDemographicStatistics();
						break;
					case 4:
						CustomerQueries.viewAvailableAttractions();
						break;
					case 5:
						quit = true;
					}
				}

				if (userType == 4) {
					// employees
					// deliverable 2
					System.out.print("1.  Create (insert) a new sporting EVENT\n");
					System.out.print("2.  Create (insert) a new concert EVENT\n");
					// deliverable 3
					System.out.print("3.  Cancel (delete) a sporting event by ID\n");
					System.out.print("4.  Cancel (delete) a concert event by ID\n");
					// deliverable 6, 2 table join
					System.out.print("5.  View eventID based off genre (join)\n");
					// deliverable 7, group by gender and age
					System.out.print("6.  View demographic (AVG age and gender) statistics of attendees\n");
					// deliverable 8, update the date of a concert
					System.out.print("7.  Update the date of a concert\n");
					System.out.print("8.  Update the date of a sporting event\n");
					// deliverable 9, additional query, view events scheduled to work for
					System.out.print("9.  View (select) events you are scheduled to work for\n");
					// deliverable 5, 3 table join
					System.out.print("10.  View Employee names working at a specific event (join)\n");
					System.out.print("11.  Quit\n>> ");

					choice = Integer.parseInt(in.readLine());

					System.out.println(" ");

					switch (choice) {
					case 1:
						EmployeeQueries.insertNewSportingEvent();
						break;
					case 2:
						EmployeeQueries.insertNewConcertEvent();
						break;
					case 3:
						EmployeeQueries.deleteSportingEvent();
						break;
					case 4:
						EmployeeQueries.deleteConcertEvent();
						break;
					case 5:
						EmployeeQueries.getEventsFromGenre();
						break;
					case 6:
						CustomerQueries.viewDemographicStatistics();
						break;
					case 7:
						EmployeeQueries.updateConcertEvent();
						break;
					case 8:
						EmployeeQueries.updateSportingEvent();
						break;
					case 9:
						EmployeeQueries.viewSchedule();
						break;
					case 10:
						EmployeeQueries.seeEmployeesWorkingAtEvent();
						break;
					case 11:
						quit = true;
					}
				}
				if (userType == 5) {
					System.out.print("**Note that these are not all are queries\n");
					//System.out.print("Deliverable 1:\n");
					System.out.print("Deliverable 2: Create (insert) a new event attendee\n");
					System.out.print("Deliverable 3: Cancel (delete) a sporting event by ID\n");
					System.out.print("Deliverable 4: Update credit card information\n");
					System.out.print("Deliverable 5: View Employee names working at a specific event (join)\n");
					System.out.print("Deliverable 6: View eventID based off genre (join)\n");
					System.out.print("Deliverable 7: View demographic (AVG age and gender) statistics of attendees\n");
					System.out.print("Deliverable 8: Update the date of a concert\n");
					System.out.print("Deliverable 9: View (select) events you are scheduled to work for\n");
					System.out.print("Deliverable 10: View (select) all available attractions grouped by a given genre\n");
					System.out.print("Deliverable 11: View concerts occuring within the next month (view)\n");
					System.out.print("Quit\n>> ");

					choice = Integer.parseInt(in.readLine());

					System.out.println(" ");

					switch (choice) {
					case 1:
						CustomerQueries.insertNewAttendee();
						break;
					case 2:
						CustomerQueries.insertNewAttendee();
						break;
					case 3:
						EmployeeQueries.deleteSportingEvent();
						break;
					case 4:
						CustomerQueries.updateAttendee();
						break;
					case 5:
						EmployeeQueries.seeEmployeesWorkingAtEvent();
						break;
					case 6:
						EmployeeQueries.getEventsFromGenre();
						break;
					case 7:
						CustomerQueries.viewDemographicStatistics();
						break;
					case 8:
						EmployeeQueries.updateConcertEvent();
						break;
					case 9:
						EmployeeQueries.viewSchedule();
						break;
					case 10:
						CustomerQueries.viewAvailableAttractions();
						break;
					case 11:
						CustomerQueries.createNextMonthView();
						CustomerQueries.viewNextMonthEvents();
						break;
					case 12:
						quit = true;
					}
				}
			}

			con.close();
			in.close();
			System.out.println("\nThanks for stopping by the Arena!\n\n");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("IOException!");

			try {
				con.close();
				System.exit(-1);
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
		}
	}

	public static void main(String[] args) {
		new JDBCConnection().showMenu();
	}

}

CustomerQueries.java
import java.sql.Statement;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CustomerQueries {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void insertNewAttendee() throws SQLException {
		int creditCardNum;
		int age;
		String gender;
		String name;
		String email;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("INSERT INTO attendee VALUES (?,?,?,?,?,?,?)");
			// for insertion, need to make sure that this primary key isnt taken -> how to
			// do
			// also how to handle char vs string? do we need to make char array?
			// also need to implement type checking for insertion and update
			System.out.print("\nName: ");
			name = in.readLine();
			ps.setString(1, name);

			System.out.print("\nEmail: ");
			email = in.readLine();
			ps.setString(2, email);

			// total points gets default to 0
			ps.setInt(3, 0);

			System.out.print("\nCredit card #: ");
			creditCardNum = Integer.parseInt(in.readLine());
			ps.setInt(4, creditCardNum);

			// ticket amount default to zero
			ps.setInt(5, 0);

			System.out.print("\nAge: ");
			age = Integer.parseInt(in.readLine());
			ps.setInt(6, age);

			System.out.print("\nGender: "); //
			gender = in.readLine();
			ps.setString(7, gender);

			// String phoneTemp = in.readLine();
			// if (phoneTemp.length() == 0) {
			// ps.setNull(5, java.sql.Types.INTEGER);
			// } else {
			// bphone = Integer.parseInt(phoneTemp);
			// ps.setInt(5, bphone);
			// }

			ps.executeUpdate();
			System.out.println("New user inserted.");
			System.out.println();

			// commit work
			con.commit();

			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// adds a record to the table willAttend (relationship btwn ticket, attendee,
	// and event) and then calls buyTicket which inserts to the ticket table
	public static void purchaseTicket() throws SQLException {
		int eventID;
		int seatNum;
		int sectionNum;
		String name;
		String email;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("INSERT INTO willAttend VALUES (?,?,?,?,?)");
			// for insertion, need to make sure that this primary key isnt taken -> how to
			// do
			// also how to handle char vs string? do we need to make char array?
			// also need to implement type checking for insertion and update
			System.out.print("\nName: ");
			name = in.readLine();
			ps.setString(1, name);

			System.out.print("\nEmail: ");
			email = in.readLine();
			ps.setString(2, email);

			System.out.print("\nSection number #: ");
			sectionNum = Integer.parseInt(in.readLine());
			ps.setInt(3, sectionNum);

			System.out.print("\nSeat number #: ");
			seatNum = Integer.parseInt(in.readLine());
			ps.setInt(4, seatNum);

			// TODO need a way to check event ID is valid
			System.out.print("\nEvent ID: ");
			eventID = Integer.parseInt(in.readLine());

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = st
					.executeQuery("select attractionid from eventattractions" + " where eventid = " + eventID);

			res.next();
			int attractionID = res.getInt(1);
			buyTicket(sectionNum, seatNum, name, email, eventID, attractionID);

			ps.setInt(5, eventID);

			ps.executeUpdate();

			con.commit();

			ps.close();

			System.out.println("Ticket purchased");

		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("User or event does not exist: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("User or event does not exist: " + ex2.getMessage());
				System.exit(-1);
			}
		} catch (Exception e) {
			System.out.println("Please make sure input values are correct!");
		}
	}

	// adds purchase to the ticket table
	public static void buyTicket(int secNum, int seatNum, String name, String email, int eventID, int attractionID)
			throws SQLException {
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		Date today = new Date(Calendar.getInstance().getTime().getTime());
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("INSERT INTO verifiedTicket VALUES (?,?,?,?,?,?,?,?,?)");
			// for insertion, need to make sure that this primary key isnt taken -> how to
			// do
			ps.setInt(1, secNum);
			ps.setInt(2, seatNum);
			// set default price as $100
			ps.setInt(3, 100);
			// set todays date
			ps.setDate(4, today);

			// not verified yet
			ps.setBoolean(5, false);
			// default to 100 points
			ps.setInt(6, 100);
			ps.setString(7, email);
			ps.setString(8, name);
			ps.setInt(9, attractionID);

			ps.executeUpdate();

			// commit work
			con.commit();

			ps.close();

		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// can update credit card
	public static void updateAttendee() throws SQLException {
		int cardnum;
		String name;
		String email;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			System.out.print("\nName: ");
			name = in.readLine();

			System.out.print("\nEmail: ");
			email = in.readLine();

			System.out.print("\nNew card number: ");
			cardnum = Integer.parseInt(in.readLine());

			ps = con.prepareStatement("UPDATE attendee SET creditcard# = " + cardnum + " WHERE name = '" + name
					+ "' and email = '" + email + "'");

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println("\nUser does not exist!");
			} else
				System.out.println("\nCredit card info upated.");

			con.commit();

			System.out.println("");

			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());

			try {
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	public static void viewAvailableAttractions() {

		String genre;

		try {
			Connection con = JDBCConnection.getConnection1();
			PreparedStatement ps;
			ps = con.prepareStatement("select groupName from attraction4 where genre = ?");

			System.out.print("\nGenre (Pop, Retro, Indie, Rap): ");
			genre = in.readLine();

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = st.executeQuery("select attractionName from attraction where genre = '" + genre + "'");
			// TODO error checking here if result set is empty

			while (res.next()) {
				// this number needs to be switched to whatever the name column is
				System.out.println(res.getString(1) + "   ");
			}
			res.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	public static void createNextMonthView() throws SQLException {

		Calendar oneMonth = Calendar.getInstance();
		oneMonth.add(Calendar.MONTH, 1);
		Date today = new Date(Calendar.getInstance().getTime().getTime());
		Date nextMonth = new Date(oneMonth.getTime().getTime());
		PreparedStatement ps;
		PreparedStatement drop;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			try {
				drop = con.prepareStatement("drop view nextMonthEvent");
				drop.executeQuery();
				con.commit();
				drop.close();
			} catch (Exception e) {
				// if we can't drop it thats fine
			}

			// need to drop next month event and commit that
			ps = con.prepareStatement(
					"create view nextMonthEvent as " + "select eventName, eventID from concert where performancedate>'"
							+ today + "'and performancedate<'" + nextMonth + "'");

			ps.executeUpdate();

			// commit work
			con.commit();

			ps.close();

		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	public static void viewNextMonthEvents() {

		try {
			Connection con = JDBCConnection.getConnection1();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = st.executeQuery("select * from nextMonthEvent");
			System.out.println("Events happening next month:");
			while (res.next()) {
				System.out.println(res.getString(1));
			}
			res.close();
			con.close();
			System.out.println("");
		} catch (Exception e) {
			System.out.println("Error in fetching data" + e);
		}
	}

	public static void createEventBooking() throws SQLException {
		int attractionID;
		int eventID;
		int price;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("INSERT INTO books VALUES (?,?,?)");
			// are we supposed to generate our own event id here or what
			System.out.print("\nAttraction ID: ");
			attractionID = Integer.parseInt(in.readLine());
			ps.setInt(1, attractionID);

			System.out.print("\nEvent ID: ");
			eventID = Integer.parseInt(in.readLine());
			ps.setInt(2, eventID);

			// for price, for now we'll simulate a scheme by
			// using a random number generator that goes between $1000-$5000 dollars
			price = ThreadLocalRandom.current().nextInt(1000, 5001);
			ps.setInt(3, price);

			ps.executeUpdate();
			// commit work
			con.commit();
			System.out.println("Booking created.");
			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	public static void cancelEventBooking() throws SQLException {
		int eventID;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("DELETE FROM books where eventID = ?");

			System.out.print("\nEvent ID: ");
			eventID = Integer.parseInt(in.readLine());
			ps.setInt(1, eventID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println("\nBooking does not exist!");
			} else
				System.out.println("\nBooking cancelled.");

			// commit work
			con.commit();

			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// group by gender and age from attendee
	// added those to table to do this
	public static void viewDemographicStatistics() {
		try {
			Connection con = JDBCConnection.getConnection1();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = st.executeQuery("select gender, avg(age) from attendee group by gender");
			ResultSetMetaData rsmd = res.getMetaData();

			// get number of columns
			int numCols = rsmd.getColumnCount();

			System.out.println(" ");

			// display column names;
			for (int i = 0; i < numCols; i++) {
				// get column name and print it

				System.out.printf("%-15s", rsmd.getColumnName(i + 1));
			}

			System.out.println(" ");

			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.println(res.getInt(2));
			}
			res.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error in fetching data" + e);
		}
	}
}

EmployeeQueries.java
import java.sql.Statement;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class EmployeeQueries {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// deliverable 2
	// TODO: add to JDBCConnection.java
	// SportingEvent(eventID: INTEGER, capacity: INTEGER, ticketsSold: INTEGER,
	// date: DATE,
	// sponsorPrice: INTEGER, sponsorID: INTEGER, homeTeamID: INTEGER, awayTeamID:
	// INTEGER, employeeID: INTEGER)
	public static void insertNewSportingEvent() throws SQLException {
		int eventID;
		int homeTeamID;
		int awayTeamID;
		String date;
		String eventName;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("INSERT INTO sport VALUES (?,?,?,?,?)");

			System.out.println("Event ID: ");
			eventID = Integer.parseInt(in.readLine());
			ps.setInt(1, eventID);

			System.out.println("Event name: ");
			eventName = in.readLine();
			ps.setString(2, eventName);

			System.out.println("Home Team ID: ");
			homeTeamID = Integer.parseInt(in.readLine());
			ps.setInt(3, homeTeamID);

			System.out.println("Away Team ID: ");
			awayTeamID = Integer.parseInt(in.readLine());
			ps.setInt(4, awayTeamID);

			System.out.println("Date: YY-MM-DD: ");
			date = in.readLine();
			ps.setString(5, date);

			/*
			 * System.out.print("\nEvent Capacity: "); capacity =
			 * Integer.parseInt(in.readLine()); ps.setInt(5, capacity);
			 */

			// default value of tickets sold so far is set to 0
			// ps.setInt(6, ticketsSold);

			// ps = con.prepareStatement("INSERT INTO sport VALUES " + eventID + homeTeamID
			// + awayTeamID + date + capacity);
			ps.executeUpdate();

			// commit work
			con.commit();
			System.out.println("Event inserted.");
			ps.close();

		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// deliverable 2
	// TODO: add additional query case to JDBCConnection.java to handle different
	// event types
	public static void insertNewConcertEvent() throws SQLException {
		int eventID;
		String date;
		String eventName;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			ps = con.prepareStatement("INSERT INTO concert VALUES (?,?,?)");

			System.out.print("\nEvent ID: ");
			eventID = Integer.parseInt(in.readLine());
			ps.setInt(1, eventID);

			System.out.println("Event name: ");
			eventName = in.readLine();
			ps.setString(2, eventName);

			System.out.println("Date: YY-MM-DD: ");
			date = in.readLine();
			ps.setString(3, date);

			/*
			 * System.out.print("\nEvent Capacity: "); capacity =
			 * Integer.parseInt(in.readLine());
			 */
			// ps.setInt(3, sectionNum);

			// default value of tickets sold so far is set to 0
			// ps.setInt(4, ticketsSold);

			// ps = con.prepareStatement("INSERT INTO concert VALUES " + eventID + date +
			// capacity);
			ps.executeUpdate();

			// commit work
			con.commit();
			System.out.println("Event inserted.");
			ps.close();

		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// TODO: add additional query case in JDBCConnection.java to handle the two
	// event types
	public static void deleteSportingEvent() throws SQLException {
		int eventID;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);
		try {

			System.out.print("\nSporting Event ID: ");
			eventID = Integer.parseInt(in.readLine());
			// ps.setInt(1, eventID);

			ps = con.prepareStatement("DELETE FROM sport where eventID = " + eventID);
			
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println("\nEvent does not exist!");
			} else
				System.out.println("Event deleted!");
			con.commit();
			

			// commit work
			con.commit();
			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	public static void deleteConcertEvent() throws SQLException {
		int eventID;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);
		try {

			System.out.print("\nConcert Event ID: ");
			eventID = Integer.parseInt(in.readLine());
			// ps.setInt(1, eventID);

			ps = con.prepareStatement("DELETE FROM concert where eventID = " + eventID);
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println("\nEvent does not exist!");
			} else
				System.out.println("Event deleted!");

			// commit work
			con.commit();
			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());
			try {
				// undo the insert
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// deliverable 6, two-table join between attraction and concert
	// get the eventID of events based off their genre
	public static void getEventsFromGenre() throws SQLException {

		String genre;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);
		try {
			// can also just figure out this statment just by testing w db
			System.out.print("\nPick a genre (Pop, Retro, Indie, Rap): ");
			genre = in.readLine();

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			/*
			 * ResultSet res = st.executeQuery("SELECT Count(*) FROM attendee a" +
			 * "INNER JOIN employee e on e.email = a.email" + "WHERE e.employeeID = " +
			 * employeeID);
			 */
			ResultSet res = st.executeQuery("SELECT eventID FROM concert c "
					+ "INNER JOIN attraction a on a.attractionName = c.eventName " + "WHERE a.genre = '" + genre + "'");

			System.out.println(" ");

			// need to adjust number of stuff printed out here
			while (res.next()) {
				System.out.println(res.getString(1));
			}
			
			System.out.println(" ");

			res.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());

			try {
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	// deliverable 8, update the date of an event
	public static void updateConcertEvent() throws SQLException {
		int eventID;
		String date;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {

			System.out.print("\nEvent ID: ");
			eventID = Integer.parseInt(in.readLine());
			// ps.setString(3, eventID);

			System.out.println("New Date: YY-MM-DD: ");
			date = in.readLine();
			// ps.setString(5, date);

			ps = con.prepareStatement("UPDATE concert SET performancedate = '" + date + "' WHERE eventID = " + eventID);
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println("\nEvent does not exist!");
			} else
				System.out.println("Date changed!");
			con.commit();

			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());

			try {
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	public static void updateSportingEvent() throws SQLException {
		int eventID;
		String date;
		PreparedStatement ps;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);
		try {

			System.out.print("\nEvent ID: ");
			eventID = Integer.parseInt(in.readLine());
			// ps.setString(3, eventID);

			System.out.println("New Date: YY-MM-DD: ");
			date = in.readLine();
			// ps.setString(5, date);

			ps = con.prepareStatement("UPDATE sport SET matchdate = '" + date + "' WHERE eventID = " + eventID);
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println("\nEvent does not exist!");
			} else
				System.out.println("Date changed!");
			con.commit();

			ps.close();
		} catch (IOException e) {
			System.out.println("IOException!");
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());

			try {
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

	/*
	 * // GROUP BY statement on Facilitates table to group all the employees by
	 * their specific roles such as security and sales public static void
	 * viewEmployees() { try { Connection con = JDBCConnection.getConnection1();
	 * Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); ResultSet res =
	 * st.executeQuery("SELECT employeeID, eventID FROM facilitates GROUP BY role");
	 * ResultSetMetaData rsmd = res.getMetaData();
	 * 
	 * // get number of columns int numCols = rsmd.getColumnCount();
	 * 
	 * System.out.println(" ");
	 * 
	 * // display column names; for (int i = 0; i < numCols; i++) { // get column
	 * name and print it
	 * 
	 * System.out.printf("%-15s", rsmd.getColumnName(i + 1)); }
	 * 
	 * System.out.println(" ");
	 * 
	 * while (res.next()) { System.out.print(res.getString(1) + "   ");
	 * System.out.print(res.getString(2) + "   "); System.out.print(res.getString(3)
	 * + "   "); System.out.print(res.getString(5) + "   ");
	 * System.out.print(res.getString(6) + "   ");
	 * System.out.println(res.getString(7) + "   "); } res.close(); con.close(); }
	 * catch (Exception e) { System.out.println("Error in fetching data" + e); } }
	 */

	// view events you are scheduled to work for
	public static void viewSchedule() throws SQLException {
		int employeeID;
		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);

		try {
			System.out.print("\nEmployee ID: ");
			employeeID = Integer.parseInt(in.readLine());
			// ps.setString(1, employeeID);

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = st.executeQuery("SELECT eventID FROM facilitates WHERE employeeID = " + employeeID);
			
			if (!res.isBeforeFirst() ) {    
				System.out.println("Not a valid employeeID"); 
			}

			while (res.next()) {
				System.out.println(res.getString(1));
			}
			System.out.println();
			res.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Please make sure you have entered a valid ID" + e);
		}

	}

	// joins employee with facilitates with concert
	public static void seeEmployeesWorkingAtEvent() throws SQLException, NumberFormatException, IOException {

		Connection con = JDBCConnection.getConnection1();
		con.setAutoCommit(false);
		int eventID;

		try {
			// can also just figure out this statement just by testing w db
			// join employee w facilitates with concert
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			/*
			 * ResultSet res = st.
			 * executeQuery("SELECT attractionName, Count(*) FROM attraction a, verifiedTicket t "
			 * + "INNER JOIN attraction a on t.attractionID = a.attractionID " +
			 * "INNER JOIN attendee b on t.purchaserEmail = b.email " + "WHERE a.genre = '"
			 * + genre + "'");); ResultSetMetaData rsmd = res.getMetaData();
			 */

			System.out.print("\nConcert Event ID: ");
			eventID = Integer.parseInt(in.readLine());

			ResultSet res = st.executeQuery(
					"SELECT name FROM employee e " + "INNER JOIN facilitates f on e.employeeID = f.employeeID "
							+ "INNER JOIN concert c on f.eventID = c.eventID " + "WHERE c.eventID = '" + eventID + "'");
			ResultSetMetaData rsmd = res.getMetaData();
			
			if (!res.isBeforeFirst() ) {    
				System.out.println("Not a valid EventID"); 
				return;
			}

			// get number of columns
			int numCols = rsmd.getColumnCount();

			System.out.println(" ");

			// display column names;
			for (int i = 0; i < numCols; i++) {
				// get column name and print it

				System.out.printf("%-15s", rsmd.getColumnName(i + 1));
			}

			System.out.println(" ");

			// need to adjust number of stuff printed out here
			while (res.next()) {
				System.out.println(res.getString(1));
			}
			
			System.out.println(" ");

			res.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println("Message: " + ex.getMessage());

			try {
				con.rollback();
			} catch (SQLException ex2) {
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}
}

SponsorQueries.java
import java.sql.Statement;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SponsorQueries {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	//inserts new Sponsor for sporting event
	public static void insertSportingEventSponsor() throws SQLException {
        int sid;
        int eventID;
        PreparedStatement ps;
        Connection con = JDBCConnection.getConnection1();
        con.setAutoCommit(false);

		try {
            ps = con.prepareStatement("INSERT INTO sponsorssportingevent VALUES (?, ?)");
            // for insertion, need to make sure that this primary key isnt taken -> how to
            // do
            // also how to handle char vs string? do we need to make char array?
            // also need to implement type checking for insertion and update
            System.out.print("\nSponsor ID: ");
            sid = Integer.parseInt(in.readLine());
            ps.setInt(1, sid);

            System.out.print("\nEvent ID for the event you would like to sponsor: ");
            eventID = Integer.parseInt(in.readLine());
            ps.setInt(2, eventID);

            ps.executeUpdate();

            // commit work
            con.commit();

            ps.close();
            System.out.println("\nSponsorship created.");

        } catch (IOException e) {
            System.out.println("IOException!");
        } catch (SQLException ex) {
            System.out.println("EventID does not exist: " + ex.getMessage());
            try {
                // undo the insert
                con.rollback();
            } catch (SQLException ex2) {
                System.out.println("EventID does not exist: " + ex2.getMessage());
                System.exit(-1);
            }
        }
		catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
	}

    //inserts new Sponsor for concert event
    public static void insertConcertEventSponsor() throws SQLException {
        int sid;
        int eventID;
        PreparedStatement ps;
        Connection con = JDBCConnection.getConnection1();
        con.setAutoCommit(false);

        try {
            ps = con.prepareStatement("INSERT INTO sponsorsconcertevent VALUES (?, ?)");
            // for insertion, need to make sure that this primary key isnt taken -> how to
            // do
            // also how to handle char vs string? do we need to make char array?
            // also need to implement type checking for insertion and update
            System.out.print("\nSponsor ID: ");
            sid = Integer.parseInt(in.readLine());
            ps.setInt(1, sid);

            System.out.print("\nEvent ID for the event you would like to sponsor: ");
            eventID = Integer.parseInt(in.readLine());
            ps.setInt(2, eventID);

            ps.executeUpdate();

            // commit work
            con.commit();

            ps.close();
            System.out.println("\nSponsorship created.");
            // should we add sponsorPrice to concert and sport tables?

        } catch (IOException e) {
            System.out.println("IOException!");
        } catch (SQLException ex) {
            System.out.println("EventID does not exist: " + ex.getMessage());
            try {
                // undo the insert
                con.rollback();
            } catch (SQLException ex2) {
                System.out.println("EventID does not exist: " + ex2.getMessage());
                System.exit(-1);
            }
        }
        catch (Exception e) {
			System.out.println("Please make sure input values are correct!" + e);
		}
    }


	public static void viewAvailableAttractions() {

		String genre;

		try {
			Connection con = JDBCConnection.getConnection1();
			PreparedStatement ps;
			ps = con.prepareStatement("select groupName from attraction4 where genre = ?");

			System.out.print("\nGenre/sport: ");
			genre = in.readLine();

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet res = st.executeQuery("select genre from attraction4 where genre = " + genre);
			ResultSetMetaData rsmd = res.getMetaData();
			// TODO error checking here if result set is empty

			// get number of columns
			int numCols = rsmd.getColumnCount();

			System.out.println(" ");

			// display column names;
			for (int i = 0; i < numCols; i++) {
				// get column name and print it
				System.out.printf("%-15s", rsmd.getColumnName(i + 1));
			}

			System.out.println(" ");

			while (res.next()) {
				// this number needs to be switched to whatever the name column is
				System.out.print(res.getString(1) + "   ");
			}
			res.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error in fetching data" + e);
		}
	}
}






