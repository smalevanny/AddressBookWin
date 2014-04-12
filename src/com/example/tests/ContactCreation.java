package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreation extends TestBase {
	
	@Test
	public void createValidContact(){
		ContactData contact = new ContactData()
			.withFirstName("FirstName")
			.withLastName("Lastname");
		app.getContactHelper().createContact(contact);
		ContactData createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
	}
}
