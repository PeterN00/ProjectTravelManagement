package com.tm.pojo;

import com.tm.pojo.Ticket;
import com.tm.pojo.Tour;
import com.tm.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-01T18:50:19")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-30T09:36:16")
>>>>>>> 262353658113d3120e61a1bd2c3978d62d5a7469
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile ListAttribute<Booking, Ticket> ticketList;
    public static volatile SingularAttribute<Booking, Tour> tourId;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, User> userId;

}