package com.vadinpoc.vaadinPoc;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.vadinpoc.vaadinPoc.entity.Client;
import com.vadinpoc.vaadinPoc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicBoolean;

@SpringUI(path = "clients")
public class ClientsUI extends UI {

    private VerticalLayout rootLayout;
    private Grid<Client> grid;

    @Autowired
    private ClientService clientService;

    @Override
    protected void init(VaadinRequest request) {
        clientService.setUI((ClientsUI) this.getUI());
        setupLayout();
    }

    public void setupLayout() {
        rootLayout = new VerticalLayout();
        rootLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addHeader();
        export();
        showGrid();
        addClientForm();
        setContent(rootLayout);
    }

    private void addHeader() {
        Label header = new Label("Clientes");
        header.addStyleName(ValoTheme.LABEL_H1);
        rootLayout.addComponent(header);
    }

    private void showGrid() {
        if (grid != null)
            rootLayout.removeComponent(grid);
        grid = clientService.listClients();
        grid.setWidth("90%");
        rootLayout.addComponent(grid);
    }

    private void export() {
        AtomicBoolean result = new AtomicBoolean(false);
        Button exportBtn = new Button("Export to CSV");
        exportBtn.addClickListener(clickEvent -> clientService.exportCsv());

        rootLayout.addComponent(exportBtn);
    }

    private void addClientForm() {
        VerticalLayout layout = new VerticalLayout();
        FormLayout formLayout = new FormLayout();
        TextField client_id = new TextField("ID do Cliente (Deixar em branco para adicionar novo)");
        formLayout.addComponent(client_id);
        TextField name = new TextField("Nome do Cliente");
        formLayout.addComponent(name);
        TextField cpf = new TextField("CPF");
        formLayout.addComponent(cpf);
        TextField status = new TextField("Ativo (1-Sim / 0-Não)");
        formLayout.addComponent(status);
        TextField address = new TextField("Endereço");
        formLayout.addComponent(address);
        TextField email = new TextField("E-mail");
        formLayout.addComponent(email);
        TextField age = new TextField("Idade");
        formLayout.addComponent(age);
        TextField mothername = new TextField("Nome da Mãe");
        formLayout.addComponent(mothername);
        TextField fathername = new TextField("Nome do Pai");
        formLayout.addComponent(fathername);

        Button save = new Button("Save");
        save.addClickListener(e -> {
            if (cpf.getValue().isEmpty() || name.getValue().isEmpty() || status.getValue().isEmpty()
                    || address.getValue().isEmpty() || email.getValue().isEmpty() || age.getValue().isEmpty()
                    || mothername.getValue().isEmpty() || fathername.getValue().isEmpty()) {
                Notification.show("Somente campo ID pode ser em branco");
            } else {
                if (ageValidator(age)) {
                    clientService.addClientForm(client_id, name, cpf, status, address, email, age, mothername, fathername);
                    setupLayout();
                } else
                    Notification.show("Idade Inválida");
            }

        });

        Button clean = new Button("Limpar", e -> {
            client_id.clear();
            name.clear();
            cpf.clear();
            status.clear();
            address.clear();
            email.clear();
            age.clear();
            mothername.clear();
            fathername.clear();
        });
        formLayout.addComponents(save, clean);
        layout.addComponents(formLayout);
        rootLayout.addComponent(layout);
        rootLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }

    public boolean ageValidator(TextField age) {
        int aux = 0;
        try {
            aux = Integer.parseInt(age.getValue());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
