
class ValueToShortException extends Exception {
	public ValueToShortException(String message) {
		super(message);
	}
}

class AutocloseableObject implements AutoCloseable {

	String name;

	public AutocloseableObject() throws Exception {
		System.out.println("Auto-closeable Object created");
		this.name = "aco";
	}

	public AutocloseableObject(String name) throws ValueToShortException {
		if (name.length() <= 3) {
			System.out.println("no valid name, will try throw exception....");
			throw new ValueToShortException("Value to short exception");
		}

		this.name = name;
		System.out.println("Auto-closeable Object created with name");
	}

	@Override
	public void close() throws Exception {
		System.out.println("closing AutoClosableObject");
		throw new Exception(" We like to throw things"); // this one is suppressed! because of automatic resource
															// management in the try()
	}
}

class SuppressedExceptions {
	public static void main(String[] args) {
		try (AutocloseableObject aco = new AutocloseableObject();
				AutocloseableObject aco2 = new AutocloseableObject("uh");) {
			// this won't print it's already closed because of exception on aco2
			System.out.println("name1: " + aco.name + "name2: " + aco2.name);
			// close is implicitly called at end of try...
		} catch (Exception e) {
			System.out.println("--------\ncaught ex: " + e + "\n--------- \nsuppressed:");
			Throwable[] suppressed = e.getSuppressed();
			for (Throwable t : suppressed) {
				System.out.println(t);
			}
		}
	}
}

// Auto-closeable Object created
// no valid name, will try throw exception....
// closing AutoClosableObject
// --------
// caught ex: ValueToShortException: Value to short exception
// ---------
// suppressed:
// java.lang.Exception: We like to throw things