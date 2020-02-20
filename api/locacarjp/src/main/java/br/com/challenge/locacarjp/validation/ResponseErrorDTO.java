package br.com.challenge.locacarjp.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ResponseErrorDTO{
	private String field;
	private String message;
}
