package com.tm.pojo;

import com.tm.pojo.Booking;
import com.tm.pojo.TicketType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-29T15:40:18")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, TicketType> ticketType;
    public static volatile SingularAttribute<Ticket, Integer> id;
    public static volatile SingularAttribute<Ticket, Booking> bookingId;

}