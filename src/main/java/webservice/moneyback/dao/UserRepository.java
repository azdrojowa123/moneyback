package webservice.moneyback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webservice.moneyback.entity.User;

@Repository
public interface UserRepository extends JpaRepository < User, Integer >{

}
