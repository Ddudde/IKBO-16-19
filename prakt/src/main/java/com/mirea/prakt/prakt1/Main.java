package com.mirea.prakt.prakt1;

import javafx.application.Application;
import javafx.stage.Stage;
import com.mirea.prakt.prakt1.service.WindowsManager;

public class Main {

    public static class Start extends Application {

        @Override
        public void start(Stage stage) {
            WindowsManager.showMainMenuWindow(stage);
            //WindowsManager.showPlayWindow();
        }
    }

    public static void main(String[] args) {
        Application.launch(Start.class);
    }
}

