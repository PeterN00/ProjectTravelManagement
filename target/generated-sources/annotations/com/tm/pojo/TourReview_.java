package com.tm.pojo;

import com.tm.pojo.Tour;
import com.tm.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-29T18:12:08")
@StaticMetamodel(TourReview.class)
public class TourReview_ { 

    public static volatile SingularAttribute<TourReview, Short> rate;
    public static volatile SingularAttribute<TourReview, Tour> tourId;
    public static volatile SingularAttribute<TourReview, String> comment;
    public static volatile SingularAttribute<TourReview, Integer> id;
    public static volatile SingularAttribute<TourReview, User> userId;

}