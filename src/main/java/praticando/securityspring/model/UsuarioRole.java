package praticando.securityspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuariorole")
@IdClass(UsuarioRoleId.class)
public class UsuarioRole {
    @Id
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Id
    @Column(name = "roles_id")
    private Integer rolesId;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }
}