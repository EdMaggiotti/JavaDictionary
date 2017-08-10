package com.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.domain.Word;
import com.house.repository.DictionaryDAO;

@Service("productManager")
public class SimpleWordManager implements WordManager{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private DictionaryDAO dictionaryDAO;

	private List<Word> products;

	@Override
	public List<Word> getWords() {
		this.products = this.dictionaryDAO.getWords();
		return this.products;
	}

	@Override
	public Word getById(long id) {
		return this.dictionaryDAO.getById(id);
	}

	@Override
	public boolean eliminar(long id) {
		return this.dictionaryDAO.eliminar(id);
	}

	@Override
	public boolean insertar(Word w) {
		return this.dictionaryDAO.insertar(w);
	}

	@Override
	public boolean modificar(Word w) {
		return this.dictionaryDAO.modificar(w);
	}
	
	@Override
	public List<Word> getByWord(String word) {
		return this.dictionaryDAO.getByWord(word);
	}
	

}


