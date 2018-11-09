import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MultiCatch {

	void getConnection(Connection con, String filename) {
		try {
			File file = new File("bla");
			FileInputStream fis = new FileInputStream(file);
			Statement stmt = con.createStatement();
		} catch (IOException | FileNotFoundException | SQLException e) { // won't compile!
			// do somthing else
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	void getConnection2(Connection con, String filename) {
		try {
			File file = new File("bla");
			FileInputStream fis = new FileInputStream(file);
			Statement stmt = con.createStatement();
		} catch (FileNotFoundException f) {
			// do something

		} catch (IOException | SQLException e) { // acceptable though IOException is never thrown
			// do somthing else
		}
	}

	void getConnection3(Connection con, String filename) {
		try {
			File file = new File("bla");
			FileInputStream fis = new FileInputStream(file);
			Statement stmt = con.createStatement();
		} catch (FileNotFoundException | SQLException e) { // acceptable though IOException is never thrown, note only
															// one variable e!
			// do somthing else
		}
	}

	void getConnection4(Connection con, String filename) throws IOException {
		try {
			File file = new File("bla");
			FileInputStream fis = new FileInputStream(file);
			Statement stmt = con.createStatement();
		} catch (FileNotFoundException | SQLException e) { // acceptable though IOException is never thrown, note only
															// one variable e!
			throw new IOException();
		}
	}

	void getConnection5(Connection con, String filename) throws IOException {
		try {
			File file = new File("bla");
			FileInputStream fis = new FileInputStream(file);
			Statement stmt = con.createStatement();
		} catch (IOException | SQLException e) { // acceptable though IOException is never thrown, note only one
													// variable e!
			e = new FileNotFoundException(); // won't compile, e is implicitly final, so can't be reassigned
		}
	}
}

class Exception1 extends IOException {
}

class Exception2 extends Exception {
}

class TestMultiCatch {
	public static void main(String args[]) {
		try {
			int a = 10;
			if (a <= 10)
				throw new Exception1();
			else
				throw new Exception2();
		} catch (Exception1 | Exception2 ex) {
			System.out.println(ex);
		}
	}
}