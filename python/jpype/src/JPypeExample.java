/**
 * @author GHajba
 */
public class JPypeExample {
    public JPypeExample(){}

    public static int addition(Integer... numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }

    public int addNumbers(int a, int b, int c, int d) {
        return a+b+c+d;
    }
}
