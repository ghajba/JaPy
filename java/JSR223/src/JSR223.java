import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This class demonstrates how to call Python from Java with JSR-223
 *
 * @author GHajba
 */
public class JSR223 {

    public static void main(String[] args) throws ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("python");
        if(scriptEngine == null) {
            System.err.println("Could not find script engine for python.");
            return;
        }
        int count = 0;
        for(String arg : args) {
            try {
                count++;
                scriptEngine.put("number" + count, new Integer(arg));
            }
            catch (NumberFormatException e) {
                System.err.println(arg + " is not a number!");
                count--;
            }
        }
        scriptEngine.put("sum", 0);
        for(int i = 1; i <= count; i++) {
            scriptEngine.eval(String.format("sum += %s", "number" + i));
        }
        Object sum = scriptEngine.get("sum");
        System.out.println("The result is: " + sum.toString());
    }
}
