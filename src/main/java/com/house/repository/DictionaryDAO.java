
package com.house.repository;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import com.house.domain.Word;


public interface DictionaryDAO extends Serializable {

	List<Word> getWords();

	Word getById(long id);
	
	List<Word> getByWord(String word);

	boolean eliminar(long id);

	boolean insertar(Word w);

	boolean modificar(Word w);

	void setDataSource(DataSource dataSource);

}

