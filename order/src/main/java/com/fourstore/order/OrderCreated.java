package com.fourstore.order;

public class OrderCreated extends AbstractEvent {
    private Long id;
    private String customerid;
    private String customername;
    private String menuid;
    private int qty;
    private String price;
    private String address;
    private String phonenumber;

    public OrderCreated(){
        super();
    }

    public OrderCreated(Order order){
        this();
        this.setId(order.getId());
        this.setMenuid(order.getMenuid());
        this.setAddress(order.getAddress());
        this.setCustomerid(order.getCustomerid());
        this.setPhonenumber(order.getPhonenumber());
        this.setPrice(order.getPrice());
        this.setQty(order.getQty());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    

}
