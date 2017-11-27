package com.zzk.jdbc;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void test1() {
        Calculator c = new Calculator();
        Assert.assertEquals(c.add(1,2),3);
    }

}
