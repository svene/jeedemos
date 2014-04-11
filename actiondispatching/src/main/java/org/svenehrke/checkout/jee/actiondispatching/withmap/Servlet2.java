package org.svenehrke.checkout.jee.actiondispatching.withmap;

import org.svenehrke.checkout.jee.actiondispatching.withruntimequalifiers.infra.ActionEvent;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/servlet2"}) // open browser at: http://localhost:8080/cdiactions1/servlet2?action=load
public class Servlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	@Inject
	ActionHandlerRegistry actionHandlerRegistry;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getParameter("action") == null ? "-" : req.getParameter("action");

		// Select appropriate action for request parameter 'action' and fire event for it:
		IActionHandler actionHandler = actionHandlerRegistry.actionByKey(action);
		if (actionHandler != null) {
			resp.getWriter().write(String.format("Action: '%s' found.", action));
			actionHandler.handle();
		} else {
			resp.getWriter().write(String.format("Action: '%s' not found!", action));
		}

		resp.getWriter().flush();
		resp.getWriter().close();
	}
}
