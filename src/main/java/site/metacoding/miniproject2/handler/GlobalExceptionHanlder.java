package site.metacoding.miniproject2.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import site.metacoding.miniproject2.dto.CMRespDto;

@ControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler
	public @ResponseBody CMRespDto<?> apiError(Exception e){
		return new CMRespDto<>(-1, e.getMessage(), null);
	}
}
