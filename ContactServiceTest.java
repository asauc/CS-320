package com.contactservice.ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        // Verify the contact was added
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    void testAddDuplicateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact); // Should not allow duplicate contact IDs
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890")); // Contact should be deleted
    }

    @Test
    void testDeleteNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1234567890"); // Contact does not exist
        });
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", null, null, "456 Elm St"); // Update firstName and address
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }
    @Test
    void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Jane", null, null, "456 Elm St"); // Contact does not exist
        });
    }
}