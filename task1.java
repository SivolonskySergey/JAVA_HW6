import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class task1 {
    static ArrayList<String[]> list_items = new ArrayList<>();
    static ArrayList<laptop> laptops_list = new ArrayList<>();

    private static int userIntInput(String u_input_val) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.print(u_input_val);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод! Введите целое число!");
            }
        }
        return inputStr;
    }

    private static String userStrInput(String u_input_val) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        while (true) {
            System.out.print(u_input_val);
            try {
                inputStr = sc.next();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return inputStr;
    }

    public static void filterByParams() {

        System.out.println("Введите цифру, соответствующую критерию поиска: " +
                "\n1 - RAM" +
                "\n2 - Объем HD" +
                "\n3 - Операционная система" +
                "\n4 - Производитель" +
                "\n5 - Цена");

        Integer checkExit = userIntInput(
                "\nВведите номер параметра для поиска. Для выхода в предыдущее меню нажмите 0. ");
        switch (checkExit) {
            case 1:
                String val_parameter = userStrInput("\nВведите значение параметра: ");
                for (int i = 0; i < laptops_list.size(); i++) {
                    if (laptops_list.get(i).ram == Integer.parseInt(val_parameter)) {
                        System.out.println(laptops_list.get(i).printLaptop());
                    }
                }
                break;
            case 2:
                val_parameter = userStrInput("\nВведите значение параметра: ");
                for (int i = 0; i < laptops_list.size(); i++) {
                    if (laptops_list.get(i).hdd == Integer.parseInt(val_parameter)) {
                        System.out.println(laptops_list.get(i).printLaptop());
                    }
                }
                break;
            case 3:
                val_parameter = userStrInput("\nВведите значение параметра: ");
                for (int i = 0; i < laptops_list.size(); i++) {
                    if (Objects.equals(laptops_list.get(i).os, val_parameter)) {
                        System.out.println(laptops_list.get(i).printLaptop());
                    }
                }
                break;
            case 4:
                val_parameter = userStrInput("\nВведите значение параметра: ");
                for (int i = 0; i < laptops_list.size(); i++) {
                    if (Objects.equals(laptops_list.get(i).brand, val_parameter)) {
                        System.out.println(laptops_list.get(i).printLaptop());
                    }
                }
                break;
            case 5:
                val_parameter = userStrInput("\nВведите значение параметра: ");
                for (int i = 0; i < laptops_list.size(); i++) {
                    if (laptops_list.get(i).price == Integer.parseInt(val_parameter)) {
                        System.out.println(laptops_list.get(i).printLaptop());
                    }
                }
                break;
            default:
                break;
        }
    };

    public static void main(String[] args) throws IOException {

        Integer id_laptop_tmp;
        String brand_laptop_temp;
        String model_laptop_temp;
        Integer ram_laptop_tmp;
        Integer hdd_laptop_tmp;
        String os_laptop_tmp;
        Integer price_laptop_tmp;

        Path path = Paths.get("db_laptops.txt");
        Scanner scanner = new Scanner(path);
        String line = "";
        while (scanner.hasNextLine()) {
            line += scanner.nextLine() + " ";
        }
        scanner.close();

        String[] configs_laptop = line.split(" ");
        for (int i = 0; i < configs_laptop.length; i++) {
            list_items.add(configs_laptop[i].split(","));
        }
        for (int i = 0; i < list_items.size(); i++) {
            id_laptop_tmp = Integer.parseInt(list_items.get(i)[0]);
            brand_laptop_temp = list_items.get(i)[1];
            model_laptop_temp = list_items.get(i)[2];
            ram_laptop_tmp = Integer.parseInt(list_items.get(i)[3]);
            hdd_laptop_tmp = Integer.parseInt(list_items.get(i)[4]);
            os_laptop_tmp = list_items.get(i)[5];
            price_laptop_tmp = Integer.parseInt(list_items.get(i)[6]);
            laptops_list.add(new laptop(id_laptop_tmp, brand_laptop_temp,
                    model_laptop_temp, ram_laptop_tmp,
                    hdd_laptop_tmp, os_laptop_tmp, price_laptop_tmp));
        }
        System.out.println(laptops_list.get(1).printLaptop());

        Integer user_input_1 = userIntInput("Добро пожаловать в каталог ноутбуков!" +
                "\nВыберите действие:" +
                "\n1 - Печать всех товаров" +
                "\n2 - Поиск по каталогу" +
                "\n0 - Выход\n");

        switch (user_input_1) {
            case 1:
                for (laptop item : laptops_list) {
                    System.out.println(item.printLaptop());
                }
                break;
            case 2:
                filterByParams();
                break;
            case 0:
                System.out.println("Bye!");
                break;
            default:
                break;
        }
    }

}
