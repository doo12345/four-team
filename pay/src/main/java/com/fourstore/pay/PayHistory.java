package com.fourstore.pay;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Entity
@Table(name = "PayHistory_table")
public class PayHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PrePersist
    public void onPrePersist(){

        System.out.println(this.getClass().getName()+" : onPrePersist   -----------------start------------------");
        System.out.println("주문상태 : "+orderStatus);

        if("취소".equals(orderStatus)){
            OrderCanceled 결제취소됨 = new OrderCanceled();
            BeanUtils.copyProperties(this, 결제취소됨);
            결제취소됨.publish();

        }else{
            OrderPaid 결제승인됨 = new OrderPaid();
            BeanUtils.copyProperties(this, 결제승인됨);

            //바로 이벤트를 보내버리면 주문정보가 커밋되기도 전에 배송발송됨 이벤트가 발송되어 주문테이블의 상태가 바뀌지 않을 수 있다.
            // TX 리스너는 커밋이 완료된 후에 이벤트를 발생하도록 만들어준다.
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    결제승인됨.publish();
                }
            });


            try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(this.getClass().getName()+" : onPrePersist   -----------------END------------------");
    }

    @PostPersist
    public void OrderPaid(){
        System.out.println("%%%%%%%%%%%%%%%%S");
    }

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
