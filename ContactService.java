package com.contactservice.ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactID);
    }

    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        Contact contact = contacts.get(contactID);
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}