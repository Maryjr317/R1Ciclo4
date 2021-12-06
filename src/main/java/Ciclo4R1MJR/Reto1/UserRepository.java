package Ciclo4R1MJR.Reto1;

//! Se importan las librerias que se necesitan

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//*Conexion entre la base de datos y todo lo de java
@Repository

public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    // ! Se escriben los metodos

    // ? Este metodo sirve para traer todos los datos de la tabbla
    public List <User> getAll() {
        return (List <User>) userCrudRepository.findAll();
    }

    // ? Este metodo sirve para traer los datos por el id
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    // ? Este metodo sirve para poder crear un elemento nuevo dentro de la tabla
    // ? Este metodo tambien sirve para actualizar
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    // ? Este metodo sirve para validar el correo
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    // ? Este metodo para autenticar el usuario
    public Optional <User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}

