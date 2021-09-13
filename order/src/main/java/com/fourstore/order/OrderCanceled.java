package com.fourstore.order;

public class OrderCanceled extends AbstractEvent {

    private Long id;

    public OrderCanceled(){
        super();
    }

    public OrderCanceled(Order order){
        this();
        this.setId(order.getId());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
