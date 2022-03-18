package com.tm.pojo;

import com.tm.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-17T13:27:37")
@StaticMetamodel(TicketType.class)
public class TicketType_ { 

    public static volatile ListAttribute<TicketType, Ticket> ticketList;
    public static volatile SingularAttribute<TicketType, Short> discount;
    public static volatile SingularAttribute<TicketType, Boolean> type;

}