package praticando.securityspring.model;

import java.io.Serializable;

public class UsuarioRoleId implements Serializable {
    private Integer usuarioId;
    private Integer rolesId;

    public UsuarioRoleId() {}

    public UsuarioRoleId(Integer usuarioId, Integer rolesId) {
        this.usuarioId = usuarioId;
        this.rolesId = rolesId;
    }
}