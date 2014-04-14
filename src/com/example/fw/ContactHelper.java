package com.example.fw;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createContact(ContactData contact) {
		initContactCreation();
		fillContactForm(contact);
		submitContactCreation();
	}

	public ContactData getFirstContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 1000)
			.click("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 1000);
		ContactData contact = new ContactData()
			.withFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
			.withLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 1000);
		return contact;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 1000)
			.click("Add")
			.winWaitAndActivate("Add Contact", "", 1000);
	}
	
	private void fillContactForm(ContactData contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.getFirstname())
			.send("TDBEdit11", contact.getLastname());
	}
	
	private void submitContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 1000);
	}	

}
