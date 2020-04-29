package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long>{
    public Optional<EmpleadoEntity> findById(int id);
    public EmpleadoEntity save(EmpleadoEntity empledo);
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
