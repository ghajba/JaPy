/**
 * @author GHajba
 */
public class PyJNIusExample {
/*
    public static int addition(Integer... numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }
*/
    public static int addition(int... numbers) {
        int sum = 0;
        for(int i: numbers) {
            sum += i;
        }
        return sum;
    }

/*
    public static String addition(String value) {
        return value;
    }
*/
    public int addNumbers(int a, int b, int c, int d) {
        return a+b+c+d;
    }

    public static void main(String[] args) {
        PyJNIusExample.addition(2);
    }
}
