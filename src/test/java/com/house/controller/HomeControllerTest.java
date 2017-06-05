package com.house.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.house.controller.HomeController;

public class HomeControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHome() {
		final HomeController hc = new HomeController();
		final Locale locale = new Locale("es", "es");
		final Model model = null;// new Model();
		assertEquals("No retorna el String de la Vista 'home.jsp' ", "home", hc.home(locale, model));
	}

}
