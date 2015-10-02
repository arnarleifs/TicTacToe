import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// Template test runner class - which is used to run the test class <junit_test.java> in our example
public class jUnitTestRunner {
	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(jUnit.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}

// To compile in console use javac >> javac junit_test.java junit_test_runner.java
// To run in console use java >> java junit_test_runner