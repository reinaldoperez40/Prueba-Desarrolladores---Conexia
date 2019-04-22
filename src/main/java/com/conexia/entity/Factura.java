/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author repe
 */
@Entity
@Table(name = "factura", catalog = "dbrestaurant", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByTotalForCamarero", query = "SELECT f,FUNC('MONTH',f.fechafactura) as mes,sum(f.total) as suma FROM Factura f join f.camarero c GROUP BY f.camarero.id,FUNC('MONTH',f.fechafactura)"),
    @NamedQuery(name = "Factura.findByWithOutTotalForCamarero", query = "SELECT DISTINCT c FROM Camarero c WHERE NOT EXISTS (SELECT f FROM Factura f WHERE f.camarero.id = c.id)"),
    @NamedQuery(name = "Factura.findByTopCliente", query = "SELECT f FROM Factura f join f.cliente c GROUP BY f.id HAVING f.total > 100000 ORDER BY f.total DESC"),
    //@NamedQuery(name = "Factura.findByTotalForCamarero", query = "SELECT f FROM Factura f"),
    //@NamedQuery(name = "Factura.findAll", query = "select f,c,a,m FROM Factura as f,Cliente as c,Camarero as a,Mesa as m where f.idcliente = c.id and f.idcamarero = a.id and f.idmesa = m.id"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
    //@NamedQuery(name = "Factura.findByIdcliente", query = "SELECT f FROM Factura f WHERE f.idcliente = :idcliente"),
    //@NamedQuery(name = "Factura.findByIdcamarero", query = "SELECT f FROM Factura f WHERE f.idcamarero = :idcamarero"),
    //@NamedQuery(name = "Factura.findByIdmesa", query = "SELECT f FROM Factura f WHERE f.idmesa = :idmesa"),
    @NamedQuery(name = "Factura.findByFechafactura", query = "SELECT f FROM Factura f WHERE f.fechafactura = :fechafactura"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    /*
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcliente")
    private int idcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcamarero")
    private int idcamarero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmesa")
    private int idmesa;
    */
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafactura")
    @Temporal(TemporalType.DATE)
    private Date fechafactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    
    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="idcamarero")
    private Camarero camarero;
    @ManyToOne
    @JoinColumn(name="idmesa")
    private Mesa mesa;
    
    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, Date fechafactura, Cliente cliente, Camarero camarero, Mesa mesa, int total) {
        this.id = id;
        this.fechafactura = fechafactura;
        this.total = total;
        this.cliente = cliente;
        this.camarero = camarero;
        this.mesa = mesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conexia.entity.Factura[ id=" + id + " ]";
    }

}
