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
			Class<? extends IActionHandler> clazz = actionHandler.getClass();
			String name;
			if (clazz.isAnnotationPresent(Action.class)) {
				Action annotation = clazz.getAnnotation(Action.class);
				name = annotation.value();
			}
			else {
				String key = readKeyFromClass(clazz);
				name = key;
			}
			handlerMap.put(name, actionHandler);
		}
	}

	IActionHandler actionByKey(String key) {
		return handlerMap.get(key);
	}

	private String readKeyFromClass(Class<? extends IActionHandler> clazz) {
		String sn = clazz.getSimpleName();
		String key = String.valueOf(sn.charAt(0)).toLowerCase();
		key += sn.substring(1).replace("Handler", "");
		System.out.println("key =  " + key);
		return key;
	}


}
