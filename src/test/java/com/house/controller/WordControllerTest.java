package com.house.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;



public class WordControllerTest {

	@Test
	public void test() {
		try {

			final WordController controller = new WordController();
			// controller.setProductManager(new SimpleProductManager());

			final ModelAndView mv = controller.listarDictonary();

			assertEquals("Vista NO valida", "dictionary", mv.getViewName());
			assertNotNull(mv.getModel().get("fecha"));

		} catch (final Exception e) {
			fail("No deberia lanzar Exception: " + e.getMessage());
		}
	}

}
