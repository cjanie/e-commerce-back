package com.oc_p8.ecommerce.ordercycle.businesslogic.enums;

public enum OrderState {

    RECEIPT {
        @Override
        public <E> E accept(OrderStateVisitor<E> visitor) {
            return visitor.visitReceipt();
        }
    },
    PREPARATION {
        @Override
        public <E> E accept(OrderStateVisitor<E> visitor) {
            return visitor.visitPreparation();
        }
    },
    READY {
        @Override
        public <E> E accept(OrderStateVisitor<E> visitor) {
            return visitor.visitReady();
        }
    };

    public abstract <E> E accept(OrderStateVisitor<E> visitor);

}
