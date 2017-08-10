package com.house.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.house.domain.Word;
import com.house.form.SearchItemForm;
import com.house.service.WordManager;

@Controller
public class WordController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private WordManager wordManager;

	
	@RequestMapping(value = "/dictionary", method = RequestMethod.GET)
	public ModelAndView listarDictonary() throws ServletException, IOException {

		this.logger.info("procesando peticion");
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("words", this.wordManager.getWords());
		model.put("fecha", new Date().toString());

		return new ModelAndView("word/word", model);
	}

	// NEW
	@RequestMapping(value = "/word/new", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario() {
		this.logger.trace("Mostrar formulario crear nueva palabra");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("word", new Word());
		model.put("isNew", true);
		return new ModelAndView("word/formulario", model);
	}
	
	
	// DETAIL
	@RequestMapping(value = "/word/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView verDetalle(@PathVariable(value = "id") final long id) {
		this.logger.trace("Mostrando detalle word[" + id + "]....");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("word", this.wordManager.getById(id));
		model.put("isNew", false);
		return new ModelAndView("word/formulario", model);
	}
	
	// SEARCH
	@RequestMapping(value = "/dictionary/buscar", method = RequestMethod.GET, params = "word")
	public ModelAndView buscar(String word) throws ServletException, IOException {
		this.logger.trace("Mostrando word[" + word + "]....");

		final Map<String, Object> model = new HashMap<String, Object>();
		final SearchItemForm searchItemForm = new SearchItemForm();
		final String msgBusqueda = "Word no encontrada";
		boolean existeMsgWord = false;

		final List<Word> wordsByWord = this.wordManager.getByWord(word);

		model.put("searchItemForm", searchItemForm);
		model.put("word", wordsByWord);

		if (wordsByWord.size() == 0) {
			existeMsgWord = true;
			model.put("msgBusqueda", msgBusqueda);
		}
		model.put("existeMsgWord", existeMsgWord);
		this.logger.info("Listados words");

		return new ModelAndView("word/word", model);
	}
	
	// SAVE
	@RequestMapping(value = "/word/save", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Word word, BindingResult bindingResult) {
		this.logger.trace("Salvando palabra....");
		Map<String, Object> model = new HashMap<String, Object>();
		String view = "word/formulario";

		if (bindingResult.hasErrors()) {
			this.logger.warn("parametros no validos");
			model.put("isNew", word.isNew());
		} else {
			if (word.isNew()) {
				this.wordManager.insertar(word);
			} else {
				this.wordManager.modificar(word);
			}
			model.put("words", this.wordManager.getWords());
			model.put("msg", "Palabra guardada con exito");
			view = "word/word";
		}
		return new ModelAndView(view, model);
	}

	
	// DELETE
	@RequestMapping(value = "/word/eliminar/{id}", method = RequestMethod.GET)
	public ModelAndView eliminar(@PathVariable(value = "id") final long id) throws ServletException, IOException {
		this.logger.trace("Eliminando word[" + id + "]....");

		String msg = "No eliminado word[" + id + "]";
		if (this.wordManager.eliminar(id)) {
			msg = "word[" + id + "] eliminado";
			this.logger.info(msg);
		} else {
			this.logger.warn(msg);
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", msg);
		model.put("words", this.wordManager.getWords());

		return new ModelAndView("word/word", model);
	}

}

