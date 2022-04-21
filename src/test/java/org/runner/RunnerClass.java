package org.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LoginPageJnit.class,HotelSelectionPage.class,BookingConfirmPage.class})
public class RunnerClass {

}
