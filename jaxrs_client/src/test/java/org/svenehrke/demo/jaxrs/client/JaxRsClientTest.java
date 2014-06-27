package org.svenehrke.demo.jaxrs.client;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JaxRsClientTest {

	private Client client;
	private WebTarget tut;

	@Before
	public void setUp() throws Exception {
		client = ClientBuilder.newClient();
		tut = client.target("http://airhacks.com");

	}

	@Test
	public void isJavaEEWorkshop() throws Exception {
		String content = tut.request(MediaType.TEXT_HTML).get(String.class);
		assertTrue(content.contains("java"));
		assertFalse(content.contains("scala"));

	}

	@Test
	public void asyncInvocation() throws Exception {
		tut.request(MediaType.TEXT_HTML).async().get(new InvocationCallback<String>() {
			@Override
			public void completed(String response) {
				System.out.println("response = " + response);
			}

			@Override
			public void failed(Throwable throwable) {
				throw new RuntimeException("not implemented yet");
			}
		});
		Thread.sleep(2000);

	}
}
