import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(AllTests.class);
        for (Failure failure : result.getFailures())
            System.out.println(failure.toString());
        System.out.println(result.getRunCount() +" Tests");
        if (result.wasSuccessful())
            System.out.println("No Problemo!");
        else System.out.println("Oops! Some tests have failed.");
    }

}
