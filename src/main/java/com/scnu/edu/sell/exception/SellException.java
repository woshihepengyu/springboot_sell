package com.scnu.edu.sell.exception;


import com.scnu.edu.sell.enums.ResultEnum;

/**
 * Created by hepengyu in 0826 08:44
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
