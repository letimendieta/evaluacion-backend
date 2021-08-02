package py.una.fiuna.evaluacion.dto;

import java.util.Date;

public class PersonasDto {
    String nrodoc;
    String apellidos;
    String nombres;
    String sexo;
    Date fecingreso;
    String descripcion;
    String vinculolaboral;


    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecingreso() {
        return fecingreso;
    }

    public void setFecingreso(Date fecingreso) {
        this.fecingreso = fecingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVinculolaboral() {
        return vinculolaboral;
    }

    public void setVinculolaboral(String vinculolaboral) {
        this.vinculolaboral = vinculolaboral;
    }
}
