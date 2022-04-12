package com.tm.pojo;

import com.tm.pojo.News;
import com.tm.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-12T20:27:49")
@StaticMetamodel(NewsComment.class)
public class NewsComment_ { 

    public static volatile SingularAttribute<NewsComment, News> newsId;
    public static volatile SingularAttribute<NewsComment, String> comment;
    public static volatile SingularAttribute<NewsComment, Integer> id;
    public static volatile SingularAttribute<NewsComment, Date> time;
    public static volatile SingularAttribute<NewsComment, User> userId;

}