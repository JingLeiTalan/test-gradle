import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GradleBuilder {
    public static void main(String[] args) {
        String gradleCommand = "./gradlew clean build --info"; // Replace with your Gradle command
        ProcessBuilder processBuilder = new ProcessBuilder(gradleCommand.split("\\s+"));
        // Optionally, set the working directory for the Gradle process
        processBuilder.environment().put("JAVA_HOME", "/usr/lib/jvm/java-8-openjdk");
        processBuilder.directory(new File("gradle-project"));
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print the output of the Gradle command
            }

            int exitCode = process.waitFor();
            System.out.println("Gradle command exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}