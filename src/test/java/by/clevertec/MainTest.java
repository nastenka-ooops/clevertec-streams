package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    List<Animal> mockAnimals;

    @BeforeEach
    public void setUp() {

        mockAnimals = Arrays.asList(
                new Animal(1, "Lion", 15, "Japanese", "Male"),
                new Animal(2, "Elephant", 31, "Africa", "Female"),
                new Animal(3, "Tiger", 12, "Japanese", "Male"),
                new Animal(4, "Zebra", 19, "Africa", "Female"),
                new Animal(5, "Bear", 10, "North America", "Male"),
                new Animal(6, "Giraffe", 21, "Africa", "Female"),
                new Animal(7, "Wolf", 16, "Europe", "Male"),
                new Animal(8, "Leopard", 17, "Africa", "Female"),
                new Animal(9, "Kangaroo", 35, "Australia", "Male"),
                new Animal(10, "Penguin", 8, "Antarctica", "Female"),
                new Animal(11, "Monkey", 13, "Asia", "Male"),
                new Animal(12, "Panda", 14, "China", "Female"),
                new Animal(13, "Cheetah", 18, "Africa", "Male"),
                new Animal(14, "Koala", 9, "Australia", "Female"),
                new Animal(15, "Bison", 11, "North America", "Male"),
                new Animal(16, "Hyena", 17, "Africa", "Female"),
                new Animal(17, "Sloth", 22, "South America", "Female"),
                new Animal(18, "Rhinoceros", 19, "Africa", "Male"),
                new Animal(19, "Parrot", 12, "South America", "Female"),
                new Animal(20, "Penguin", 40, "Antarctica", "Male"),
                new Animal(21, "Eagle", 15, "North America", "Female"),
                new Animal(22, "Orangutan", 13, "Asia", "Male"),
                new Animal(23, "Crocodile", 18, "Africa", "Male"),
                new Animal(24, "Flamingo", 16, "Japanese", "Female"),
                new Animal(25, "Walrus", 20, "Arctic", "Male"),
                new Animal(26, "Otter", 12, "North America", "Female"),
                new Animal(27, "Lemur", 14, "Madagascar", "Male"),
                new Animal(28, "Gazelle", 19, "Africa", "Female"),
                new Animal(29, "Komodo Dragon", 8, "Indonesian", "Male"),
                new Animal(30, "Javan Hawk-Eagle", 6, "Indonesian", "Female"),
                new Animal(31, "Sumatran Tiger", 10, "Indonesian", "Male"),
                new Animal(32, "Bornean Orangutan", 15, "Indonesian", "Female")
        );
    }

    @Test
    public void task1Test() {
        List<Animal> result = Main.task1(mockAnimals);

        List<Animal> expected = Arrays.asList(
                new Animal(24,"Flamingo",16,"Japanese","Female"),
                new Animal(8,"Leopard",17,"Africa","Female"),
                new Animal(16, "Hyena", 17, "Africa", "Female"),
                new Animal(13, "Cheetah", 18, "Africa", "Male"),
                new Animal(23, "Crocodile", 18, "Africa", "Male"),
                new Animal(4, "Zebra", 19, "Africa", "Female"),
                new Animal(18, "Rhinoceros", 19, "Africa", "Male")
        );



        assertEquals(expected, result);
    }

    @Test
    public void task2Test() {
        List<String> result = Main.task2(mockAnimals);

        List<String> expected = Arrays.asList(
                "LION",
                "TIGER",
                "FLAMINGO"
        );

        assertEquals(expected, result);
    }

    @Test
    public void task3Test() {
        List<String> result = Main.task3(mockAnimals);

        List<String> expected = Arrays.asList(
                "Africa", "Australia", "Antarctica"
        );

        assertEquals(expected, result);
    }

    @Test
    public void task4Test(){
        long result = Main.task4(mockAnimals);

        long expected = 16;

        assertEquals(expected, result);
    }

    @Test
    public void task5Test(){
        boolean result = Main.task5(mockAnimals);

        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void task6Test(){
        boolean result = Main.task6(mockAnimals);

        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void task7Test(){
        boolean result = Main.task7(mockAnimals);

        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void task8Test(){
        int result = Main.task8(mockAnimals);

        int expected = 40;

        assertEquals(expected, result);
    }

    @Test
    public void task9Test(){
        int result = Main.task9(mockAnimals);

        int expected = 4;

        assertEquals(expected, result);
    }

    @Test
    public void task10Test(){
        long result = Main.task10(mockAnimals);

        long expected = 525;

        assertEquals(expected, result);
    }

    @Test
    public void task11Test(){
        double result = Main.task11(mockAnimals);

        double expected = 9.75;

        assertEquals(expected, result);
    }
}
