package org.svenehrke.jeedemos.scheduleratstartup;

import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless
@Startup
public class Bootstrapper {

	@Schedule(second="*", minute="*",hour="*", persistent=false)
	public void doWork(){
		System.out.println("timer: " + new Date());
	}

}
