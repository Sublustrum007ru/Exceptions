package util;

import model.User;
import model.repository.impl.FileOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Validator {

    private View view = new View();

    private final FileOperation file = new FileOperation();

    private User user = new User();

    public boolean scheckUser(User newUser){
        String line;
        int count = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(file.createFileName(newUser.getFirstName())))) {
            while ((line = in.readLine()) != null) {
                String[] test = line.replace("><", " ").replace("<", "").replace(">", "").split(" ");
                User tempUser = user.createUser(test);
                if(newUser.equals(tempUser)){
                    count++;
                }else{
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count == 0){
            return true;
        }
        return false;
    }

    public String[] scheckLine(String[] line) {
        String[] result = new String[6];
        if (line.length != 6) {
            System.out.println("Введенено не верное колличество данных");
            View view = new View();
            String temp1 = view.prompt("Повторите попытку: ");
            line = temp1.split(" ");
            scheckLine(line);
        }
        for (int i = 0; i < line.length; i++) {
            result[i] = line[i];
        }
        return result;
    }

    public String isAlpha(String line, String args) {
        String warning = "";
        if(args == "F"){
            warning = "Допушена ошибки при вводе Фамилии!!!";
        }else if(args == "L"){
            warning = "Допушена ошибки при вводе Имени!!!";
        }else {
            warning = "Допушена ошибки при вводе Отчества!!!";
        }
        if (line == null) {
            System.out.println(warning);
            return line = view.prompt("Повторите ввод: ");
        }
        for (int i = 0; i < line.length(); i++) {
            char x = line.charAt(i);
            if (!(x >= 'A' && x <= 'Z') && !(x >= 'a' && x <= 'z') && !(x >= 'А' && x <= 'Я') && !(x >= 'а' && x <= 'я')) {
                System.out.println(warning);
                return line = view.prompt("Повторите ввод: ");
            }
        }
        return line;
    }

    public String isDate(String line) throws ParseException {
        String temp1 = line.replace("-", " ").replace("/", " ").replace("_", " ").replace(",", " ").replace(".", " ");
        SimpleDateFormat format;
        try{
            format = new SimpleDateFormat("dd MM yyyy");
        }catch(Exception e){
            System.out.println("Допущена ошибка в написание даты рождения!!!\nПовторите Ввод!!!");
            return line = view.prompt("Введите дату рождения через " + "'.'" + " в формаде (д.м.год): ");
        }
        if (temp1.length() != 10) {
            System.out.println("Допущена ошибка в написание даты рождения!!!\nПовторите Ввод!!!");
            return line = view.prompt("Введите дату рождения через " + "'.'" + " в формаде (д.м.год): ");
        } else {
            Date date = format.parse(temp1);
            String month = "";
            for (int i = 0; i < 12; i++) {
                if (date.getMonth() == i & i < 9) {
                    month = "0" + (i + 1);
                } else if (date.getMonth() == i & i >= 9) {
                    month = "" + (i + 1);
                }
            }
            String temp2 = (date.getDate() + "." + month + "." + (1900 + date.getYear()));
            if (line.equals(temp2)) {
                return line;
            } else {
                System.out.println("Допущена ошибка в написание даты рождения!!!");
                return line = view.prompt("Введите дату рождения через " + "'.'" + " в формаде (д.м.год): ");
            }
        }
    }

    public String isNumeric(String line) {
        try {
            Long.parseLong(line);
            if (line.length() == 11) {
                return line;
            } else {
                System.out.println("Номер телефона слижком длиннй или слишком короткий!!!");
                return line = view.prompt("Введите номер телефона: ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Допущена ошибка в написание номера телефона.\n!!!Повторите ввод номера телефона!!!");
            return line = view.prompt("Введите номер телефона: ");
        }
    }

    public String isGender(String line) {
        if(!line.equals("f") && !line.equals("m")){
            System.out.println("Допущена ошибка в написание пола.");
            return line = view.prompt("Повторите ввод латинецей. Где <F> - жинский, <M> - мужской: ").toLowerCase();
        }
        return line.toLowerCase();
    }

}
