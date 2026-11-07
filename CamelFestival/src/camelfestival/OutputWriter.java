package camelfestival;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputWriter {

    public static void writeFile(Camel[] camels, String fileName){
        // TODO/done
        //we did try catch buc if it couldnt write it dosent cruch and the for loop to writes it to tooutputline
        //thats a mathod btw so we dont much here we just call it
        try (PrintWriter write = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < camels.length; i++) {
                write.println(camels[i].toOutputLine());

            }
        } catch (IOException e) {
            System.out.println("CAN NOT WRITE" + fileName);
        }
    }
}
