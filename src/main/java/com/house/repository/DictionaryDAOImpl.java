
package com.house.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.house.domain.Word;

import com.house.repository.mapper.WordMapper;
import com.mysql.jdbc.Statement;

@Repository("dictionaryDAOImpl")
public class DictionaryDAOImpl implements DictionaryDAO {

	private static final long serialVersionUID = 1L;
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
	}


	@Override
	public List<Word> getWords() {
		ArrayList<Word> lista = new ArrayList<Word>();
		final String SQL = "SELECT id, word, meaning FROM words;";

		try {
			lista = (ArrayList<Word>) this.jdbctemplate.query(SQL, new WordMapper());

		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen words todavia " + SQL);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return lista;
	}

	@Override
	public Word getById(long id) {
		Word w = null;
		// TODO cambiar por PreparedStatement
		final String SQL = "SELECT id, word, meaning FROM words WHERE id=" + id;
		try {
			w = this.jdbctemplate.queryForObject(SQL, new WordMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen words con ID=" + id);
			w = null;
		} catch (Exception e) {
			this.logger.error(e.getMessage());
			w = null;
		}
		return w;
	}

	@Override
	public boolean eliminar(long id) {
		boolean resul = false;
		// TODO preparedStatement
		final String SQL = "DELETE FROM `words` WHERE  `id`=" + id;

		if (1 == this.jdbctemplate.update(SQL)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean insertar(final Word w) {
		boolean resul = false;
		int affectedRows = -1;
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sqlInsert = "INSERT INTO `words` (  `word`, `meaning`) VALUES ( ? , ?  );";
		affectedRows = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				final PreparedStatement ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, w.getWord());
				ps.setString(2, w.getMeaning());
				return ps;
			}
		}, keyHolder);

		if (affectedRows == 1) {
			resul = true;
			w.setId(keyHolder.getKey().longValue());
		}

		return resul;
	}

	@Override
	public boolean modificar(Word w) {
		final String SQL = "UPDATE `words` SET `word`=? , `meaning`=? WHERE  `id`=?;";
		Object[] arguments = { w.getWord(), w.getMeaning(), w.getId() };
		int affectedRows = this.jdbctemplate.update(SQL, arguments);
		return (affectedRows == 1) ? true : false;
	}
	
	@Override
	public List<Word> getByWord(String word) {
		List<Word> words = new ArrayList<Word>();
		// TODO CAMBIAR POR preparedStatement o callableStatement
		final String SQL = "SELECT id,word,meaning FROM candidatos where word ='" + word + "'";
		try {
			words = this.jdbctemplate.query(SQL, new WordMapper());
		} catch (final EmptyResultDataAccessException e) {
			logger.warn("No word= " + word);
			words = null;
		} catch (final Exception e) {
			logger.error(e.getMessage());
			words = null;
		}

		return words;
	}

}


