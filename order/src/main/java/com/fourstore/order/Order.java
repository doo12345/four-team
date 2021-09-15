package com.fourstore.order;
import java.util.Optional;

import javax.persistence.*;

import com.fourstore.order.external.Pay;

@Entity
@Table(name="order_table")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
            System.out.println(this.getClass().getName()+" : publishOrderCreated   -----------------start------------------");
            Pay pay = new Pay();

            pay.setOrderId(String.valueOf(getId()));
            if(getPrice()!=null) pay.setPayAmt(Integer.valueOf(getPrice()));
            System.out.println("customerid : "+this.customerid);
            pay.setCustomerId(this.customerid);
            if(getAddress()!=null) pay.setAddress(getAddress());
            pay.setOrderStatus("주문");
            pay.setPayType("주문유형");

            //Req/Res 동기호출
            Application.applicationContext.getBean(com.fourstore.order.external.PayService.class).pay(pay);
            
            //kafka에 발송하는 함수 호출 publish
            OrderCreated orderCreated = new OrderCreated(this);
            orderCreated.publish();
            System.out.println(this.getClass().getName()+" : publishOrderCreated   -----------------END------------------");
    }

    @PostUpdate
    private void publishOrderCancelled(){
        if( "주문취소".equals(this.getStatus())){
            // 이벤트를 발송하기 위하여 주문의 상세 정보를 조회

            OrderRepository orderRepository = Application.applicationContext.getBean(OrderRepository.class);
            Optional<Order> orderOptional = orderRepository.findById(this.getId());
            Order order = orderOptional.get();

            //kafka에 발송하는 함수 호출
            OrderCanceled orderCancelled = new OrderCanceled(order);
            orderCancelled.publish();
        }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
