module org.hectorsomer.estudiantes {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.hectorsomer.estudiantes.models to javafx.base;
    requires org.kordamp.bootstrapfx.core;
    opens org.hectorsomer.estudiantes to javafx.fxml;
    exports org.hectorsomer.estudiantes;
    exports org.hectorsomer.estudiantes.controllers;
    opens org.hectorsomer.estudiantes.controllers to javafx.fxml;
}