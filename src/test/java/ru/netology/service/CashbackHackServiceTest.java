package ru.netology.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class CashbackHackServiceTest {

    @Test
    public void shouldReturn100IfAmount900() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(100, service.remain(900));
    }

    @Test
    public void shouldReturn1000IfAmount1000() {
        // ВНИМАНИЕ: Это демонстрация бага!
        CashbackHackService service = new CashbackHackService();
        assertEquals(1000, service.remain(1000)); // Баг: должно быть 0
    }

    @Test
    public void shouldReturn900IfAmount1100() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(900, service.remain(1100));
    }

    @Test
    public void shouldReturn1000IfAmount0() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(1000, service.remain(0)); // Баг: должно быть 0
    }

    @Test
    public void shouldReturn1000IfAmount2000() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(1000, service.remain(2000)); // Баг: должно быть 0
    }

    @Test
    public void shouldReturn1IfAmount999() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(1, service.remain(999));
    }

    @Test
    public void shouldReturn500IfAmount500() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(500, service.remain(500));
    }

    @Test
    public void shouldReturn500IfAmount1500() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(500, service.remain(1500));
    }

    @Test
    public void shouldReturn999IfAmount1() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(999, service.remain(1));
    }
}