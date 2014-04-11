package com.airhacks.rmihello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServant extends UnicastRemoteObject implements HelloService {

	protected HelloServant() throws RemoteException {
		super();
	}


	@Override
	public String echo(String input) throws RemoteException {
		System.out.println("HelloServant.echo: got input: " + input);
		return "from server: " + input;
	}
}
