package com.barisdere.unittest.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AssertKolayTest.class,
    AssertTest.class,
    ParametreTest.class,
    YasamDongusuTest.class
}
)
public class SuiteTest {

}
