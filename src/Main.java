import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> collection1 = new CustomArrayList<>();
        collection1.addAll(List.of("Hello", "What's up"));
        try {
            collection1.remove(2);
        } catch (Exception e) {
            System.out.println(e);
        }
        collection1.remove(1);
        CustomArrayList<String> collection2 = new CustomArrayList<>(0);
        try {
            collection2.add("Hey", 1);
        } catch (Exception e) {
            System.out.println(e);
        }
        collection2.addAll(List.of("X", "C", "O"));
        collection2.sort();
        System.out.println(collection2);
        collection2.add("A");
        CustomArrayList.sort(collection2);
        System.out.println(collection2);
    }
}