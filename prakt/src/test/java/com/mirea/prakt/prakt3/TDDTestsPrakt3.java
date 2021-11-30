package com.mirea.prakt.prakt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDDTestsPrakt3 {

    @Test
    void test_zapusk()
    {
        Main main = new Main();
        main.main(null);
        assertEquals(0,0);
    }
}
