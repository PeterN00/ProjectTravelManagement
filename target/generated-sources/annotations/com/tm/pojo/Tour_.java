package com.tm.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-01T18:50:19")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-30T09:36:16")
>>>>>>> 262353658113d3120e61a1bd2c3978d62d5a7469
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, Date> departureTime;
    public static volatile SingularAttribute<Tour, String> overview;
    public static volatile SingularAttribute<Tour, String> img;
    public static volatile SingularAttribute<Tour, String> departurePoint;
    public static volatile SingularAttribute<Tour, BigDecimal> price;
    public static volatile SingularAttribute<Tour, Short> night;
    public static volatile SingularAttribute<Tour, Integer> id;
    public static volatile SingularAttribute<Tour, String> title;
    public static volatile SingularAttribute<Tour, Short> day;

}