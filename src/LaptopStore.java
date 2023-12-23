import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        this.laptops = new HashSet<>();
    }

    // Метод для добавления ноутбука в магазин
    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    // Метод для фильтрации ноутбуков по заданным критериям
    public Set<Laptop> filterLaptops(Map<String, Object> filters) {
        Set<Laptop> result = new HashSet<>();

        for (Laptop laptop : laptops) {
            if (matchesFilters(laptop, filters)) {
                result.add(laptop);
            }
        }

        return result;
    }

    // Вспомогательный метод для проверки соответствия ноутбука заданным критериям
    private boolean matchesFilters(Laptop laptop, Map<String, Object> filters) {
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String criterion = entry.getKey();
            Object value = entry.getValue();

            switch (criterion) {
                case "RAM":
                    if (laptop.getRam() < (int) value) {
                        return false;
                    }
                    break;
                case "Storage":
                    if (laptop.getStorage() < (int) value) {
                        return false;
                    }
                    break;
                case "OperatingSystem":
                    if (!laptop.getOperatingSystem().equals(value)) {
                        return false;
                    }
                    break;
                case "Color":
                    if (!laptop.getColor().equals(value)) {
                        return false;
                    }
                    break;
                // Добавьте другие критерии, если необходимо
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LaptopStore laptopStore = new LaptopStore();

        // Добавляем ноутбуки в магазин
        laptopStore.addLaptop(new Laptop("Model1", 8, 512, "Windows", "Silver"));
        laptopStore.addLaptop(new Laptop("Model2", 16, 1024, "MacOS", "Space Gray"));
        // Добавьте другие ноутбуки

        // Запрашиваем у пользователя критерии фильтрации
        Map<String, Object> filters = new HashMap<>();
        filters.put("RAM", 12);
        filters.put("Storage", 750);
        // Добавьте другие критерии по желанию

        // Выводим отфильтрованные ноутбуки
        Set<Laptop> filteredLaptops = laptopStore.filterLaptops(filters);
        for (Laptop laptop : filteredLaptops) {
            System.out.println("Model: " + laptop.getModel() + ", RAM: " + laptop.getRam() +
                    ", Storage: " + laptop.getStorage() + ", OS: " + laptop.getOperatingSystem() +
                    ", Color: " + laptop.getColor());
        }
    }
}

