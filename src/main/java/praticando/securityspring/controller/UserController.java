package praticando.securityspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import praticando.securityspring.model.User;
import praticando.securityspring.repository.UserRepository;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public Boolean userEndpoint() {
        return true;
    }

    @GetMapping("/listarAllUsers")
    public ResponseEntity<Iterable<User>> listarAllUsers(){
        Iterable<User> usuarios = userRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Optional<User>> listarPorId(@PathVariable Integer id){
        Optional<User> usuario = userRepository.findById(id.longValue());
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/salvarUsuario")
    public ResponseEntity<Boolean> salvarUsuario(@RequestBody User usuario){
        userRepository.save(usuario);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity<Boolean> deletarUsuario(@PathVariable Integer id){
        userRepository.deleteById(id.longValue());
        return ResponseEntity.ok(true);
    }
}
