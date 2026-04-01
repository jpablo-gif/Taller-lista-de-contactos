package com.contactlist.Manager;

import java.util.ArrayList;
import java.util.List;
import com.contactlist.Model.Contact;  // ← Importa todo el paquete

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager(){
        contacts = new ArrayList<>();
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    public void listAllContacts(){
        for (Contact c : contacts){
            System.out.println(c);
        }
    }
    public Contact findContactByName(String name){
        for (int i = 0;i< contacts.size(); i++){
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                return contacts.get(i);
            }
        }
        return null; //si el objeto no existe o no se puede crear o retornar, retorne null
    }
    public boolean updateContact(String name, String newPhone, String newEmail){
        for(int i=0; i<contacts.size() ;i++){
            Contact c = contacts.get(i);// busca i en los contactos
            if(c.getName().equalsIgnoreCase(name)){
                c.setPhoneNumber(newPhone);// lo que paso aqui es lo siguiente, usamo el
                c.setEmail(newEmail);//metodo setter, y llamamos setEmail(argumentos nuevos) y
                return true; //le ingresamos los argumentos nuevos
            }
        }
        return false;
    }
    public boolean deleteContact(String name){
        for (int i=0 ; i<contacts.size(); i++){
            Contact c = contacts.get(i);
            if(c.getName().equalsIgnoreCase(name)){
                contacts.remove(i);
                return true;
            }
        }
        return false;
    }
    public void delateAllContacts(){
        contacts.clear();
    }
    public boolean contactExist(String name){
        for (int i = 0 ; i<contacts.size(); i++){
            Contact c= contacts.get(i);
            if(c.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    public int getTotalContacts(){
        return contacts.size();
    }

}