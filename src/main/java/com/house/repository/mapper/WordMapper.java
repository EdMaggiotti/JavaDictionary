
package com.house.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.house.domain.Word;

public class WordMapper implements RowMapper<Word> {

	@Override
	public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
		Word w = new Word();
		w.setId(rs.getLong("id"));
		w.setWord(rs.getString("word"));
		w.setMeaning(rs.getString("meaning"));
		return w;
	}

}


