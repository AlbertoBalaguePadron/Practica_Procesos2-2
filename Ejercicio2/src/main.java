import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args){

        ventanas(3);

    }

    public static  void ventanas(int num){

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        ArrayList<Process> ListaProcessos = new ArrayList<>();

        try {
            for ( int i = 0; i < num; i++) {
                ListaProcessos.add(processBuilder.start());
            }

            for (int i = 0; i < ListaProcessos.size(); i++) {
                Process process = ListaProcessos.get(i);

                while (process.isAlive()){

                    process.waitFor();

                }

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}