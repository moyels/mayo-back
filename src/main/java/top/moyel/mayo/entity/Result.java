package top.moyel.mayo.entity;

import lombok.Data;

/**
 * @author moyel
 */
@Data
public class Result<T> {
    private Integer code;
    private Boolean success;
    private String message;
    private String timestamp;
    private T data;

    private static final Boolean SUCCESS = true;
    private static final Boolean FAILURE = false;
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer FAILURE_CODE = 500;
    private static final String SUCCESS_MSG = "操作成功！";
    private static final String FAILURE_MSG = "操作失败！";

    public static <R> Result<R> failure() {
        return failure(FAILURE_MSG);
    }

    public static <R> Result<R> failure(String message) {
        return failure(message, null);
    }

    public static <R> Result<R> failure(String message, R data) {
        return new Result<>(FAILURE_CODE, FAILURE, message, data);
    }

    public static <R> Result<R> success(R data) {
        return success(SUCCESS_MSG, data);
    }

    public static <R> Result<R> success(String message, R data) {
        return success(SUCCESS_CODE, message, data);
    }

    public static <R> Result<R> success(Integer code, String message, R data) {
        return new Result<>(code, SUCCESS, message, data);
    }

    public Result(Integer code, Boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.timestamp = genTimestamp();
        this.data = data;
    }

    private static String genTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }
}
