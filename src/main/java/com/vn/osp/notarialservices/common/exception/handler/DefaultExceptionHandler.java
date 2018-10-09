package com.vn.osp.notarialservices.common.exception.handler;

import com.vn.osp.notarialservices.common.error.ErrorResource;
import com.vn.osp.notarialservices.common.error.FieldErrorResource;
import com.vn.osp.notarialservices.common.exception.BadRequestException;
import com.vn.osp.notarialservices.common.exception.ObjectAlreadyExistsException;
import com.vn.osp.notarialservices.common.exception.ObjectExpiredException;
import com.vn.osp.notarialservices.common.exception.ObjectNotFoundException;
import com.vn.osp.notarialservices.user.exception.PrincipalUserMismatchException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(DefaultExceptionHandler.class);

	@ExceptionHandler({ PrincipalUserMismatchException.class, UnauthorizedUserException.class })
	public ResponseEntity<Object> handleUnAuthorizedRequestException(RuntimeException ex, WebRequest request) {
        ErrorResource error = new ErrorResource("Unauthorized ContractHistoryInfor", ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, error, headers, HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler({ InvalidRequestException.class })
	protected ResponseEntity<Object> handleInvalidRequest(BadRequestException ire, WebRequest request) {
		List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

		List<FieldError> fieldErrors = ire.getErrors().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			FieldErrorResource fieldErrorResource = new FieldErrorResource(
					fieldError.getObjectName(),
					fieldError.getField(),
					fieldError.getCode(),
					fieldError.getDefaultMessage());

			fieldErrorResources.add(fieldErrorResource);
		}

		ErrorResource error = new ErrorResource("InvalidRequest", ire.getMessage());
		error.setFieldErrors(fieldErrorResources);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(ire, error, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ ObjectExpiredException.class })
	public ResponseEntity<Object> handleRequestException(Exception ex, WebRequest request) {
		ErrorResource error = new ErrorResource("Bad Request", ex.getMessage());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ ObjectNotFoundException.class })
	public ResponseEntity<Object> handleNotFountException(RuntimeException ex, WebRequest request) {
		ErrorResource error = new ErrorResource("Not Found", ex.getMessage());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex, error, headers, HttpStatus.NOT_FOUND, request);
	}

	/*@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<Object> handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException ex, WebRequest request) throws IOException {
		ErrorResource error = new ErrorResource("Unsupported Media Type", ex.getLocalizedMessage() + ". Supported types: " + ex.getSupportedMediaTypes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex, error, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE, request);
	}*/

	@ExceptionHandler({ObjectAlreadyExistsException.class })
	public ResponseEntity<Object> handleConflictException(RuntimeException ex, WebRequest request) {
		ErrorResource error = new ErrorResource("Conflict Error", ex.getMessage());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex, error, headers, HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
		LOGGER.error("Internal Server Error", ex);
        ErrorResource error = new ErrorResource("Unknown Error", ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}