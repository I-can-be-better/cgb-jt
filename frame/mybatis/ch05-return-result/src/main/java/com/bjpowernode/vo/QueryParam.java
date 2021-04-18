package com.bjpowernode.vo;

/**
 * @author X
 * date 2021/4/16 10:53:11
 */

/**
 * 本类用于保存student的名字和age值
 */
public class QueryParam {
    private String paramName;
    private Integer paramAge;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }
}
