package by.clevertec;

import by.clevertec.model.*;
import by.clevertec.util.Util;

import java.rmi.NoSuchObjectException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NoSuchObjectException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19(new Scanner(System.in).nextLine());
        task20();
        task21();
        task22();
    }

    public static void task1() {
        /*Из представленных животных отобрать все молодые особи от 10 до 20 лет и
        отсортировать по возрасту (по возрастанию) далее - распределить по 7 на каждый зоопарк.
        Зоопарков неограниченное кол-во а вы - директор 3-го по счёту зоопарка.
        Полученных животных вывести в консоль.*/

        System.out.println("Task 1");
        int skipAmount = 2 * 7;

        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(skipAmount)
                .limit(7)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Task 2");
        /*Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE в если
        пол Female преобразовать к строкам породы животных и вывести в консоль*/
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .forEach(animal -> System.out.println(animal.getBread().toUpperCase()));
    }

    public static void task3() {
        System.out.println("Task 3");
        /*Отобрать всех животных старше 30 лет и вывести все страны
        происхождения без дубликатов начинающиеся на "A"*/
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .distinct()
                .filter(origin -> origin.startsWith("A"))
                .forEach(System.out::println);
    }

    public static void task4() {
        System.out.println("Task 4");
        /*Подсчитать количество всех животных пола = Female. Вывести в консоль*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count());
    }

    public static void task5() {
        System.out.println("Task 5");
        /*Взять всех животных возрастом 20 - 30 лет.
        Есть ли среди нах хоть один из страны Венгрия (Hungarian)? Ответ вывести в консоль*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian")));

    }

    public static void task6() {
        System.out.println("Task 6");
        /*Взять всех животных. Все ли они пола Male и Female ? Ответ вывести в консоль*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .allMatch(animal -> animal.getGender().equals("Female") || animal.getGender().equals("Male")));
    }

    public static void task7() {
        System.out.println("Task 7");
        /*Взять всех животных. Узнать что ни одно из них не имеет страну
        происхождения Oceania. Ответ вывести в консоль*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania")));
    }

    public static void task8() throws NoSuchObjectException {
        System.out.println("Task 8");
        /*Взять всех животных. Отсортировать их породу в стандартном порядке и
        взять первые 100. Вывести в консоль возраст самого старого животного*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow(() -> new NoSuchObjectException("Object not found")));
    }

    public static void task9() throws NoSuchObjectException {
        System.out.println("Task 9");
        /*Взять всех животных. Преобразовать их в породы, а породы
        в []char Вывести в консоль длину самого короткого массива*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .map(Animal::getOrigin)
                .map(String::toCharArray)
                .min(Comparator.comparingInt(chars -> chars.length))
                .orElseThrow(() -> new NoSuchObjectException("Object not found")));
    }

    public static void task10() {
        System.out.println("Task 10");
        /*Взять всех животных. Подсчитать суммарный возраст всех животных. Вывести результат в консоль*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .mapToInt(Animal::getAge)
                .sum());
    }

    public static void task11() throws NoSuchObjectException {
        System.out.println("Task 11");
        /*Взять всех животных. Подсчитать средний возраст всех животных
        из индонезии (Indonesian). Вывести результат в консоль*/
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .orElseThrow(() -> new NoSuchObjectException("Object not found")));
    }

    public static void task12() {
        System.out.println("Task 12");
        /*Во Французский легион принимают людей со всего света, но есть отбор
        по полу (только мужчины) возраст от 18 до 27 лет. Преимущество отдаётся
        людям военной категории 1, на втором месте - военная категория 2, и на третьем
        месте военная категория 3. Отсортировать всех подходящих кандидатов в порядке
        их приоритета по военной категории. Однако взять на обучение академия может
        только 200 человек. Вывести их в консоль.*/
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> isOlder(person, 18))
                .filter(person -> isYounger(person, 27))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    public static void task13() {
        System.out.println("Task 13");
        /*Надвигается цунами и в районе эвакуации требуется в первую очередь
        обойти дома и эвакуировать больных и раненых (из Hospital),
        во вторую очередь детей и стариков (до 18 и пенсионного возраста)
        а после всех остальных. В первый этап эвакуации мест в эвакуационном
        транспорте только 500. Вывести всех людей попадающих в первый этап эвакуации
        в порядке приоритета (в консоль).*/

        int retirementAge = 60;

        List<House> houses = Util.getHouses();
        Stream<Person> hospitalPersons = houses.stream()
                .filter(house -> house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream());

        Stream<Person> otherPersons = houses.stream()
                .filter(house -> !house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream())
                .filter(person -> isYounger(person, 18))
                .filter(person -> isOlder(person, retirementAge));

        Stream.concat(hospitalPersons, otherPersons)
                .limit(500)
                .forEach(System.out::println);
    }

    public static void task14() {
        System.out.println("Task 14");
        /*Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит
        отсортировать их в порядке следования 1.Туркменистан - 2.Узбекистан - 3.Казахстан -
        4.Кыргызстан - 5.Россия - 6.Монголия. Все автомобили марки "Jaguar" а так же все авто
        цвета White идут в первую страну. Из оставшихся все автомобили с массой до 1500 кг и марок BMW,
        Lexus, Chrysler и Toyota идут во второй эшелон. Из оставшихся все автомобили Черного цвета с
        массой более 4000 кг и все GMC и Dodge идут в третий эшелон. Из оставшихся все автомобили года
        выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон. Из оставшихся все
        автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон
        Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
        Оставшиеся автомобили отбрасываем, они никуда не идут. Измерить суммарные массы автомобилей всех
        эшелонов для каждой из стран и подсчитать сколько для каждой страны будет стоить транспортные
        расходы если учесть что на 1 тонну транспорта будет потрачено 7.14 $. Вывести суммарные
        стоимости в консоль. Вывести общую выручку логистической кампании.*/
        List<Car> cars = Util.getCars();

        List<List<Car>> echelons = new ArrayList<>();

        //Все автомобили марки "Jaguar" а так же все авто
        //        цвета White идут в первую страну.
        List<Car> echelon1 = cars.stream()
                .filter(car -> car.getCarMake().equals("Jaguar")
                        || car.getColor().equals("White"))
                .toList();

        echelons.add(echelon1);
        cars.removeAll(echelon1);

//        Из оставшихся все автомобили с массой до 1500 кг и марок BMW,
//        Lexus, Chrysler и Toyota идут во второй эшелон.
        List<Car> echelon2 = cars.stream()
                .filter(car -> car.getMass() < 1500)
                .filter(car -> car.getCarMake().equals("BMW")
                        || car.getCarMake().equals("Lexus")
                        || car.getCarMake().equals("Chrysler")
                        || car.getCarMake().equals("Toyota")
                ).toList();


        echelons.add(echelon2);
        cars.removeAll(echelon2);

//        з оставшихся все автомобили Черного цвета с
//        массой более 4000 кг и все GMC и Dodge
        List<Car> echelon3 = cars.stream()
                .filter(car -> car.getMass() > 4000 && car.getColor().equals("BLACK")
                        || car.getCarMake().equals("GMC")
                        || car.getCarMake().equals("Dodge")
                ).toList();

        echelons.add(echelon3);
        cars.removeAll(echelon3);
//Из оставшихся все автомобили года
//        выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон.

        List<Car> echelon4 = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982
                        || car.getCarMake().equals("Cherokee")
                        || car.getCarMake().equals("Civic")
                ).toList();

        echelons.add(echelon4);
        cars.removeAll(echelon4);

        //Из оставшихся все
        //        автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон
        List<Car> echelon5 = cars.stream()
                .filter(car -> car.getPrice() > 40000
                        || !(car.getColor().equals("Yellow")
                        || car.getCarMake().equals("Blue")
                        || car.getCarMake().equals("Green")
                        || car.getCarMake().equals("Red"))
                ).toList();

        echelons.add(echelon5);
        cars.removeAll(echelon5);
