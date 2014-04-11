package org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers;

import org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra.ActionEvent;
import org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra.ActionName;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;

@Singleton
public class LoadHandler {

	public void handleLoad(@Observes @ActionName("load") ActionEvent actionEvent) {
		System.out.println("actionEvent = " + actionEvent.getName());
	}
}
