package io.lab5;
import io.lab5.space.ToyRoom;
import io.lab5.toy.*;


/**
 * Лабораторна робота з ООП №5
 */
public class Main {
    public static void main(String[] args) {

        ToyRoom room = new ToyRoom(10, 3000.00);

        room.addToy(new Car("Ferrari",       149.99, 3,  "мала"));
        room.addToy(new Car("Джип",          399.00, 6,  "середня"));
        room.addToy(new Car("Турбо RC",      890.00, 8,  "велика"));
        room.addToy(new Doll("Пупсик",       250.00, 1,  "тканина"));
        room.addToy(new Doll("Барбі",        540.00, 5,  "пластик"));
        room.addToy(new Ball("М'який",       120.00, 1,  10));
        room.addToy(new Ball("Футбольний",   280.00, 6,  22));
        room.addToy(new Car("Люкс-кар",     2000.00, 10, "велика")); // перевищить бюджет

        System.out.println("--- Усі іграшки (порядок додавання) ---\n");
        room.printAll();

        System.out.println("--- Після сортування за ціною ---\n");
        room.sortByPrice();
        room.printAll();

        System.out.println("--- Пошук у діапазоні 200 – 500 грн ---\n");
        room.findByPriceRange(200, 500);

        System.out.println("--- Некоректний діапазон ---\n");
        room.findByPriceRange(500, 100);

        System.out.println("--- Додавання null ---\n");
        room.addToy(null);
    }
}