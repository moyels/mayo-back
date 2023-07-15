package top.moyel.mayo.config;

import cn.hutool.core.collection.CollectionUtil;
import lombok.NonNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.moyel.mayo.annotation.NoResult;
import top.moyel.mayo.entity.Result;
import top.moyel.mayo.utils.GenericTypeUtil;

import java.util.List;
import java.util.Objects;

/**
 * @author moyel
 */
@RestControllerAdvice
public class MayoAdvice implements ResponseBodyAdvice<Object> {
    @ExceptionHandler(BindException.class)
    public Result<Object> validExceptionHandle(BindException bindException) {
        List<ObjectError> errors = bindException.getBindingResult().getAllErrors();
        StringBuilder errorMsg = new StringBuilder();
        errors.forEach(objectError -> errorMsg.append("[").append(objectError.getDefaultMessage()).append("]"));

        return Result.failure(errorMsg.toString());
    }

    @ExceptionHandler(Exception.class)
    public Result<Object> exceptionHandle(Exception exception) {
        return Result.failure(exception.getLocalizedMessage());
    }

    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return !GenericTypeUtil.equalsAny(returnType.getParameterType(), CollectionUtil.newArrayList(Result.class, ModelAndView.class, void.class)) && !Objects.nonNull(returnType.getMethodAnnotation(NoResult.class));
    }

    @Override
    public Object beforeBodyWrite(
            Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType,
            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response
    ) {
        if (Objects.isNull(body)) {
            return Result.failure();
        }

        if (body instanceof Boolean) {
            return ((Boolean) body) ? Result.success(true) : Result.failure();
        }

        return Result.success(body);
    }
}
