package Controller;

import DAO.DAO;
import DAOimpl.ClientImpl;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class Controller {
    ObservableList<Client> clientObservableList = FXCollections.observableArrayList();
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
        @FXML
        private TableView<Client> tableView;

        @FXML
        private TableColumn<Client, Integer> idV;

        @FXML
        private TableColumn<Client, String> firstnameV;

        @FXML
        private TableColumn<Client, String> lastnameV;

        @FXML
        private TableColumn<Client, String> patronymicV;

        @FXML
        private TableColumn<Client, String> phoneV;

        @FXML
        private TableColumn<Client, String> emailV;

        @FXML
        private TableColumn<Client, Integer> genderV;

        @FXML
        private TableColumn<Client, Date> regdateV;

        @FXML
        private TableColumn<Client, Date> birthV;

        @FXML
        private TableColumn<Client, String> phpathV;
    @FXML
    void initialize(){
        DAO<Client, Integer> clientIntegerDAO = new ClientImpl(factory);
        List<Client> clientList = clientIntegerDAO.findByAll();
        clientObservableList.addAll(clientList);

        idV.setCellValueFactory(a -> new SimpleObjectProperty<Integer>(a.getValue().getId()));
        firstnameV.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFirstname()));
        tableView.setItems(clientObservableList);


    }

    }


