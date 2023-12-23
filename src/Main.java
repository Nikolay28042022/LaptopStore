import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LaptopStore laptopStore = new LaptopStore();

        // Добавляем ноутбуки в магазин
        laptopStore.addLaptop(new Laptop("Model1", 8, 512, "Windows", "Silver"));
        laptopStore.addLaptop(new Laptop("Model2", 16, 1024, "MacOS", "Space Gray"));
        // Добавьте другие ноутбуки

        // Запрашиваем у пользователя критерии фильтрации
        Map<String, Object> filters = requestFilterCriteria();

        // Выводим отфильтрованные ноутбуки
        Set<Laptop> filteredLaptops = laptopStore.filterLaptops(filters);
        for (Laptop laptop : filteredLaptops) {
            laptop.displayInfo();
            System.out.println("-------------------------");
        }
    }

    // Метод для запроса критериев фильтрации у пользователя
    private static Map<String, Object> requestFilterCriteria() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion;
        do {
            System.out.print("Выберите критерий (введите цифру): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Введите корректное число: ");
                scanner.next();
            }
            criterion = scanner.nextInt();
        } while (criterion < 1 || criterion > 4);

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                int ram = scanner.nextInt();
                filters.put("RAM", ram);
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                int storage = scanner.nextInt();
                filters.put("Storage", storage);
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                scanner.nextLine(); // Очистка буфера после nextInt()
                String os = scanner.nextLine();
                filters.put("OperatingSystem", os);
                break;
            case 4:
                System.out.print("Введите цвет: ");
                scanner.nextLine(); // Очистка буфера после nextInt()
                String color = scanner.nextLine();
                filters.put("Color", color);
                break;
        }

        return filters;
    }
}


