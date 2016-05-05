package com.guille.al.labs.Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.guille.al.labs.lab_4.coins.FakeCoinsTest;
import com.guille.al.labs.lab_6.MinimizeCashFlowTest;
import com.guille.al.labs.lab_7.RoadsInCityTest;
import com.guille.al.labs.lab_8.NonogramTest;
import com.guille.al.labs.lab_9.TimeMeasure;

@RunWith(Suite.class)
@SuiteClasses({ FakeCoinsTest.class, MinimizeCashFlowTest.class, RoadsInCityTest.class, NonogramTest.class,
	TimeMeasure.class })
public class AllTests {
}
