package com.house.form;

public class SearchItemForm {
	
	private String word;

	/**
	 * @param word
	 */
	public SearchItemForm(String word) {
		super();
		this.word = word;
	}

	/**
	 * 
	 */
	public SearchItemForm() {
		super();
		this.word = "";
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return this.word;
	}

	/**
	 * @param word
	 *            the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
}
