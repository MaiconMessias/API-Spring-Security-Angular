package praticando.securityspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRoleId implements Serializable {
    private Integer usuarioId;
    private Integer rolesId;
}