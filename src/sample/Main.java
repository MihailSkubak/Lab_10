package sample;

import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.geometry.Orientation;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.MultipleSelectionModel;


public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Label selectedLbl = new Label();
        // создаем список объектов
        ObservableList<String> langs = FXCollections.observableArrayList("1-Просмотр данных!","2-Добавление данных!",
                "3-Редактирование данных!","4-Удаление данных!","5-Выход!");
        ListView<String> langsListView = new ListView<String>(langs);
        langsListView.setPrefSize(250, 150);
        // получаем модель выбора элементов
        MultipleSelectionModel<String> langsSelectionModel = langsListView.getSelectionModel();
        // устанавливаем слушатель для отслеживания изменений
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){
                Scanner in = new Scanner(System.in);
                System.out.println("Введите пароль!");
                String Password=in.nextLine();
                if(Password.equals("Hello123")) {
                    Controller AB=new Controller();
                    Model AL=new Model();
                    int ch=0;
                    AL.Read();
                    System.out.println("Выбирайте пункт с меню и вводите в консоль!");
                    do {
                        try {
                            ch = in.nextInt();
                        }catch (Exception e){
                            System.out.println("Не правильно введены данные!");
                            break;
                        }
                        switch (ch) {
                            case 1: {
                                System.out.println("Все данные!");
                                AL.Basa2();
                                System.out.println("----------------------");
                                break;
                            }
                            case 2:{
                                System.out.println("Добавьте данные!");
                                AB.Add1();
                                System.out.println("Данные успешно добавлены!");
                                System.out.println("----------------------");
                                break;
                            }
                            case 3: {
                                System.out.println("Выберите данные которые вы хотите редактировать! Например строка '2',отсчет строк начинается с нуля!");
                                AB.Replace();
                                System.out.println("----------------------");
                                break;
                            }
                            case 4: {
                                System.out.println("Выберите данные которые вы хотите удалить! Например строка '3',отсчет строк начинается с нуля!");
                                AB.Delete();
                                System.out.println("----------------------");
                                break;
                            }
                            case 5:{
                                AL.File();
                                System.exit(0);
                            }
                            default:{
                                if(ch!=5) {
                                    System.out.println("Неверные данные, выберите вариант от одного до пяти!");
                                    break;
                                }
                            }
                        }
                    } while (true);
                }else{
                    System.out.println("Неверный пароль!");
                }
            }
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, selectedLbl, langsListView);
        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("ListView in JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}