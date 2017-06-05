package com.house.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class WordTest {

	private Word word;

	@Before
	public void setUp() throws Exception {
		this.word = new Word();
	}

	@Test
	public void testSetAndGetWord() {
		assertNull(this.word.getWord());
		final String testWord = "aDescription";
		this.word.setWord(testWord);
		assertEquals(testWord, this.word.getWord());
	}

	@Test
	public void testSetAndGetMeaning() {
		final String testMeaning = "";
		this.word.setMeaning(testMeaning);
		assertEquals(testMeaning, this.word.getMeaning(), 0);
	}

}
