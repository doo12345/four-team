package com.fourstore.pay;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PayHistory_table")
public class PayHistory {
    
    @Id
    Long id;
    String payDate;
    String orderId;
    String customerId;
    int payAmt;
    String payType;
    String payStatus;
    String address;
    int qty;
    String orderStatus;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayDate() {
        return this.payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getPayAmt() {
        return this.payAmt;
    }

    public void setPayAmt(int payAmt) {
        this.payAmt = payAmt;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return this.payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


}
