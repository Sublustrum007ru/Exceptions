import model.User;
import model.repository.impl.FileOperation;
import util.Validator;
import util.View;

import java.io.*;
import java.text.ParseException;

public class Application {

    private final String filePatch = "src/Hello.txt";

    private final FileOperation file = new FileOperation();
    private final User user = new User();

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
//        String str = view.prompt("Введите (Фамилью, имя, отчество, дату_рождения, номер_телефона, пол) через пробел: ");
        String str = "Gusev Antosha Sergeevich 31.03.1986 89060884050 m";
        String[] line1 = vl.scheckLine(str.split(" "));
        user.setFirstName(vl.isAlpha(line1[0], "F"));
        user.setLastName(vl.isAlpha(line1[1], "L"));
        user.setSurname(vl.isAlpha(line1[2], "S"));
        user.setBirthDate(vl.isDate(line1[3]));
        user.setPhone(vl.isNumeric(line1[4]));
        user.setGender(vl.isGender(line1[5].toLowerCase()));
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(file.createFileName(user.getFirstName())))) {
            while ((line = in.readLine()) != null) {
                String tempUser = user.toString();
                System.out.println("if(" + line + " != " + tempUser + ")");
                if(tempUser != line) {
                    System.out.println("Good luck");
                }else{
                    System.out.println("Bad");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
