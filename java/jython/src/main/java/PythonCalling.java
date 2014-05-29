import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * This class calls a Python script with Jython.
 *
 * @author GHajba
 */
public class PythonCalling {
    public static void main(String... args) {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();

        int count = 0;
        for(String arg : args) {
            try {
                count++;
                pythonInterpreter.set("number" + count, new Integer(arg));
            }
            catch (NumberFormatException e) {
                System.err.println(arg + " is not a number!");
                count--;
            }
        }
        pythonInterpreter.set("sum", 0);
        for(int i = 1; i <= count; i++) {
            pythonInterpreter.exec(String.format("sum += %s", "number"+i));
        }
        PyObject sum = pythonInterpreter.get("sum");
        System.out.println("The result is: " + sum.toString());
    }
}
