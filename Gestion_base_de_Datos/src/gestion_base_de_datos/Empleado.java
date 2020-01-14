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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByEmId", query = "SELECT e FROM Empleado e WHERE e.emId = :emId"),
    @NamedQuery(name = "Empleado.findByEmNombre", query = "SELECT e FROM Empleado e WHERE e.emNombre = :emNombre"),
    @NamedQuery(name = "Empleado.findByEmApellido", query = "SELECT e FROM Empleado e WHERE e.emApellido = :emApellido"),
    @NamedQuery(name = "Empleado.findByEmCedula", query = "SELECT e FROM Empleado e WHERE e.emCedula = :emCedula"),
    @NamedQuery(name = "Empleado.findByEmFecNac", query = "SELECT e FROM Empleado e WHERE e.emFecNac = :emFecNac"),
    @NamedQuery(name = "Empleado.findByEmDireccion", query = "SELECT e FROM Empleado e WHERE e.emDireccion = :emDireccion"),
    @NamedQuery(name = "Empleado.findByEmSexo", query = "SELECT e FROM Empleado e WHERE e.emSexo = :emSexo"),
    @NamedQuery(name = "Empleado.findByEmSalario", query = "SELECT e FROM Empleado e WHERE e.emSalario = :emSalario"),
    @NamedQuery(name = "Empleado.findByEmSupervisor", query = "SELECT e FROM Empleado e WHERE e.emSupervisor = :emSupervisor")})
public class Empleado implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "em_id")
    private Integer emId;
    @Column(name = "em_nombre")
    private String emNombre;
    @Column(name = "em_apellido")
    private String emApellido;
    @Column(name = "em_cedula")
    private String emCedula;
    @Column(name = "em_fec_nac")
    private String emFecNac;
    @Column(name = "em_direccion")
    private String emDireccion;
    @Column(name = "em_sexo")
    private String emSexo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "em_salario")
    private Double emSalario;
    @Column(name = "em_supervisor")
    private Integer emSupervisor;
    @JoinColumn(name = "em_departamento", referencedColumnName = "dp_numero")
    @ManyToOne
    private Departamento emDepartamento;
    @OneToOne(mappedBy = "dpJefe")
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(Integer emId) {
        this.emId = emId;
    }

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        Integer oldEmId = this.emId;
        this.emId = emId;
        changeSupport.firePropertyChange("emId", oldEmId, emId);
    }

    public String getEmNombre() {
        return emNombre;
    }

    public void setEmNombre(String emNombre) {
        String oldEmNombre = this.emNombre;
        this.emNombre = emNombre;
        changeSupport.firePropertyChange("emNombre", oldEmNombre, emNombre);
    }

    public String getEmApellido() {
        return emApellido;
    }

    public void setEmApellido(String emApellido) {
        String oldEmApellido = this.emApellido;
        this.emApellido = emApellido;
        changeSupport.firePropertyChange("emApellido", oldEmApellido, emApellido);
    }

    public String getEmCedula() {
        return emCedula;
    }

    public void setEmCedula(String emCedula) {
        String oldEmCedula = this.emCedula;
        this.emCedula = emCedula;
        changeSupport.firePropertyChange("emCedula", oldEmCedula, emCedula);
    }

    public String getEmFecNac() {
        return emFecNac;
    }

    public void setEmFecNac(String emFecNac) {
        String oldEmFecNac = this.emFecNac;
        this.emFecNac = emFecNac;
        changeSupport.firePropertyChange("emFecNac", oldEmFecNac, emFecNac);
    }

    public String getEmDireccion() {
        return emDireccion;
    }

    public void setEmDireccion(String emDireccion) {
        String oldEmDireccion = this.emDireccion;
        this.emDireccion = emDireccion;
        changeSupport.firePropertyChange("emDireccion", oldEmDireccion, emDireccion);
    }

    public String getEmSexo() {
        return emSexo;
    }

    public void setEmSexo(String emSexo) {
        String oldEmSexo = this.emSexo;
        this.emSexo = emSexo;
        changeSupport.firePropertyChange("emSexo", oldEmSexo, emSexo);
    }

    public Double getEmSalario() {
        return emSalario;
    }

    public void setEmSalario(Double emSalario) {
        Double oldEmSalario = this.emSalario;
        this.emSalario = emSalario;
        changeSupport.firePropertyChange("emSalario", oldEmSalario, emSalario);
    }

    public Integer getEmSupervisor() {
        return emSupervisor;
    }

    public void setEmSupervisor(Integer emSupervisor) {
        Integer oldEmSupervisor = this.emSupervisor;
        this.emSupervisor = emSupervisor;
        changeSupport.firePropertyChange("emSupervisor", oldEmSupervisor, emSupervisor);
    }

    public Departamento getEmDepartamento() {
        return emDepartamento;
    }

    public void setEmDepartamento(Departamento emDepartamento) {
        Departamento oldEmDepartamento = this.emDepartamento;
        this.emDepartamento = emDepartamento;
        changeSupport.firePropertyChange("emDepartamento", oldEmDepartamento, emDepartamento);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emId != null ? emId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.emId == null && other.emId != null) || (this.emId != null && !this.emId.equals(other.emId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+emId+"";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
