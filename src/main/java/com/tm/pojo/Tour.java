/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
    @NamedQuery(name = "Tour.findByTitle", query = "SELECT t FROM Tour t WHERE t.title = :title"),
    @NamedQuery(name = "Tour.findByPrice", query = "SELECT t FROM Tour t WHERE t.price = :price"),
    @NamedQuery(name = "Tour.findByDay", query = "SELECT t FROM Tour t WHERE t.day = :day"),
    @NamedQuery(name = "Tour.findByNight", query = "SELECT t FROM Tour t WHERE t.night = :night"),
    @NamedQuery(name = "Tour.findByDeparturePoint", query = "SELECT t FROM Tour t WHERE t.departurePoint = :departurePoint"),
    @NamedQuery(name = "Tour.findByDepartureTime", query = "SELECT t FROM Tour t WHERE t.departureTime = :departureTime"),
    @NamedQuery(name = "Tour.findByOverview", query = "SELECT t FROM Tour t WHERE t.overview = :overview"),
    @NamedQuery(name = "Tour.findByImg", query = "SELECT t FROM Tour t WHERE t.img = :img")})
public class Tour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{emptyFieldErr}")
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Min(value = 1)
    @Column(name = "price")
    private Float price;
    @Column(name = "day")
    @Min(value = 1)
    private Short day;
    @Column(name = "night")
    @Min(value = 0)
    private Short night;
    @Size(max = 100)
    @Column(name = "departure_point")
    private String departurePoint;
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date departureTime;
    @Size(max = 5000)
    @Column(name = "overview")
    private String overview;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Transient
    private MultipartFile imgFile;
    @OneToMany(mappedBy = "tourId")
    private List<TourHighlight> tourHighlightList;
    @OneToMany(mappedBy = "tourId")
    private List<Booking> bookingList;
    @OneToMany(mappedBy = "tourId")
    private List<TourReview> tourReviewList;
    @OneToMany(mappedBy = "tourId")
    private List<TourItinerary> tourItineraryList;

    public Tour() {
    }

    public Tour(Integer id) {
        this.id = id;
    }

    public Tour(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Short getDay() {
        return day;
    }

    public void setDay(Short day) {
        this.day = day;
    }

    public Short getNight() {
        return night;
    }

    public void setNight(Short night) {
        this.night = night;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getOverview() {
        if(overview!=null){
            overview = overview.replaceAll("\\\\", "");
            overview = overview.replaceAll("\'", "");
            overview = overview.replaceAll("\"", "");
        }
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @XmlTransient
    public List<TourHighlight> getTourHighlightList() {
        return tourHighlightList;
    }

    public void setTourHighlightList(List<TourHighlight> tourHighlightList) {
        this.tourHighlightList = tourHighlightList;
    }

    @XmlTransient
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @XmlTransient
    public List<TourReview> getTourReviewList() {
        return tourReviewList;
    }

    public void setTourReviewList(List<TourReview> tourReviewList) {
        this.tourReviewList = tourReviewList;
    }

    @XmlTransient
    public List<TourItinerary> getTourItineraryList() {
        return tourItineraryList;
    }

    public void setTourItineraryList(List<TourItinerary> tourItineraryList) {
        this.tourItineraryList = tourItineraryList;
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
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tm.pojo.Tour[ id=" + id + " ]";
    }

    /**
     * @return the imgFile
     */
    public MultipartFile getImgFile() {
        return imgFile;
    }

    /**
     * @param imgFile the imgFile to set
     */
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
    
}
