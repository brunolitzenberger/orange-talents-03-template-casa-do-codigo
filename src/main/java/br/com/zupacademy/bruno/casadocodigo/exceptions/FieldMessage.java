package br.com.zupacademy.bruno.casadocodigo.exceptions;

public class FieldMessage {

	private String fieldName;
	private String message;

	public FieldMessage() {

	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}


	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}

}
