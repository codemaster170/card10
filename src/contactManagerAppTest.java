package org.example;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class ContactManagerAppTest {


    @Test
    public void ContactManagerApp() {
        ContactManagerApp app = new ContactManagerApp();
        assertNotNull(app);
        assertNotNull(app.frame);
        assertNotNull(app.cardPanel);
        assertNotNull(app.cardLayout);
    }
    @Test
    void createContactDetailsView() {
        ContactManagerApp app = new ContactManagerApp();
        JPanel panel = (JPanel) app.cardPanel.getComponent(1);
        assertNotNull(panel);
        assertEquals(BorderLayout.class, panel.getLayout().getClass());
        JLabel detailsLabel = (JLabel) panel.getComponent(0);
        assertNotNull(detailsLabel);
        JButton backButton = (JButton) panel.getComponent(1);
        assertNotNull(backButton);
    }

    @Test
    public void ShowContactDetails() {
        ContactManagerApp app = new ContactManagerApp();
        app.contacts.add(new Contact("Abdulle ysin", "12848967890", "Abdulle@gmail.com"));
        app.contactListModel.addElement("Abdulle");
        app.contactList.setSelectedIndex(0);
        app.showContactDetails();
        assertEquals("Name: Abdulle ysin Phone: 12848967890 Email: Abdulle@gmail.com", app.detailsLabel.getText());
}
    @Test
    public void SaveContact() {
        ContactManagerApp app = new ContactManagerApp();
        app.nameField.setText("Abdulle ysin");
        app.phoneField.setText("12848967890");
        app.emailField.setText("Abdulle@gmail.com");
        app.saveContact();
        assertEquals(1, app.contacts.size());
        assertEquals("Abdulle ysin", app.contacts.get(0).name());
        assertEquals("12848967890", app.contacts.get(0).phone());
        assertEquals("Abdulle@gmail.com", app.contacts.get(0).email());
    }

    @Test
    public void AddAndViewContact() {
        ContactManagerApp app = new ContactManagerApp();

        app.nameField.setText("Abdulle ysin");
        app.phoneField.setText("12848967890");
        app.emailField.setText("Abdulle@gmail.com");
        app.saveContact();

        assertEquals(1, app.contacts.size());

        app.contactList.setSelectedIndex(0);

        app.showContactDetails();

        String expectedDetails = "Name: Abdulle ysin Phone: 12848967890 Email: Abdulle@gmail.com";
        assertEquals(expectedDetails, app.detailsLabel.getText());
}
}

