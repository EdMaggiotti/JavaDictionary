package com.house.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.house.domain.Word;


public class SimpleProductManagerTests {

	private SimpleWordManager wordManager;

	private List<Word> words;

	private static int WORD_COUNT = 2;

	private static String CHAIR_WORD = "Silla";
	private static String CHAIR_MEANING = "Chair";

	private static String TABLE_WORD = "Mesa";
	private static String TABLE_MEANING = "Table";

	@Before
	public void setUp() throws Exception {
		this.wordManager = new SimpleWordManager();
		this.words = new ArrayList<Word>();

		// stub up a list of words
		Word word = new Word();
		word.setWord(CHAIR_WORD);
		word.setMeaning(CHAIR_MEANING);
		this.words.add(word);

		word = new Word();
		word.setWord(TABLE_WORD);;
		word.setMeaning(TABLE_MEANING);
		this.words.add(word);

		// this.productManager.setProducts(this.products);

	}

	@Test
	public void testGetProductsWithNoProducts() {
		this.wordManager = new SimpleWordManager();
		assertNull(this.wordManager.getWords());
	}

	@Test
	public void testGetWords() {
		final List<Word> words = this.wordManager.getWords();
		assertNotNull(words);
		assertEquals(WORD_COUNT, this.wordManager.getWords().size());

		Word word = words.get(0);
		assertEquals(CHAIR_WORD, word.getWord());
		assertEquals(CHAIR_MEANING, word.getMeaning());

		word = words.get(1);
		assertEquals(TABLE_WORD, word.getWord());
		assertEquals(TABLE_MEANING, word.getMeaning());
	}

}
