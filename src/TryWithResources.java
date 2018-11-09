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

		// will throw IOException for auto-closeable resource
		try (FileInputStream fin = new FileInputStream(file)) {
			// do stuff
		} catch (IOException e) { // includes subclass FileNotFoundException

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
}
