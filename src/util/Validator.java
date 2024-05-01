package util;


public class Validator {
    private String[] result = new String[6];
    public String[] scheckLine(String[] line) {
        if(line.length != 6){
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

}
