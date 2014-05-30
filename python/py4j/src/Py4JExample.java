import py4j.GatewayServer;

/**
 * This is an example class using Py4J.
 *
 * @author GHajba
 */
public class Py4JExample {

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new Py4JExample());
        gatewayServer.start();
    }

    public int addNumbers(int... numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }
}
