package org.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class RunnerClassJunitCore {
	public static void main(String[] args) {
		Result runClasses = JUnitCore.runClasses(LoginPageJnit.class,HotelSelectionPage.class,BookingConfirmPage.class);
		System.out.println(runClasses.getRunCount());
		System.out.println(runClasses.getRunTime());
		System.out.println(runClasses.getIgnoreCount());
		System.out.println(runClasses.getFailureCount());
		System.out.println(runClasses.getFailures());
		
	}

}
