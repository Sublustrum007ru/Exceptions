import util.Validator;
import util.View;

import java.io.BufferedReader;
import java.io.FileReader;

public class Application {
    private final String filePatch = "src/Hello.txt";
    public Validator vl = new Validator();
    public void run() {
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(filePatch));) {
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        start();
    }

    public void start() {
        View view = new View();
        String str = view.prompt("Введите (Фамилью, имя, отчество, дату_рождения, номер_телефона, пол) через пробел: ");
        String[] line1 = vl.scheckLine(str.split(" "));
        for(String test : line1){
            System.out.println(test);
        }
    }
}
