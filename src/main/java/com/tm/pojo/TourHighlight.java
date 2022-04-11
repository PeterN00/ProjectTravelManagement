/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tour_highlight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourHighlight.findAll", query = "SELECT t FROM TourHighlight t"),
    @NamedQuery(name = "TourHighlight.findById", query = "SELECT t FROM TourHighlight t WHERE t.id = :id"),
    @NamedQuery(name = "TourHighlight.findByHighlight", query = "SELECT t FROM TourHighlight t WHERE t.highlight = :highlight")})
public class TourHighlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "emptyFieldErr")
    @Size(min = 1, max = 255)
    @Column(name = "highlight")
    private String highlight;
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    @ManyToOne
    private Tour tourId;

    public TourHighlight() {
    }

    public TourHighlight(Integer id) {
        this.id = id;
    }

    public TourHighlight(Integer id, String highlight) {
        this.id = id;
        this.highlight = highlight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
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
        if (!(object instanceof TourHighlight)) {
            return false;
        }
        TourHighlight other = (TourHighlight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tm.pojo.TourHighlight[ id=" + id + " ]";
    }
    
}
