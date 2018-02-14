package com.intelygenz.backendninja.service.impl;

import com.intelygenz.backendninja.component.ContactConverter;
import com.intelygenz.backendninja.entity.Contact;
import com.intelygenz.backendninja.model.ContactModel;
import com.intelygenz.backendninja.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class ContacServiceImpl implements ContactService {


    @Autowired
    @Qualifier("contactRespository")
    private ContactRepository contactRepository;


    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;


    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
        return contactConverter.convertContact2ContactModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactsModel = new ArrayList<>();
        for(Contact contact : contacts) {
            contactsModel.add(contactConverter.convertContact2ContactModel(contact));
        }
        return contactsModel;
    }
}
