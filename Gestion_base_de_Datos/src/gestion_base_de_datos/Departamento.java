/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_base_de_datos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByDpNumero", query = "SELECT d FROM Departamento d WHERE d.dpNumero = :dpNumero"),
    @NamedQuery(name = "Departamento.findByDpNombre", query = "SELECT d FROM Departamento d WHERE d.dpNombre = :dpNombre"),
    @NamedQuery(name = "Departamento.findByDpJefeFecIni", query = "SELECT d FROM Departamento d WHERE d.dpJefeFecIni = :dpJefeFecIni"),
    @NamedQuery(name = "Departamento.findByDpLocalidades", query = "SELECT d FROM Departamento d WHERE d.dpLocalidades = :dpLocalidades")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dp_numero")
    private Integer dpNumero;
    @Column(name = "dp_nombre")
    private String dpNombre;
    @Column(name = "dp_jefe_fec_ini")
    @Temporal(TemporalType.DATE)
    private Date dpJefeFecIni;
    @Column(name = "dp_localidades")
    private String dpLocalidades;
    @OneToMany(mappedBy = "emDepartamento")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "dp_jefe", referencedColumnName = "em_id")
    @OneToOne
    private Empleado dpJefe;

    public Departamento() {
    }

    public Departamento(Integer dpNumero) {
        this.dpNumero = dpNumero;
    }

    public Integer getDpNumero() {
        return dpNumero;
    }

    public void setDpNumero(Integer dpNumero) {
        this.dpNumero = dpNumero;
    }

    public String getDpNombre() {
        return dpNombre;
    }

    public void setDpNombre(String dpNombre) {
        this.dpNombre = dpNombre;
    }

    public Date getDpJefeFecIni() {
        return dpJefeFecIni;
    }

    public void setDpJefeFecIni(Date dpJefeFecIni) {
        this.dpJefeFecIni = dpJefeFecIni;
    }

    public String getDpLocalidades() {
        return dpLocalidades;
    }

    public void setDpLocalidades(String dpLocalidades) {
        this.dpLocalidades = dpLocalidades;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Empleado getDpJefe() {
        return dpJefe;
    }

    public void setDpJefe(Empleado dpJefe) {
        this.dpJefe = dpJefe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dpNumero != null ? dpNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.dpNumero == null && other.dpNumero != null) || (this.dpNumero != null && !this.dpNumero.equals(other.dpNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+dpNombre+"";
    }
    
}
