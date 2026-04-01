package com.contactlist.App;

import com.contactlist.Model.Contact;
import com.contactlist.Manager.ContactManager;
import java.util.Scanner;

public class ContactApp{

    private static ContactManager manager = new ContactManager();
    private static Scanner enter = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("======CONTACT LIST APP======");

        while(true){
            showMenu();
            int option = getOption();

            if (option == 9){
                System.out.println("!Adios¡");
            break;
            }
            handleOption(option);
        }
        enter.close();
    }
    private static void showMenu(){
        System.out.println("\n ------Menú------");
        System.out.println("1. Agregar contacto.");
        System.out.println("2. Ver todos los contactos.");
        System.out.println("3. Buscar contacto por nombre.");
        System.out.println("4. Actualizar contacto.");
        System.out.println("5. Eliminar contacto.");
        System.out.println("6. Eliminar todos los contactos.");
        System.out.println("7. Verificar si existe contacto.");
        System.out.println("8. Total de contactos.");
        System.out.println("9. Salir.");
        System.out.println("Opción.");
}

private static int getOption(){
    try {
        return Integer.parseInt(enter.nextLine());
        
    } catch (NumberFormatException e){
        return -1;
    }
}
private static void handleOption(int option){
    switch (option){
        case 1:
            addContact();
            break;
        case 2:
            listAllContacts();
            break;
        case 3:
            findContact();
            break;
        case 4:
            updateContact();
            break;
        case 5:
            deleteContact();
            break;
        case 6:
            deleteAllContacts();
            break;
        case 7:
            contactExist();
            break;
        case 8:
            totalContacts();
            break;
        default:
            System.out.println("Opción ni valida.");
    }
}

private static void addContact(){
    System.out.print("Nombre: ");
    String name = enter.nextLine();

    System.out.print("Telefono: ");
    String phone = enter.nextLine();

    System.out.print("Email: ");
    String email = enter.nextLine();

    Contact contact = new Contact(name, phone, email); //creamos un nuevo contacto
    manager.addContact(contact);
    System.out.println(" ♦ Contacto agregado ");
}

private static void listAllContacts(){
    if(manager.getTotalContacts()==0){
        System.out.println(" sin contactos. ");
    }else{
        System.out.println("\n ------LISTA DE CONTACTOS------");
        manager.listAllContacts();
    }
}
private static void findContact(){
    System.out.print("Nombre a buscar: ");
    String name = enter.nextLine();

    Contact c = manager.findContactByName(name);
    if(c!=null){
        System.out.println("Encontrado: "+c);
    }else{
        System.out.println("No encontrado, inexistente.");
    }
}

private static void updateContact(){
    System.out.println("Nombre del contacto a modificar: ");
    String name = enter.nextLine();

    System.out.println("Nuevo telefono: ");
    String newPhone = enter.nextLine();

    System.out.println("Nuevo email: ");
    String newEmail = enter.nextLine();

    if (manager.updateContact(name,newPhone,newEmail)){
        System.out.println(" ♦ Contacto actualizado ");
    } else{
        System.out.println(" Contacto no encontrado");
    }
}

private static void deleteContact(){
    System.out.println("Nombre del contacto a eliminar: ");
    String name = enter.nextLine();

    if(manager.deleteContact(name)){
        System.out.println(" Eliminando a "+ name +" ....");
    }else{
        System.out.println("Contacto no encontrado.");
    }
}

private static void deleteAllContacts(){
    System.out.println("¿Eliminar Todos los contactso s/n?.");
    String confirm = enter.nextLine();
    if(confirm.equalsIgnoreCase("s")){
        manager.delateAllContacts();
        System.out.println("Se han eliminado todos los contactos.");
    }else{ 
        System.out.println("Operacion cancelada.");
    }
}
private static void contactExist(){
    System.out.print("Nombre a verificar: ");
    String name = enter.nextLine();
    if(manager.contactExist(name)){
        System.out.println(" El conacto si existe. ");
    }else{
        System.out.println(" El contacto no existe. ");
    }
}
private static void totalContacts(){
    System.out.println(" Todos los contactos: "+manager.getTotalContacts());
}
}