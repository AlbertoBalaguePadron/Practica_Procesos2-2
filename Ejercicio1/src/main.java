import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        ventanas(5);

    }

    public static  void ventanas(int num){

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        ArrayList<Process> ListProcess = new ArrayList<>();

        try {
            for ( int i = 0; i < num; i++) {
                ListProcess.add(processBuilder.start());
                System.out.println(ListProcess.size());
            }

            for (int i = 1; i < ListProcess.size(); i++) {
                Process process = ListProcess.get(i);

                while (process.isAlive()){
                    process.waitFor();
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}