package com.tm.pojo;

import com.tm.pojo.Booking;
import com.tm.pojo.NewsComment;
import com.tm.pojo.TourReview;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-11T20:21:21")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> img;
    public static volatile SingularAttribute<User, String> role;
    public static volatile ListAttribute<User, Booking> bookingList;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, NewsComment> newsCommentList;
    public static volatile ListAttribute<User, TourReview> tourReviewList;
    public static volatile SingularAttribute<User, String> username;

}