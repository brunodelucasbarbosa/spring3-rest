package br.com.course.spring3rest.exception;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public UnsupportedMathOperationException(String message) {
		super(message);
	}
}
