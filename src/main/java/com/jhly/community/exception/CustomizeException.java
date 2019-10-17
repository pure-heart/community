package com.jhly.community.exception;

/**自定义异常类
 * @Auther:JHLY
 * @Date:2019/10/16
 * @Description:com.jhly.community.exception
 * @Version:1.0
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(String message){
        this.message = message;
    }
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
