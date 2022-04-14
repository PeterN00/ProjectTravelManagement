package com.tm.pojo;

import com.tm.pojo.NewsComment;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-14T13:22:38")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Date> date;
    public static volatile SingularAttribute<News, String> description;
    public static volatile SingularAttribute<News, Integer> id;
    public static volatile SingularAttribute<News, String> title;
    public static volatile ListAttribute<News, NewsComment> newsCommentList;

}