package br.com.course.spring3rest.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String details;
}
