package store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TradingStore {
    List<Fruit> fruitList = new ArrayList();

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public void addFruits(String pathToJsonFile) {
        fruitList.addAll(StoreUtil.readFromFile(pathToJsonFile));
    }

    public void save(String pathToJsonFile) {
        StoreUtil.writeToFile(fruitList, pathToJsonFile);
    }

    public void load(String pathToJsonFile) {
        fruitList.clear();
        addFruits(pathToJsonFile);
    }

    private boolean isSpoiled(Fruit fruit, LocalDate date) {
        return fruit.getDate().plusDays(fruit.getShelfLife()).isAfter(date);
    }

    public List<Fruit> getSpoiledFruits(LocalDate date) {
        List<Fruit> listOfSpoiled = fruitList.stream()
                .filter(fruit -> isSpoiled(fruit, date))
                .collect(Collectors.toList());
        return listOfSpoiled;
    }

    public List<Fruit> getAvailableFruits(LocalDate date) {
        List<Fruit> listOfAvailableFruits = fruitList.stream()
                .filter(fruit -> !isSpoiled(fruit, date))
                .collect(Collectors.toList());
        return listOfAvailableFruits;
    }

    public List<Fruit> getSpoiledFruits(LocalDate date, FruitType type) {
        List<Fruit> listOfSpoiledFruits = fruitList.stream()
                .filter(fruit -> fruit.getTypeOfFruit().equals(type))
                .filter(fruit -> isSpoiled(fruit, date))
                .collect(Collectors.toList());
        return listOfSpoiledFruits;
    }

    public List<Fruit> getAvailableFruits(LocalDate date, FruitType type) {
        List<Fruit> listOfAvailableFruits = fruitList.stream()
                .filter(fruit -> fruit.getTypeOfFruit().equals(type))
                .filter(fruit -> !isSpoiled(fruit, date))
                .collect(Collectors.toList());
        return listOfAvailableFruits;
    }

    public List<Fruit> getAddedFruits(LocalDate date) {
        List<Fruit> listOfAvailableFruits = fruitList.stream()
                .filter(fruit -> fruit.getDate().equals(date))
                .collect(Collectors.toList());
        return listOfAvailableFruits;
    }

    public List<Fruit> getAddedFruits(LocalDate date, FruitType typeOfFruit) {
        List<Fruit> listOfAvailableFruits = fruitList.stream()
                .filter(fruit -> fruit.getTypeOfFruit().equals(typeOfFruit) && fruit.getDate().equals(date))
                .collect(Collectors.toList());
        return listOfAvailableFruits;
    }

    public void show(List<Fruit> fruitList) {
        for (Fruit fruit : fruitList) {
            System.out.println(fruit.getTypeOfFruit() + " \t"
                    + fruit.getDate() + " \t"
                    + fruit.getShelfLife()
                    + " \t" + fruit.getPrice());
        }
    }
}
