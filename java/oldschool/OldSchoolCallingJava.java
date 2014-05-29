import java.io.*;

/**
 * This class demonstrates a simple Java program creating and writing another Java program
 *
 * @author GHajba
 */
public class OldSchoolCallingJava {
    public static final String FILE_NAME = "TestClass.java";

    public static void main(String... args) {
        try {
            createJavaClass();

            Runtime.getRuntime().exec("javac " + FILE_NAME);
            Process execute1 = Runtime.getRuntime().exec("java TestClass 13 1 20 8");
            getExecutionResult(execute1);
            cleanUp();

            new ProcessBuilder("javac", FILE_NAME).start();
            Process execute2 = new ProcessBuilder("java", "TestClass", "" + 13, "" + 1, "" + 20, "" + 8).start();
            getExecutionResult(execute2);
            cleanUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanUp() {
        new File(FILE_NAME).delete();
    }

    private static void getExecutionResult(Process process1) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
        System.out.println("the result is: " + reader.readLine());
        reader.close();
    }

    private static void createJavaClass() throws IOException {
        BufferedWriter javaWriter = new BufferedWriter(new FileWriter(FILE_NAME));
        StringBuilder javaApplication = new StringBuilder();
        javaApplication.append("public class TestClass {");
        javaApplication.append("\n");
        javaApplication.append("    public static void main(String... args) {");
        javaApplication.append("\n");
        javaApplication.append("        int sum = 0;");
        javaApplication.append("\n");
        javaApplication.append("        for(String arg : args) {");
        javaApplication.append("\n");
        javaApplication.append("            sum += new Integer(arg);");
        javaApplication.append("\n");
        javaApplication.append("        }");
        javaApplication.append("\n");
        javaApplication.append("        System.out.println(sum);");
        javaApplication.append("\n");
        javaApplication.append("    }");
        javaApplication.append("\n");
        javaApplication.append("}");
        javaWriter.write(javaApplication.toString());
        javaWriter.flush();
        javaWriter.close();
    }
}
