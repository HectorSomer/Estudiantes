module org.hectorsomer.estudiantes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.hectorsomer.estudiantes to javafx.fxml;
    exports org.hectorsomer.estudiantes;
}