module space.harbour.ticatactoejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens space.harbour.ticatactoejavafx to javafx.fxml;
    exports space.harbour.ticatactoejavafx;
    exports space.harbour.ticatactoejavafx.utils;
    opens space.harbour.ticatactoejavafx.utils to javafx.fxml;
}