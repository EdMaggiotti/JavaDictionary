
package com.house.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Word implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private long id;

	@NotNull
	@Size(min = 1, max = 255)
	private String word;

	@Size(min = 1, max = 255)
	private String meaning;

	public Word() {
		super();
		this.id = 0;
		this.word = "";
		this.meaning = "";
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public boolean isNew() {
		return (this.id == 0) ? true : false;
	}

	@Override
	public String toString() {
		return "Word [id=" + this.id + ", word=" + this.word + ", meaning=" + this.meaning + "]";
	}

}
