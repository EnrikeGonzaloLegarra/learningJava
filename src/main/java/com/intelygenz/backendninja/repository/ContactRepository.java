package com.intelygenz.backendninja.repository;

import com.intelygenz.backendninja.entity.Contact;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("contactRespository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {
    public abstract Contact findById(int id);

}
