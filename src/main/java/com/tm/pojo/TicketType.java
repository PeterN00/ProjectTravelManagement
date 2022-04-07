/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PHUC
 */
@Entity
@Table(name = "ticket_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketType.findAll", query = "SELECT t FROM TicketType t"),
    @NamedQuery(name = "TicketType.findByType", query = "SELECT t FROM TicketType t WHERE t.type = :type"),
    @NamedQuery(name = "TicketType.findByDiscount", query = "SELECT t FROM TicketType t WHERE t.discount = :discount")})
public class TicketType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private Boolean type;
    @Column(name = "discount")
    private Short discount;
    @OneToMany(mappedBy = "ticketType")
    private List<Booking> bookingList;

    public TicketType() {
    }

    public TicketType(Boolean type) {
        this.type = type;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    @XmlTransient
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketType)) {
            return false;
        }
        TicketType other = (TicketType) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tm.pojo.TicketType[ type=" + type + " ]";
    }
    
}
