import java.util.*;

public class PhoneBook {

    private Map<String, String> phoneBookName = new TreeMap<>();
    private Map<String, String> phoneBookNumber = new TreeMap<>();

    public int add(String name, String number) {
        if (!phoneBookName.containsKey(name)) {
            phoneBookName.put(name, number);
            phoneBookNumber.put(number, name);
        }
        return phoneBookName.size();
    }

    public String findByNumber(String number) {

        if (phoneBookNumber.containsKey(number)) {
            return phoneBookNumber.get(number);
        }
        return "Ничего не найдено";
    }

    public String findByName(String name) {
        if (phoneBookName.containsKey(name)) {
            return phoneBookName.get(name);
        }
        return "Ничего не найдено";
    }

    public String printAllNames() {
        return null;
    }
}
