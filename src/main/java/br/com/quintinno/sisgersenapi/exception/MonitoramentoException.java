package br.com.quintinno.sisgersenapi.exception;

import br.com.quintinno.sisgersenapi.dto.ExceptionResponseDTO;
import br.com.quintinno.sisgersenapi.utility.ConstantesUtility;
import br.com.quintinno.sisgersenapi.utility.DateUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MonitoramentoException {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ExceptionResponseDTO> emptyResultDataAccessException(
            EmptyResultDataAccessException emptyResultDataAccessException, HttpServletRequest httpServletRequest) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                HttpStatus.NOT_FOUND.name(), ConstantesUtility.OBJETO_NAO_ENCONTRADO, DateUtility.gerarDataFormatada(DateUtility.FORMAT0001));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }

}

