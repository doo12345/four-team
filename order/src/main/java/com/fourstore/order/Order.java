package com.fourstore.order;
import javax.persistence.*;

import com.fourstore.external.Pay;
import com.fourstore.external.PayService;

@Entity
@Table(name="order_table")
public class Order {
    @Id
    private Long id;
    private String customerid;
    private String menuid;
    private int qty;
    private String price;
    private String address;
    private String phonenumber;
    private String status;

    @PostPersist
    private void publishOrderCreated(){
            OrderCreated orderCreated = new OrderCreated(this);
            orderCreated.publish();

            // Pay pay = new Pay();

            // pay.setOrderId(String.valueOf(getId()));
            // if(getPrice()!=null)
            //     pay.setPayAmt(Integer.valueOf(getPrice()));
    
            // Application.applicationContext.getBean(PayService.class).pay(pay);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerid() {
        return this.customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getMenuid() {
        return this.menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
