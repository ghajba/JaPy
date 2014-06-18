/**
 * @author GHajba
 */
public class JythonExample {

    public static int addition(Integer... numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }

    public static int addition(String value) {
        return value.hashCode();
    }

    public int addNumbers(int a, int b, int c, int d) {
        return a+b+c+d;
    }
}

