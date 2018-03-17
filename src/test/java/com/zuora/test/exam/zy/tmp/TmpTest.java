package com.zuora.test.exam.zy.tmp;

import org.testng.ITest;
import org.testng.annotations.Test;

/**
 * Created by kaiser_zhao on 3/15/18.
 */
public class TmpTest  implements ITest {
    @Override
    public String getTestName() {
        return null;
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("slow test");
    }
}
