package py.una.fiuna.evaluacion.modelos;




import py.una.fiuna.evaluacion.seguridad.enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;


    public Rol() {
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}