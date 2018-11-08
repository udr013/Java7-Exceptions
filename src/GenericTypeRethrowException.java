import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

 class GenericTypeRethrowException {

	public void method() throws IOException, SQLException, NullPointerException {
		try {
			// do funky stuff
		} catch (Exception e) {
			throw e;  // no problem will just rethrow
		}

	}
}

 class GenericTypeRethrowException2 {

	public void method() throws IOException, SQLException {
		try {
			// do funky stuff
		} catch (Exception e) {
			throw  new Exception();  // <- won't compile superclass of  IOException, SQLException
		}

	}
}

class GenericTypeRethrowException3 {

	public void method() throws IOException, SQLException {
		try {
			throw new FileNotFoundException();

			// do funky stuff
		} catch (FileNotFoundException e) { // subclass of IOException
			throw  e;
		} 
		
	}

}

class GenericTypeRethrowException4 {

	public void method() throws IOException, SQLException {
		try {
			// do funky stuff
		} catch (FileNotFoundException e) { // won't compile CHECKED exception is never thrown!
			throw  e;
		}

	}

}
