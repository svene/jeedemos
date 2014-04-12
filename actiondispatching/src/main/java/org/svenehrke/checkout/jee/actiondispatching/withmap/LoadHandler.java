package org.svenehrke.checkout.jee.actiondispatching.withmap;

import javax.inject.Singleton;

@Singleton
@Action("load")
public class LoadHandler implements IActionHandler {


	@Override
	public void handle() {
		System.out.println("LoadHandler.handle");
	}
}
