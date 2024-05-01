package util;


import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {

    private String[] result = new String[6];
    private View view = new View();

    public String[] scheckLine(String[] line) {
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

    public String isDate(String line) throws ParseException {
        String temp1 = line.replace(".", " ");
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Date date = format.parse(temp1);
        String month = "";
        for (int i = 0; i < 12; i++) {
            if(date.getMonth() == i & i < 9) {
                month = "0" + (i + 1);
            }else if (date.getMonth() == i & i >= 9) {
                month = "" + (i + 1);
            }
        }
        String temp2 = (date.getDate() + "." + month + "." + (1900 + date.getYear()));
        if(line.equals(temp2)){
            return line;
        }else{
            System.out.println("Допущена ошибка в написание даты рождения.\n!!!Повторите даты рождения!!!");
            return line = view.prompt("Введите дату рождения через " + "'.'" + ": ");
        }
    }

    public String isNumeric(String line) {
        try {
            Long.parseLong(line);
            if (line.length() == 11) {
                return line;
            } else {
                System.out.println("Номер телефона слижком длиннй или слишком короткий");
                return line = view.prompt("Введите номер телефона: ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Допущена ошибка в написание номера телефона.\n!!!Повторите ввод номера телефона!!!");
            return line = view.prompt("Введите номер телефона: ");
        }
    }
}
