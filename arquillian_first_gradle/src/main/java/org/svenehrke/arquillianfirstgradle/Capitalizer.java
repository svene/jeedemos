package org.svenehrke.arquillianfirstgradle;

import javax.inject.Singleton;

@Singleton
public class Capitalizer {

	public String toUpperCase(String input) {
		return input.toUpperCase();
	}

}
