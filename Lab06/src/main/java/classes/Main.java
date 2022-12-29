package classes;

public class Main {
    public static void main(String[] args) {
        BooksList books = new BooksList();

        books.addBook(new Book(1, "The Wings of the DoveThe Wings of the Dove", "Henry James",
                        "HarperCollins", 1901, 345, 13.99f, Binding.HARD));
        books.addBook(new Book(2, "Antic HayAntic Hay", "Aldous Huxley",
                "Macmillan Publishers", 1923, 544, 24.99f, Binding.HARD));
        books.addBook(new Book(3, "Blue of NoonBlue of Noon", "Georges Bataille",
                "HarperCollins", 1957, 213, 4.99f, Binding.SOFT));
        books.addBook(new Book(4, "Beyond Good and Evil", "Friedrich Nietzsche",
                "Macmillan Publishers", 1886, 160, 14.99f, Binding.HARD));
        books.addBook(new Book(5, "Thus Spoke Zarathustra", "Friedrich Nietzsche",
                "Macmillan Publishers", 1883, 368, 2.99f, Binding.SOFT));

        System.out.println("---getAllByAuthor---\n" + books.getAllByAuthor("Friedrich Nietzsche"));
        System.out.println("---getAllByPublisher---\n" + books.getAllByPublisher("HarperCollins"));
        System.out.println("---getAllAfterPublishingYear---\n" + books.getAllAfterPublishingYear(1920));
    }
}
