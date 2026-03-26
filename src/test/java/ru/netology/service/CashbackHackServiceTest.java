package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CashbackHackServiceTest {

    @Test
    public void shouldReturn100IfAmount900() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(service.remain(900), 100);
    }

    @Test
    public void shouldReturn0IfAmount1000() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(service.remain(1000), 0); // этот тест упадёт
    }

    @Test
    public void shouldReturn900IfAmount1100() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(service.remain(1100), 900);
    }

    @Test
    public void shouldReturn1IfAmount999() {
        CashbackHackService service = new CashbackHackService();
        assertEquals(service.remain(999), 1);
    }
}
