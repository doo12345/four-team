package com.fourstore.order.external;

public class Pay {

    private Long id;
    private String orderId;
    private int payAmt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public int getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(int payAmt) {
        this.payAmt = payAmt;
    }

}

