import java.sql.Connection;

class MyCustomException extends Exception {
}

class CatchMultiExceptions {
	void myMethod(Connection con, String fileName) {
		try {
			// code   -> Code that might throw MyCustomException, FileNotFoundException or SQLException
		} catch (Exception e) {
			/*oops, Catch all types of checked AND RUNTIME exceptions!
			it might be hard to debug or same error message is returned, like file not found
			though it could be an SQLException or some runtime exception
			better use multiple catch blocks!
			 */

		}
	}
}