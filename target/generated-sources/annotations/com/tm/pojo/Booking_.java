package com.tm.pojo;

import com.tm.pojo.TicketType;
import com.tm.pojo.Tour;
import com.tm.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-12T20:27:49")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Date> bookDate;
    public static volatile SingularAttribute<Booking, Tour> tourId;
    public static volatile SingularAttribute<Booking, TicketType> ticketType;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, User> userId;

}