/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "news_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsComment.findAll", query = "SELECT n FROM NewsComment n"),
    @NamedQuery(name = "NewsComment.findById", query = "SELECT n FROM NewsComment n WHERE n.id = :id"),
    @NamedQuery(name = "NewsComment.findByComment", query = "SELECT n FROM NewsComment n WHERE n.comment = :comment"),
    @NamedQuery(name = "NewsComment.findByTime", query = "SELECT n FROM NewsComment n WHERE n.time = :time")})
public class NewsComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{emptyFieldErr}")
    @Size(min = 1, max = 255)
    @Column(name = "comment")
    private String comment;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date time;
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    @ManyToOne
    private News newsId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public NewsComment() {
    }

    public NewsComment(Integer id) {
        this.id = id;
    }

    public NewsComment(Integer id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public News getNewsId() {
        return newsId;
    }

    public void setNewsId(News newsId) {
        this.newsId = newsId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsComment)) {
            return false;
        }
        NewsComment other = (NewsComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tm.pojo.NewsComment[ id=" + id + " ]";
    }
    
}
