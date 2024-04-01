package Java_Core;

public class Module_2_Abstract_Сlasses {
}

// Объявление абстрактного класса
abstract class GraphicObject {
    int x, y;

    void moveTo(int newX, int newY) {}
    abstract void draw();
    abstract void resize();
}

class Circle extends GraphicObject {
    void draw() {}
    void resize() {}
}

class Rectangle extends GraphicObject {
    void draw() {}
    void resize() {}
}
