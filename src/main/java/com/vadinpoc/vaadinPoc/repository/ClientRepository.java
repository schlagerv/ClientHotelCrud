package com.vadinpoc.vaadinPoc.repository;

import com.vadinpoc.vaadinPoc.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
