module com.example.ide.ide {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ide.ide to javafx.fxml;
    exports com.example.ide.ide;
    exports com.example.ide.ide.splash;
    exports com.example.ide.ide.newproject;
}
