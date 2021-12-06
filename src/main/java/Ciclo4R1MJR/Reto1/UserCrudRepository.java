package Ciclo4R1MJR.Reto1;

//* Interfaz

//! Se importan las librerias que se necesitan

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

// polimetodos: permiten hacer consultas puntuales dentro de las bases de datos
//  <nombre de la clase anterior: User, tipo de llava que tiene la clase Integer>

public interface UserCrudRepository extends CrudRepository <User, Integer> {
    //* Se quiere hacer una verificacion por el email y password
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
