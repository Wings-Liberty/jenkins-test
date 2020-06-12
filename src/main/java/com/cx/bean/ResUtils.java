package com.cx.bean;


/**
 * 统一返回结果集
 * Created by CX on 2020/3/8
 *
 * @param <T>
 * @author CX
 */
public class ResUtils<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回的字符串信息
     */
    private String msg;

    /**
     * 返回的对象
     */
    private T data;

    public static ResUtils success(){

        ResUtils resultUtils = new ResUtils();
        resultUtils.setCode(200);
        resultUtils.setMsg("成功");
        resultUtils.setData("");

        return resultUtils;
    }

    public static ResUtils success(Object data){

        ResUtils resultUtils = new ResUtils();
        resultUtils.setCode(200);
        resultUtils.setMsg("成功");
        resultUtils.setData(data);

        return resultUtils;
    }

    public static ResUtils failure(Integer code) {

        ResUtils resultUtils = new ResUtils();
        resultUtils.setCode(code);
        resultUtils.setMsg("失败");
        resultUtils.setData("");

        return resultUtils;
    }

    public static ResUtils failure(String msg) {

        ResUtils resultUtils = new ResUtils();
        resultUtils.setCode(100);
        resultUtils.setMsg(msg);
        resultUtils.setData("");

        return resultUtils;
    }

    public static ResUtils failure(Integer code, String msg) {

        ResUtils resultUtils = new ResUtils();
        resultUtils.setCode(code);
        resultUtils.setMsg(msg);
        resultUtils.setData("");

        return resultUtils;
    }

    public Integer getCode() {
        return code;
    }

    public ResUtils<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResUtils<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResUtils<T> setData(T data) {
        this.data = data;
        return this;
    }
}