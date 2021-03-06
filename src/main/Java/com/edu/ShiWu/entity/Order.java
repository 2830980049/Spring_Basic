package com.edu.ShiWu.entity;

import java.util.Date;

public class Order {
    private String id;
    private String productsId;
    private int number;
    private double price;
    private Date createTime;
    private Date sendTime;
    private Date confirmTime;
    private String consignee;
    private String consigneePhone;
    private String consigneeAddress;
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", productsId='" + productsId + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", createTime=" + createTime +
                ", sendTime=" + sendTime +
                ", confirmTime=" + confirmTime +
                ", consignee='" + consignee + '\'' +
                ", consigneePhone='" + consigneePhone + '\'' +
                ", consigneeAddress='" + consigneeAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductsId() {
        return productsId;
    }

    public void setProductsId(String productsId) {
        this.productsId = productsId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(String id, String productsId, int number, double price, Date createTime, Date sendTime, Date confirmTime, String consignee, String consigneePhone, String consigneeAddress, String status) {
        this.id = id;
        this.productsId = productsId;
        this.number = number;
        this.price = price;
        this.createTime = createTime;
        this.sendTime = sendTime;
        this.confirmTime = confirmTime;
        this.consignee = consignee;
        this.consigneePhone = consigneePhone;
        this.consigneeAddress = consigneeAddress;
        this.status = status;
    }
}
