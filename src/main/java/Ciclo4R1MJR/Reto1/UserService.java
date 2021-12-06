package Ciclo4R1MJR.Reto1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//*Conexion entre la base de datos y todo lo de java

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    // ! Se escriben los metodos para una etapa de seguridad algunos si la necesitan

    // ? Este metodo sirve para traer todos los datos de la tabbla
    public List<User> getAll() {
        return userRepository.getAll();
    }

    // ? Este metodo sirve para traer los datos por el id
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    // ? Metodo crear o registrar usuario
    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    // ? Metodo para validar email
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    // ? Metodo para validar email
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }

}

