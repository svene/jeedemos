package org.svenehrke.webgradlejee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestResource {

	@GET
	public String show() {
		return "gradle rocks!";
	}

}
