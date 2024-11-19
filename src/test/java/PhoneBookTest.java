import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private static final PhoneBook PHONE_BOOK = new PhoneBook();

    @ParameterizedTest
    @CsvSource(value = {
            "Иванов Петя, 89273331122, 1",
            "Петров Женя, 89224413311, 2",
            "Иванов Петя, 89273331122, 2"
    })
    public void addTest(String name, String number, int expected) {
        int actual = PHONE_BOOK.add(name, number);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "89273331122, Иванов Петя",
            "89224413311, Петров Женя",
            "99999999999, Ничего не найдено"
    })
    public void findByNumber(String number, String expected) {
        Assertions.assertEquals(expected, PHONE_BOOK.findByNumber(number));
    }
}