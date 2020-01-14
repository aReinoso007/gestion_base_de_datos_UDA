/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_base_de_datos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "proyecto", catalog = "dbempresa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByPrId", query = "SELECT p FROM Proyecto p WHERE p.prId = :prId"),
    @NamedQuery(name = "Proyecto.findByPrNombre", query = "SELECT p FROM Proyecto p WHERE p.prNombre = :prNombre"),
    @NamedQuery(name = "Proyecto.findByPrLugar", query = "SELECT p FROM Proyecto p WHERE p.prLugar = :prLugar"),
    @NamedQuery(name = "Proyecto.findByPrDepartamento", query = "SELECT p FROM Proyecto p WHERE p.prDepartamento = :prDepartamento")})
public class Proyecto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pr_id")
    private Integer prId;
    @Column(name = "pr_nombre")
    private String prNombre;
    @Column(name = "pr_lugar")
    private String prLugar;
    @Column(name = "pr_departamento")
    private String prDepartamento;

    public Proyecto() {
    }

    public Proyecto(Integer prId) {
        this.prId = prId;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        Integer oldPrId = this.prId;
        this.prId = prId;
        changeSupport.firePropertyChange("prId", oldPrId, prId);
    }

    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        String oldPrNombre = this.prNombre;
        this.prNombre = prNombre;
        changeSupport.firePropertyChange("prNombre", oldPrNombre, prNombre);
    }

    public String getPrLugar() {
        return prLugar;
    }

    public void setPrLugar(String prLugar) {
        String oldPrLugar = this.prLugar;
        this.prLugar = prLugar;
        changeSupport.firePropertyChange("prLugar", oldPrLugar, prLugar);
    }

    public String getPrDepartamento() {
        return prDepartamento;
    }

    public void setPrDepartamento(String prDepartamento) {
        String oldPrDepartamento = this.prDepartamento;
        this.prDepartamento = prDepartamento;
        changeSupport.firePropertyChange("prDepartamento", oldPrDepartamento, prDepartamento);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prId != null ? prId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.prId == null && other.prId != null) || (this.prId != null && !this.prId.equals(other.prId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ prNombre+"";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
