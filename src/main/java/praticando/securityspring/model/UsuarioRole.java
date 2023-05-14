package praticando.securityspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
}