package praticando.securityspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
@CacheEvict(value = "roles", beforeInvocation = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rolename")
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                },
                mappedBy = "roles")
    @JsonIgnore
    private List<User> usuarios = new ArrayList();
}
