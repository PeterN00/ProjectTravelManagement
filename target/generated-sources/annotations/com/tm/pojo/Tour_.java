package com.tm.pojo;

import com.tm.pojo.Booking;
import com.tm.pojo.TourHighlight;
import com.tm.pojo.TourItinerary;
import com.tm.pojo.TourReview;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-17T13:27:37")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, Date> departureTime;
    public static volatile SingularAttribute<Tour, Integer> duration;
    public static volatile SingularAttribute<Tour, String> overview;
    public static volatile SingularAttribute<Tour, String> img;
    public static volatile ListAttribute<Tour, TourItinerary> tourItineraryList;
    public static volatile SingularAttribute<Tour, String> departurePoint;
    public static volatile ListAttribute<Tour, TourHighlight> tourHighlightList;
    public static volatile SingularAttribute<Tour, BigDecimal> price;
    public static volatile ListAttribute<Tour, Booking> bookingList;
    public static volatile SingularAttribute<Tour, Integer> id;
    public static volatile SingularAttribute<Tour, String> title;
    public static volatile ListAttribute<Tour, TourReview> tourReviewList;

}