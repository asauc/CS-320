package com.contactservice.ContactService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testContactCreationValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactCreationInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"); // null ID
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"); // too long ID
        });
    }
    @Test
    void testContactCreationInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Doe", "1234567890", "123 Main St"); // null first name
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "abcdefghij", "Doe", "1234567890", "123 Main St"); // too long first name
        });
    }

    @Test
    void testContactCreationInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", null, "1234567890", "123 Main St"); // null last name
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "abcdefghij", "1234567890", "123 Main St"); // too long last name
        });
    }

    @Test
    void testContactCreationInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", null, "123 Main St"); // null phone
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "123456789", "123 Main St"); // too short phone
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "12345678901", "123 Main St"); // too long phone
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "123ABC7890", "123 Main St"); // invalid characters in phone
        });
    }

    @Test
    void testContactCreationInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", null); // null address
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", "123456789012345678901234567890"); // too long address
        });
    }
}