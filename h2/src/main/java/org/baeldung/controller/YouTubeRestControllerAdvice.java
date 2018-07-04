package org.baeldung.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class YouTubeRestControllerAdvice {

	private final Logger LOGGER = LoggerFactory.getLogger(YouTubeRestControllerAdvice.class);


	/**
	 * Convert a predefined exception to an HTTP Status code, usually for REST error
	 * handling
	 */
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict() {
		LOGGER.error("Request raised a DataIntegrityViolationException");
		// Nothing to do
	}

}