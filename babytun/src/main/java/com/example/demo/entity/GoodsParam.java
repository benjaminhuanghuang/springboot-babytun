package com.example.demo.entity;

public class GoodsParam {
    private Long gpId;
    private Long goodsId;

    private String gpParamName;
    private String gpParamValue;
    private Integer gpOrder;

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGpParamName() {
        return gpParamName;
    }

    public void setGpParamName(String gpParamName) {
        this.gpParamName = gpParamName;
    }

    public String getGpParamValue() {
        return gpParamValue;
    }

    public void setGpParamValue(String gpParamValue) {
        this.gpParamValue = gpParamValue;
    }

    public Integer getGpOrder() {
        return gpOrder;
    }

    public void setGpOrder(Integer gpOrder) {
        this.gpOrder = gpOrder;
    }
}
