package com.house.service;

import java.util.List;

import com.house.domain.Word;


public interface WordManager {
	
	public List<Word> getWords();

	Word getById(long id);
	
	List<Word> getByWord(String word);

	boolean eliminar(long id);

	boolean insertar(Word w);

	boolean modificar(Word w);

}
