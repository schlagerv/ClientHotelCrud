package com.vadinpoc.vaadinPoc.service;

import au.com.bytecode.opencsv.CSVWriter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vadinpoc.vaadinPoc.ClientsUI;
import com.vadinpoc.vaadinPoc.entity.Client;
import com.vadinpoc.vaadinPoc.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@SpringComponent
public class ClientService extends VerticalLayout {
    protected File tempFile;


    @Autowired
    ClientRepository clientRepository;

    ClientsUI clientsUI = new ClientsUI();

    public void setUI(ClientsUI ui){
        clientsUI=ui;
    }
    public Grid<Client> listClients() {
        Grid<Client> grid = new Grid<>();

        grid.setItems(clientRepository.findAll());
        grid.addColumn(Client::getId).setCaption("ID");
        grid.addColumn(Client::getCpf).setCaption("CPF");
        grid.addColumn(Client::getName).setCaption("Nome Cliente");
        grid.addColumn(Client::getAge).setCaption("Idade");
        grid.addColumn(Client::getEmail).setCaption("Email");
        grid.addColumn(Client::getMothername).setCaption("Nome da Mãe");
        grid.addColumn(Client::getFathername).setCaption("Nome do Pai");
        grid.addColumn(Client::getAddress).setCaption("Endereço");
        grid.addColumn(Client::isActive).setCaption("Status");
        grid.addColumn(reserveView -> "Delete",
                new ButtonRenderer(clickEvent -> {
                    Client auxItem = (Client) clickEvent.getItem();
                    clientRepository.delete(auxItem);
                    grid.getDataProvider().refreshAll();
                    clientsUI.setupLayout();
                }));
        return grid;

    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void addClientForm(TextField client_id, TextField name, TextField cpf, TextField status, TextField address, TextField email, TextField age, TextField mothername, TextField fathername) {
        Client auxClient = new Client();
        if (!client_id.isEmpty()) {
            auxClient.setId(Long.parseLong(client_id.getValue()));
        }
        auxClient.setName(name.getValue());
        auxClient.setCpf(cpf.getValue());
        if (status.getValue().equalsIgnoreCase("1"))
        {auxClient.setActive(true);}
        else auxClient.setActive(false);
        auxClient.setAddress(address.getValue());
        auxClient.setEmail(email.getValue());
        auxClient.setAge(Integer.parseInt(age.getValue()));
        auxClient.setMothername(mothername.getValue());
        auxClient.setFathername(fathername.getValue());
        saveClient(auxClient);
    }

    public void exportCsv()
    {
        // first create file object for file placed at location
        // specified by filepath
        ArrayList<Client> allClients = (ArrayList<Client>) clientRepository.findAll();
        File file = new File("./src/main/resources/clients.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            for (int i =0; i<allClients.size();i++)
            {
                String[] data =allClients.get(i).toCSV();
                writer.writeNext(data);
            }

            // closing writer connection
            writer.close();

            Notification.show("EXPORTADO!");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Notification.show("FALHOU!");
        }
    }

}
