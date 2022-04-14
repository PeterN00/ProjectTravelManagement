package com.tm.pojo;

import com.tm.pojo.Booking;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-14T13:22:38")
@StaticMetamodel(TicketType.class)
public class TicketType_ { 

    public static volatile ListAttribute<TicketType, Booking> bookingList;
    public static volatile SingularAttribute<TicketType, Integer> discount;
    public static volatile SingularAttribute<TicketType, Boolean> type;

}