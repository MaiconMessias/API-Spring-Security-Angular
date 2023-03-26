package praticando.securityspring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import praticando.securityspring.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT r.roleName FROM User u JOIN Role r JOIN UsuarioRole ur ON(ur.usuarioId = u.id) " +
           "WHERE ur.rolesId = r.id AND u.id = :id")
    public List<String> getUserRoles(@Param("id") Long id);

    User findByUsername(String username);


}
