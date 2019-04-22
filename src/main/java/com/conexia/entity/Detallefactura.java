/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author repe
 */
@Entity
@Table(name = "detallefactura", catalog = "dbrestaurant", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d"),
   //@NamedQuery(name = "Detallefactura.findByfactura", query = "SELECT d FROM Detallefactura dWHERE d.factura = :factura"),
    //@NamedQuery(name = "Detallefactura.findById", query = "SELECT d,c FROM Detallefactura d,Cocinero c where d.idcocinero = c.id and d.id = :id"),
    //@NamedQuery(name = "Detallefactura.findByIdcocinero", query = "SELECT d FROM Detallefactura d WHERE d.idcocinero = :idcocinero"),
    @NamedQuery(name = "Detallefactura.findByPlato", query = "SELECT d FROM Detallefactura d WHERE d.plato = :plato"),
    @NamedQuery(name = "Detallefactura.findByImporte", query = "SELECT d FROM Detallefactura d WHERE d.importe = :importe")})
public class Detallefactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    /*
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfactura")
    private int idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcocinero")
    private int idcocinero;
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "plato")
    private String plato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private int importe;
    
    @ManyToOne
    @JoinColumn(name="idfactura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name="idcocinero")
    private Cocinero cocinero;
    

    public Detallefactura() {

    }
    
    public Detallefactura(Integer id,Factura factura, Cocinero cocinero, String plato, int importe) {
        this.id = id;
        this.plato = plato;
        this.importe = importe;
        this.factura = factura;
        this.cocinero = cocinero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
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
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.entity.Detallefactura[ idfactura=" + id + " ]";
    }
    
}