//        Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
        List<Car> echelon6 = cars.stream()
                .filter(car -> car.getVin().contains("59")
                ).toList();

        echelons.add(echelon6);
        cars.removeAll(echelon6);

        double costPerTon = 7.14;

        List<Double> costs = new ArrayList<>();
        for (List<Car> echelon : echelons) {
            double v = (echelon.stream()
                    .mapToDouble(Car::getMass).sum() / 1000) * costPerTon;
            costs.add(v);
        }

        costs.forEach(System.out::println);

        System.out.println(costs.stream().mapToDouble(cost -> cost).sum());
    }

    public static void task15() {
        System.out.println("Task 15");
        //Для оранжереи нужно подобрать растения соответствующие требованиям.
        // Во-первых, нужно произвести сложную сортировку каталога растений.
        // Отсортировать их по странам происхождения в обратном порядке
        // После по стоимости и
        // еще по водопотреблению в обратном порядке.
        // Из этого списка взять растения название
        // которых от буквы "S" до буквы "C".
        // Если растения тенелюбивые и им подходит горшок из
        // стекла, алюминия или стали - то выбираем их.
        // Далее на каждое растение надо рассчитать
        // стоимость растения + стоимость потребления воды за 5 лет c учётом того что кубометр
        // воды стоит 1.39 $. Суммировать общую стоимость обслуживания всех растений.
        // Во сколько это обойдётся бюджету?

        double waterCostPerCubicMeter = 1.39;

        List<Flower> flowers = Util.getFlowers();
        double price = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().compareToIgnoreCase("S") <= 0
                        && flower.getCommonName().compareToIgnoreCase("C") >= 0)
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().stream()
                        .anyMatch(vase -> vase.equalsIgnoreCase("Glass")
                                || vase.equalsIgnoreCase("Aluminum")
                                || vase.equalsIgnoreCase("Steel")))
                .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * 5 * 365 * waterCostPerCubicMeter)
                .sum();
        System.out.println(price);
    }

    public static void task16() {
        System.out.println("Task 16");

        //Вывод списка студентов младше 18 лет в алфавитном порядке с указанием возраста
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() <= 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(System.out::println);
    }

    public static void task17() {
        System.out.println("Task 17");
        //Вывод списка групп (без повторений).
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        System.out.println("Task 18");
        //Определение среднего возраста студентов для каждого факультета.
        // Выводить название факультета и средний возраст в порядке убывания возраста.
        List<Student> students = Util.getStudents();

        Map<String, Double> collected = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)));

        collected.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public static void task19(String group) {
        System.out.println("Task 19");
        //Вывод списка студентов заданной группы, у которых сдан 3 экзамен (>4).
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        students.stream()
                .filter(student -> student.getGroup().equals(group))
                .filter(student -> examinations.stream().anyMatch(
                        examination -> examination.getStudentId() == student.getId()
                                && examination.getExam3() > 4))
                .forEach(System.out::println);
    }

    public static void task20() {
        System.out.println("Task 20");
        //Определение факультета с максимальной средней оценкой по первому экзамену.
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        Map<String, Double> collected = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingDouble(student ->
                                examinations.stream()
                                        .filter(examination -> examination.getStudentId() == student.getId())
                                        .mapToInt(Examination::getExam1)
                                        .average()
                                        .orElse(0.0)
                        )));
        collected.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

    public static void task21() {
        System.out.println("Task 21");
        //Определение количества студентов в каждой группе.
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.counting()
                ))
                .entrySet().forEach(System.out::println);
    }

    public static void task22() {
        System.out.println("Task 22");
        //Определение минимального возраста для каждого факультета.
        List<Student> students = Util.getStudents();
        Map<String, Optional<Student>> collected = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.minBy(Comparator.comparingInt(Student::getAge)
                        )));

        collected.forEach((key, value) -> {
            System.out.print(key + " ");
            value.ifPresent(student -> System.out.println(student.getAge()));
        });
    }

    public static boolean isOlder(Person person, int age) {
        return LocalDate.now().minusYears(age).isAfter(person.getDateOfBirth());
    }

    public static boolean isYounger(Person person, int age) {
        return LocalDate.now().minusYears(age).isBefore(person.getDateOfBirth());
    }
}
