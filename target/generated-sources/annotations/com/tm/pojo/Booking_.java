package com.tm.pojo;

import com.tm.pojo.TicketType;
import com.tm.pojo.Tour;
import com.tm.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-07T10:54:55")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Tour> tourId;
    public static volatile SingularAttribute<Booking, TicketType> ticketType;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, User> userId;

}