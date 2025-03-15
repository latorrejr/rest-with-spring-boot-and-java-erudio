package br.com.alatorre.excepion;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

}
