import java.io.*;

/**
 * This class creates a Python script and executes it first with Runtime and then with ProcessBuilder.
 *
 * @author GHajba
 */
public class OldSchoolCallingPython {

    public static final String FILE_NAME = "testScript.py";

    public static void main(String... args) {
        try {
            createPythonScript();

            String execution = "python " + FILE_NAME + " " + 13 + " " + 1 + " " + 20 + " " + 8;

            Process process1 = Runtime.getRuntime().exec(execution);
            getExecutionResult(process1);
            cleanUp();

            Process process2 = new ProcessBuilder("python", FILE_NAME, "" + 13, "" + 1, "" + 20, "" + 8).start();
            getExecutionResult(process2);
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

    private static void createPythonScript() throws IOException {
        BufferedWriter pythonWriter = new BufferedWriter(new FileWriter(FILE_NAME));
        StringBuilder pythonApplication = new StringBuilder();
        pythonApplication.append("import sys");
        pythonApplication.append("\n");
        pythonApplication.append("sum = 0");
        pythonApplication.append("\n");
        pythonApplication.append("for i in range(1, len(sys.argv)):");
        pythonApplication.append("\n");
        pythonApplication.append("    sum += int(sys.argv[i])");
        pythonApplication.append("\n");
        pythonApplication.append("print(sum)");
        pythonApplication.append("\n");
        pythonWriter.write(pythonApplication.toString());
        pythonWriter.flush();
        pythonWriter.close();
    }
}

