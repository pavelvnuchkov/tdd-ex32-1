import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private static final PhoneBook PHONE_BOOK = new PhoneBook();

    @BeforeAll
    static void beforeAll() {
        PHONE_BOOK.add("Арбузов Ваня", "89277289237");
        PHONE_BOOK.add("Иванов Петя", "89273331122");
        PHONE_BOOK.add("Петров Женя", "89224413311");
        PHONE_BOOK.add("Сидоров Егор", "89337776699");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Иванов Петя2, 89273331123, 5",
            "Петров Женя2, 89224413313, 6",
            "Иванов Петя2, 89273331123, 6"
    })
    public void addTest(String name, String number, int expected) {
        int actual = PHONE_BOOK.add(name, number);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "89273331122, Иванов Петя",
            "89224413311, Петров Женя",
            "99999999999, Ничего не найдено",
            "89337776699, Сидоров Егор"
    })
    public void findByNumber(String number, String expected) {
        Assertions.assertEquals(expected, PHONE_BOOK.findByNumber(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Иванов Петя2, 89273331123",
            "Петров Женя2, 89224413313",
            "Иванов Петя2, 89273331123"
    })
    public void findByName(String name, String expected) {
        Assertions.assertEquals(expected, PHONE_BOOK.findByName(name));
    }

    @Test
    public void printAllNames() {
        String[] name = {
                "Иванов Петя",
                "Петров Женя",
                "Сидоров Егор",
                "Петров Женя2",
                "Иванов Петя2",
                "Иванов Петя2",
                "Арбузов Ваня"};
        List<String> sortedList = Arrays.asList(name);
        Collections.sort(sortedList);
        String expected = sortedList.toString();
        Assertions.assertEquals(expected, PHONE_BOOK.printAllNames());
    }
}