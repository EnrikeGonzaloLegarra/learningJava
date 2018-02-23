package com.intelygenz.backendninja.service.impl;

import com.intelygenz.backendninja.entity.Contact;
import com.intelygenz.backendninja.model.ContactModel;
import java.util.List;


public interface ContactService {
    ContactModel addContact(ContactModel contactModel);

    List<ContactModel> listAllContacts();

    Contact findContactById(int id);

    void removeContact(int id);
}
