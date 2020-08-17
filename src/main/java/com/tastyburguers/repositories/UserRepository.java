package com.tastyburguers.repositories;

import com.tastyburguers.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//REPOSITORY OU DAO
@Repository
public interface UserRepository extends CrudRepository <User, Integer> {

   // @Query(value = "SELECT * from user WHERE ID = ?1", nativeQuery = true)
   // User searchById(Integer id);

    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    User searchByUsername(String username);

    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    User usuarioPorLogin(String username);

    @Query(value = "SELECT * from user where id = ?1", nativeQuery = true)
    User load(int idUsuario);
    
}