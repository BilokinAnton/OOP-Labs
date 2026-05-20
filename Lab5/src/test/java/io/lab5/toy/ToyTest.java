package io.lab5.toy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToyTest {

    @Test
    public void testCarCreation() {
        Car car = new Car("Ferrari", 149.99, 3, "мала");
        assertEquals("Ferrari", car.getName());
        assertEquals(149.99, car.getPrice());
        assertEquals(3, car.getAgeGroup());
        assertEquals("мала", car.getSize());
        assertEquals("Машинка", car.getType());
    }

    @Test
    public void testDollCreation() {
        Doll doll = new Doll("Барбі", 540.00, 5, "пластик");
        assertEquals("Барбі", doll.getName());
        assertEquals(540.00, doll.getPrice());
        assertEquals(5, doll.getAgeGroup());
        assertEquals("пластик", doll.getMaterial());
        assertEquals("Лялька", doll.getType());
    }

    @Test
    public void testBallCreation() {
        Ball ball = new Ball("Футбольний", 280.00, 6, 22);
        assertEquals("Футбольний", ball.getName());
        assertEquals(280.00, ball.getPrice());
        assertEquals(6, ball.getAgeGroup());
        assertEquals(22, ball.getDiameterCm());
        assertEquals("М'яч", ball.getType());
    }

    @Test
    public void testSetters() {
        Car car = new Car("Старий", 100.00, 3, "мала");
        car.setName("Новий");
        car.setPrice(200.00);
        car.setAgeGroup(5);
        car.setSize("велика");
        assertEquals("Новий", car.getName());
        assertEquals(200.00, car.getPrice());
        assertEquals(5, car.getAgeGroup());
        assertEquals("велика", car.getSize());
    }

    @Test
    public void testToStringContainsName() {
        Car car = new Car("Ferrari", 149.99, 3, "мала");
        assertTrue(car.toString().contains("Ferrari"));
        assertTrue(car.toString().contains("Машинка"));
    }

    @Test
    public void testToStringContainsMaterial() {
        Doll doll = new Doll("Пупсик", 250.00, 1, "тканина");
        assertTrue(doll.toString().contains("тканина"));
    }

    @Test
    public void testToStringContainsDiameter() {
        Ball ball = new Ball("М'який", 120.00, 1, 10);
        assertTrue(ball.toString().contains("10"));
    }
}