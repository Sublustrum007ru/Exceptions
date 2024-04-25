import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private final String filePatch = "src/Hello.txt";
    private List<String> list1 = new ArrayList<>();

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
    public void start(){
        String str = promt("Введите (Фамилью, имя, отчество, дату_рождения, номер_телефона, пол) через пробел: ");
        String[] line1 = str.split(" ");
        if(line1.length == 6){
            for (int i = 0; i < line1.length; i++) {
                System.out.println(line1[i]);
            }
        }else{
            System.out.println("Введено не верное колличество аргументов");
        }
    }

    public String promt(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
