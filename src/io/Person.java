package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class Person {
	private String first, last, address;

	public Person(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}

	public Element getXML() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		Element Address = new Element("address");
		Address.appendChild(address);
		person.appendChild(firstName);
		person.appendChild(lastName);
		person.appendChild(address);
		return person;
	}

	public Person(Element person) {
		first = person.getFirstChildElement("first").getValue();
		last = person.getFirstChildElement("last").getValue();
		address = person.getFirstChildElement("address").getValue();
	}

	public String toString() {
		return first + " " + last + " " + address;
	}

	public static void format(OutputStream os, Document doc) throws IOException {
		Serializer serializer = new Serializer(os, "UTF-8");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}

	public static void main(String[] args) throws Exception {
		List<Person> people = Arrays.asList(new Person("Dr. Bunsen", "Honeydew", "xiantao"),
				new Person("Gonzo", "The Great", "wuhan"), new Person("Phillip J.", "Fry", "beijing"));
		System.out.println(people);
		Element root = new Element("people");
		for (Person p : people)
			root.appendChild(p.getXML());
		Document doc = new Document(root);
		format(System.out, doc);
		format(new BufferedOutputStream(new FileOutputStream("C:\\Users\\10173\\Desktop\\People.xml")), doc);
	}
}
