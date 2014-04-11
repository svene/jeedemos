package org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra;

import javax.enterprise.util.AnnotationLiteral;

public class ActionQualifier extends AnnotationLiteral<ActionName> implements ActionName {
	private final String actionName;

	public ActionQualifier(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String value() {
		return actionName;
	}
}
