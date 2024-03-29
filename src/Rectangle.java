public class Rectangle {
    private int width; // Ширина прямоугольника
    private int height; // Высота прямоугольника

    // Конструктор для инициализации ширины и высоты прямоугольника
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        // Пример использования класса
        Rectangle rectangle = new Rectangle(5, 10);
        rectangle.setHeight(5);
        System.out.println("Ширина прямоугольника: " + rectangle.getWidth());
        System.out.println("Высота прямоугольника: " + rectangle.getHeight());
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());

        //полчение ключа
        Settings muMetod = new Settings();
        System.out.println(muMetod.geKey());
    }

    // Метод для расчета площади прямоугольника
    public double calculateArea() {
        return width * height;
    }

    // Методы для установки и получения значений ширины и высоты
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
