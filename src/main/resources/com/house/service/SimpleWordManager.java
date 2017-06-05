
package com.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.domain.Word;
import com.house.repository.DictionaryDAO;

@Service("wordManager")
public class SimpleWordManager implements WordManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DictionaryDAO dictionaryDAOImpl;

	private List<Word> words;

	@Override
	public List<Word> getWords() {
		this.words = this.dictionaryDAOImpl.getWords();
		return this.words;
	}

	@Override
	public Word getById(long id) {
		return this.dictionaryDAOImpl.getById(id);
	}

	@Override
	public boolean eliminar(long id) {
		return this.dictionaryDAOImpl.eliminar(id);
	}

	@Override
	public boolean insertar(Word w) {
		return this.dictionaryDAOImpl.insertar(w);
	}

	@Override
	public boolean modificar(Word w) {
		return this.dictionaryDAOImpl.modificar(w);
	}

}


