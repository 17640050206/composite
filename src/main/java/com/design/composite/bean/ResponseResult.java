package com.design.composite.bean;



/**
 * @Author liuyajun
 * @Description 接口返回类
 **/
public class ResponseResult<T>  {

    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this(CoreConstants.SUCCESS, "成功", data);
    }

    /**
     * .
     *
     * @param code    响应编码
     * @param message 响应信息
     * @param data    响应数据
     */
    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(data);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<T>(-1, message, null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}