import java.io.File;
import java.io.FileNotFoundException;

class ThrowsExceptionAndDeclare {

	// throws statement indicate method can throw FileNotFoundException or one of it's subclasses
	// we declare it's thrown so an other class needs to handle this exception
	public File readFile(String file) throws FileNotFoundException {

		boolean found = findFile(file);

		if (!found) {
			// if not found throw this checked exception
			throw new FileNotFoundException("File missing");
		} else {
			// do stuff
		}
		return new File("file");
	}

	private boolean findFile(String file) {
		return false;
	}
}

class ThrowsExceptionAndHandle {

	// throws statement indicate method can throw FileNotFoundException or one of it's subclasses
	// we use a try catch and handle it our self
	public File readFile(String filepath) {
		File file = null;
		boolean found = findFile(filepath);

		if (!found) {
			// if not found throw this checked exception
			try {
				throw new FileNotFoundException("File missing");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			file = new File("file");
		}
		return file;
	}

	private boolean findFile(String file) {
		return false;
	}
}

class FileHandler {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new ThrowsExceptionAndDeclare().readFile("bla");

	}
}

class FileHandler2 {
	public static void main(String[] args) {
		File file = new ThrowsExceptionAndHandle().readFile("bla");

	}
}

class FileHandler3 {
	//though it is already handled it won't complain about the throws FileNotFoundException
	public static void main(String[] args) throws FileNotFoundException {
		File file = new ThrowsExceptionAndHandle().readFile("bla");

	}
}