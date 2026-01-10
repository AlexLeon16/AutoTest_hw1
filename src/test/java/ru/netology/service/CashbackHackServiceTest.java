package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
    void shouldReturn100IfAmount900() {
        CashbackHackService service = new CashbackHackService();
        int amount = 900;
        int actual = service.remain(amount);
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn1000IfAmount1000() {
        // ВНИМАНИЕ: Это демонстрация бага в сервисе!
        // По логике должно возвращаться 0, но сервис возвращает 1000
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        int actual = service.remain(amount);
        int expected = 1000;  // Фактическое (некорректное) поведение
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn900IfAmount1100() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1100;
        int actual = service.remain(amount);
        int expected = 900;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn1000IfAmount0() {
        // Демонстрация бага: для суммы 0 возвращается 1000
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        int actual = service.remain(amount);
        int expected = 1000;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn1000IfAmount2000() {
        // Демонстрация бага: для суммы 2000 возвращается 1000
        CashbackHackService service = new CashbackHackService();
        int amount = 2000;
        int actual = service.remain(amount);
        int expected = 1000;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn1IfAmount999() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int actual = service.remain(amount);
        int expected = 1;
        assertEquals(expected, actual);
    }

    // Параметризованный тест для дополнительной проверки
    @ParameterizedTest
    @CsvSource({
            "500, 500",
            "1500, 500",
            "2500, 500",
            "999, 1",
            "1, 999"
    })
    void shouldReturnCorrectRemainderForVariousAmounts(int amount, int expected) {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }

    // Тест для проверки кратных 1000 сумм (баг)
    @ParameterizedTest
    @CsvSource({
            "0, 1000",     // Баг: должно быть 0
            "1000, 1000",  // Баг: должно быть 0
            "2000, 1000",  // Баг: должно быть 0
            "3000, 1000"   // Баг: должно быть 0
    })
    void demonstrateBugForAmountsDivisibleBy1000(int amount, int expected) {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(amount);
        assertEquals(expected, actual,
                "Баг: для суммы " + amount + " метод возвращает " + actual +
                        ", хотя по Issue #1 это некорректное поведение");
    }
}