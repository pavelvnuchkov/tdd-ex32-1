import java.util.TreeMap;

public class PhoneBook {

    private TreeMap<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String number) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        return null;
    }
}
