package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Salad {
    private List<Vegetable> vegetables;

    public void addVegetable(Vegetable vegetable) {
        this.vegetables.add(vegetable);
    }


    public void sortByName() {
        vegetables.sort(Comparator.comparing(Vegetable::getName));
    }

    public void sortByCalories() {
        vegetables.sort(Comparator.comparing(Vegetable::getCalories));
    }

    public int getCalories() {
        return vegetables.stream().mapToInt(Vegetable::getCalories).sum();
    }

    public List<Vegetable> getVegetablesWithCalories(int min, int max) {
        return vegetables.stream().filter(v -> v.getCalories() >= min && v.getCalories() <= max).toList();
    }

    public void showSalad() {
        vegetables.forEach(v -> System.out.println(v.getName() + ": " + v.getCalories()));
    }

    public Salad() {
        this.vegetables = new ArrayList<>();
    }
}
