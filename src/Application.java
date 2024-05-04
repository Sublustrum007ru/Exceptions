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
        String str = view.prompt("Введите (Фамилью, имя, отчество, дату_рождения, номер_телефона, пол) через пробел: ");
//        String str = "Gusev Anton Sergeevich 31.03.1986 89060884050 m";
        String[] line = vl.scheckLine(str.split(" "));
        User newUser = user.createUser(line);
        if(vl.scheckUser(newUser)){
            try (FileWriter fr = new FileWriter(file.createFileName(user.getFirstName()), true)) {
                fr.write(String.valueOf(user));
                fr.flush();
                System.out.println("Запись добавлена");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Идентичная запись уже существует");
        }

    }

}
