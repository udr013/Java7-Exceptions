import java.io.FileNotFoundException;
import java.io.IOException;

class BaseClass {
	public void aMethod() throws IOException {
	}

	public void bMethod() throws NullPointerException {
	}
}

class Someclass extends BaseClass {
	@Override
	public void aMethod() throws Exception {
	} // this won't compile! superclass

	@Override
	public void bMethod() {
		super.bMethod();
	}
}

class Someclass2 extends BaseClass {
	@Override
	public void aMethod() throws FileNotFoundException {
	}// more specific

	@Override
	public void bMethod() throws RuntimeException {
	}
}

class Someclass3 extends BaseClass {
	@Override
	public void aMethod() { // all solved
	}

	@Override
	public void bMethod() throws Error {
		super.bMethod();
	}
}

class BaseClass2 {
	public void aMethod() {
	}
}

class Someclass4 extends BaseClass2 {
	@Override
	public void aMethod() throws Exception { // this won't compile! not allowed
		//
	}
}
