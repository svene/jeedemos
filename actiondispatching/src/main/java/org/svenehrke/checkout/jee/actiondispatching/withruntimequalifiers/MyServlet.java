package org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers;

import org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra.ActionEvent;
import org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra.ActionQualifier;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/servlet1"}) // open browser at: http://localhost:8080/cdiactions1/servlet1?action=load
public class MyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	@Inject @Any
	Event<ActionEvent> actionEventDispatcher;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getParameter("action") == null ? "-" : req.getParameter("action");

		// Select appropriate action for request parameter 'action' and fire event for it (see LoadHandler for a listener example):
		actionEventDispatcher.select(new ActionQualifier(action)).fire(new ActionEvent(action));

		resp.getWriter().write("Action: " + action);
		resp.getWriter().flush();
		resp.getWriter().close();
	}
}
