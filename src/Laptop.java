public class Laptop {
    // Поля (характеристики) ноутбука
    private String model;            // Модель ноутбука
    private int ram;                 // Объем оперативной памяти в гигабайтах
    private int storage;             // Объем встроенного накопителя в гигабайтах
    private String operatingSystem;  // Установленная операционная система
    private String color;            // Цвет ноутбука

    // Конструктор класса для инициализации полей при создании объекта
    public Laptop(String model, int ram, int storage, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры (методы для получения значений полей)
    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    // Сеттеры (методы для изменения значений полей, если необходимо)
    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Другие методы, если необходимо
    // Например, метод для вывода информации о ноутбуке
    public void displayInfo() {
        System.out.println("Модель: " + model);
        System.out.println("Оперативная память: " + ram + " ГБ");
        System.out.println("Объем накопителя: " + storage + " ГБ");
        System.out.println("Операционная система: " + operatingSystem);
        System.out.println("Цвет: " + color);
    }
}

