package com.intelygenz.backendninja.service.impl;

import com.intelygenz.backendninja.component.ContactConverter;
import com.intelygenz.backendninja.controller.ContactController;
import com.intelygenz.backendninja.entity.Contact;
import com.intelygenz.backendninja.model.ContactModel;
import com.intelygenz.backendninja.repository.ContactRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.internal.ContextualJdbcConnectionAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class ContacServiceImpl implements ContactService {

    private static final Log LOG = LogFactory.getLog(ContacServiceImpl.class);

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


        List<ContactModel> contactsModel;
        contactsModel = new ArrayList<>();
        for(Contact contact : contacts) {
            contactsModel.add(contactConverter.convertContact2ContactModel(contact));
        }
        LOG.info("/LISTALLCONTACTAS EN CONTACTSERVICEIMPL ----> "+ contactsModel);

        return contactsModel;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);

    }

    @Override
    public void removeContact(int id) {
        Contact contact = findContactById(id);
        if ( null != contact) {
            contactRepository.delete(findContactById(id));
        }

    }
}
