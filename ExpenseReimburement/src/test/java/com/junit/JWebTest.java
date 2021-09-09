package com.junit;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
 
import org.junit.*;

import com.factory.Log4jConfig;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class JWebTest {
	
	@Before
	public void prepare() {
		setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		setBaseUrl("http://localhost:8080/ExpenseReimburement");
	}
	@Test
	public void testHome() {
		beginAt("home.html");
		assertTitleEquals("Mirabilis Home Page");
		assertLinkPresent("login");
		assertLinkPresent("register");
		
	}
	
	@Test
    public void testPerformSomeTask() throws Exception {
        Log4jConfig log4J = new Log4jConfig();
        log4J.performSomeTask();
    }
	

}
