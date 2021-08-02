package py.una.fiuna.evaluacion.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="personas")
public class Personas implements Serializable {
    private static final long serialVersionID=1L;

    private int idpersona;
    private String cedula;
    private String apellidos;
    private String nombres;
    private String sexo;
    private String telefono;
    private String email;
    private Date fechaingreso;
    private Date fechanombramiento;
    private String vinculolaboral;

    @Id
    @Column(name = "idpersona")
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    @Basic
    @Column(name = "cedula")
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Basic
    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "nombres")
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "sexo")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fechaingreso")
    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    @Basic
    @Column(name = "fechanombramiento")
    public Date getFechanombramiento() {
        return fechanombramiento;
    }

    public void setFechanombramiento(Date fechanombramiento) {
        this.fechanombramiento = fechanombramiento;
    }

    @Basic
    @Column(name = "vinculolaboral")
    public String getVinculolaboral() {
        return vinculolaboral;
    }

    public void setVinculolaboral(String vinculolaboral) {
        this.vinculolaboral = vinculolaboral;
    }

    @OneToMany(mappedBy = "personas", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluaciones> evaluacionesList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personas personas = (Personas) o;
        return idpersona == personas.idpersona &&
                Objects.equals(cedula, personas.cedula) &&
                Objects.equals(apellidos, personas.apellidos) &&
                Objects.equals(nombres, personas.nombres) &&
                Objects.equals(sexo, personas.sexo) &&
                Objects.equals(telefono, personas.telefono) &&
                Objects.equals(email, personas.email) &&
                Objects.equals(fechaingreso, personas.fechaingreso) &&
                Objects.equals(fechanombramiento, personas.fechanombramiento) &&
                Objects.equals(vinculolaboral, personas.vinculolaboral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpersona, cedula, apellidos, nombres, sexo, telefono, email, fechaingreso, fechanombramiento, vinculolaboral);
    }
}
