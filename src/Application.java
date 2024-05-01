import model.User;
import model.repository.impl.FileOperation;
import util.Validator;
import util.View;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

public class Application{
    private final String filePatch = "src/Hello.txt";
    private final FileOperation filename = new FileOperation();
    public Validator vl = new Validator();

    public void run() throws ParseException {
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

    public void start() throws ParseException {
        View view = new View();
        String str = view.prompt("Введите (Фамилью, имя, отчество, дату_рождения, номер_телефона, пол) через пробел: ");
        String[] line1 = vl.scheckLine(str.split(" "));
        User user = new User(line1[0], line1[1], line1[2], vl.isDate(line1[3]), vl.isNumeric(line1[4]), line1[5]);
        try(FileWriter fr = new FileWriter(filename.createFileName(line1[0]), true)){
            fr.write(String.valueOf(user));
            fr.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
