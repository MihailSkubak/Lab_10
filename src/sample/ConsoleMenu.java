package sample;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class ConsoleMenu {
    ConsoleMenu(){
    }
    void ShowMenu(){
        Label label1 = new Label("1-Просмотр данных!");
        Label label2 = new Label("2-Добавление данных!");
        Label label3 = new Label("3-Редактирование данных!");
        Label label4 = new Label("4-Удаление данных!");
        Label label5 = new Label("5-Выход!");
    }
}