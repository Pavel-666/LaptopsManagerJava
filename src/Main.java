
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.out;

public class Main {
    static Set<Laptops> note = new HashSet<>();
    static Map<Integer, String> ask = new HashMap<>();
    static Map<String, String> filter = new HashMap<>();
    static Set<Laptops> showModels = new HashSet<>();


    public static void main(String[] args) {
        note.add(new Laptops("Asus", 8, "Windows 11", "black", 1000));
        note.add(new Laptops("HP", 6, "Windows 10", "blue", 500));
        note.add(new Laptops("MSI", 16, "linux", "White", 3000));
        note.add(new Laptops("Dell", 16, "Windows 10", "red", 1000));
        note.add(new Laptops("mac", 8, "Mac.OS", "White", 500));

        ask.put(1, "модель");
        ask.put(2, "оперативная память");
        ask.put(3, "операционная система");
        ask.put(4, "цвет");
        ask.put(5, "жесткий диск");

        if (userOrOwner() == 562){
            OwnerOpportunities();
        }else userOpportunities();
    }

    static int userOrOwner() {
        String originalPasvord = "pasvord";
        Scanner in = new Scanner(System.in);
        out.println(" если вы владелец сайта ввдите пароль, если нет то напишите что угодно и переходите к меню возможностей");
        String pasvord = in.next();
        if (pasvord == originalPasvord){
            return 562;
        } else return 0;
    }

    static void userOpportunities(){
        Boolean marcer = true;
        while (marcer){
            out.println("выберите действие");
            out.println("1 показать список доступных устройств ");
            out.println("2 выбрать устройство по критериям ");
            out.println("3 прейти в режим владельца ");
            out.println("любая другая цифра, закончить работу ");
            Scanner in = new Scanner(System.in);
            out.println("ваш выбор  : ");
            String operation = in.next();
            switch (operation){
                case "1": // allLaptops
                    out.println(note);
                    break;
                case "2": // searchLaptop
                    searchLaptop();
                    break;
                case "3": // go to Owner
                    out.println("данный функционал будет добавлен в следующем патче");
                    break;
                default: // exit
                    out.println("добавленные данные не будут сохранены");
                    out.println("ожидайте патчей с добавлением долговременной памяти");
                    out.println("всего наилучшего");
                    marcer = false;
                    break;
            }


        }

    }

    static void OwnerOpportunities(){
        out.println("данный функционал будет добавлен в следующем патче");
        userOpportunities();
    }

    static void searchLaptop(){
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry entry : ask.entrySet()) {
            out.println(
                    "введите минимальное значение для параметра :  " + entry.getValue() + ", или 0 если этот параметр не важен ");
            String value = scanner.nextLine();
            filter.put((String) entry.getValue(), value);
        }

        for (Laptops entry : note) {
            if ((entry.getModel().equals(filter.get("модель")) || filter.get("модель").equals("0")) &&
                    entry.getRam() >= Integer.parseInt(filter.get("оперативная память")) &&
                    (entry.getOs().equals(filter.get("операционная система")) || filter.get("операционная система").equals("0")) &&
                    (entry.getColor().equals(filter.get("цвет")) || filter.get("цвет").equals("0")) &&
                    entry.getHard() >= Integer.parseInt(filter.get("жесткий диск"))) {
                showModels.add(entry);
            }
        }
        out.println("подходящие по параметрам модели:");
        for (Laptops laptop : showModels) {
            out.println(laptop);
        }
    }

}