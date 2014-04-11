package org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra;

public class ActionEvent {
	private String name;

	public ActionEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
