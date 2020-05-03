package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.EmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<EmpleadosEntity, Long>{
    public Optional<EmpleadosEntity> findByIdEmpleado(int id_empleado);
    public EmpleadosEntity save(EmpleadosEntity empledo);
//    @Query("select u from User u where u.emailAddress = ?1")
//    User findByEmailAddress(String emailAddress);
//    @Query("select u from User u where u.firstname like %?1")
//    List<User> findByFirstnameEndsWith(String firstname);
//    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//    User findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);
//    NATIVE QUERY
//@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?0", nativeQuery = true)
//User findByEmailAddress(String emailAddress);

}
