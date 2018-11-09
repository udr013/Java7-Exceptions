import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {

	void readFileContents(String fileName) {
		File file = new File(fileName);

		// will throw IOException for auto-closeable resource but now declared on method also
		// no catch or finally block which is required by a regular try-catch block!
		try (FileInputStream fin = new FileInputStream(file)) { // won't compile, IOException not handled
			// do stuff
		} catch (FileNotFoundException e) { // subclass of IOException, so this one could be omitted
			//
		}
	}

	void readFileContent2(String fileName) {
		File file = new File(fileName);

		// will throw IOException for auto-closeable resource
		try (FileInputStream fin = new FileInputStream(file)) { // and FileNotFoundException for FileInputStream
			// do stuff
		} catch (FileNotFoundException e) { // subclass of IOException, so this one could be omitted
			//
		} catch (IOException e) {

		}
	}

	void readFileContents3(String fileName) {
		File file = new File(fileName);

		// multiple resources can be added seperated with a semicolon " ; "
		try (FileInputStream fin = new FileInputStream(file); FileInputStream fin1 = new FileInputStream(file)) {
			// do stuff
		} catch (IOException e) { // includes subclass FileNotFoundException
			System.out.println(fin.read()); // fin is not available anymore, implicit close in try
		}
	}

	void readFileContents4(String fileName) throws IOException {
		File file = new File(fileName);

		// will throw IOException for auto-closeable resource but now declared on method also
		// no catch or finally block which is required by a regular try-catch block!
		try (FileInputStream fin = new FileInputStream(file)) {
			// do stuff
		}
	}

	void readFileContents5(String fileName) throws IOException {
		File file = new File(fileName);

		try (FileInputStream fin) { //won't compile! needs to be initialized implicitly final
			// do stuff
		}
	}

	void readFileContents6(String fileName) throws IOException {
		File file = new File(fileName);

		try (FileInputStream fin = null) { // acceptable, though implicitly final
			// do stuff
			fin.read();// nullpointer
			fin = new FileInputStream(file); // won't compile fin is final!
		}
	}
}
