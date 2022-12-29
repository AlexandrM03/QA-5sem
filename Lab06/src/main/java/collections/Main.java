package collections;

public class Main {
    public static void main(String[] args) {
        Salad salad = new Salad();

        salad.addVegetable(new Vegetable("Potato", 77));
        salad.addVegetable(new Vegetable("Carrot", 41));
        salad.addVegetable(new Vegetable("Cabbage", 25));
        salad.addVegetable(new Vegetable("Cucumber", 16));

        System.out.println("Salad: ");
        salad.showSalad();

        System.out.println("\nSorted by name: ");
        salad.sortByName();
        salad.showSalad();

        System.out.println("\nSorted by calories: ");
        salad.sortByCalories();
        salad.showSalad();

        System.out.println("\nOverall calories: " + salad.getCalories());

        System.out.println("\nVegetables from 20 to 50 calories: ");
        salad.getVegetablesWithCalories(20, 50).forEach(v -> {
            System.out.println(v.getName() + ": " + v.getCalories());
        });
    }
}
