package py.una.fiuna.evaluacion.modelos;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "usuarios",uniqueConstraints = @UniqueConstraint(columnNames = "nombre_usuario"))
public class Usuario implements Serializable {
    private static final long serialVersionID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;


    @Column(name = "nombre_usuario",unique = true)
    private String nombreUsuario;


    private String password;

    @Column(name = "iplastlogin")
    private String iplastlogin;

    @Column(name = "lastlogin")
    private Date lastlogin;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_creacion", length = 15)
    @Size(max=15, message="maximo 15 caracteres")
    private String usuarioCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuario_modificacion", length = 15)
    @Size(max=15, message="maximo 15 caracteres")
    private String usuarioModificacion;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuariorol", joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles ;




    public Usuario(String nombreUsuario, String password, Set<Rol> roles) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.roles = roles;
    }

    public Usuario() {

    }

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    @PrePersist
    private void create() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private void update() {
        this.fechaModificacion = LocalDateTime.now();
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIplastlogin() {
        return iplastlogin;
    }

    public void setIplastlogin(String iplastlogin) {
        this.iplastlogin = iplastlogin;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }


    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
