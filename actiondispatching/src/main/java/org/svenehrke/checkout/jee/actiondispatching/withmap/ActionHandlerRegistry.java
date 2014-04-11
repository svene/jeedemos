package org.svenehrke.checkout.jee.actiondispatching.withmap;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ActionHandlerRegistry {

	@Inject
	Instance<IActionHandler> actionHandlers;

	private Map<String, IActionHandler> handlerMap = new HashMap<>();

	@PostConstruct
	void initialize() {
		for (IActionHandler actionHandler : actionHandlers) {
			String sn = actionHandler.getClass().getSimpleName();
			String key = String.valueOf(sn.charAt(0)).toLowerCase();
			key += sn.substring(1).replace("Handler", "");
			System.out.println("key =  " + key);
			handlerMap.put(key, actionHandler);
		}
	}


	IActionHandler actionByKey(String key) {
		return handlerMap.get(key);
	}


}
