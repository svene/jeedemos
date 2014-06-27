package org.svenehrke.arquillianfirstgradle;

import javax.inject.Inject;

/**
 * A component for creating personal greetings.
 */
public class Greeter {


	@Inject
	Capitalizer capitalizer;

	public String createGreeting(String name) {
		return "Hello, " + name + "!";
	}

//	public String capitalizedGreeting(String name) {
//		return "Hello, " + capitalizer.toUpperCase(name) + "!";
//	}
}
