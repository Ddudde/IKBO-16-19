package com.mirea.prakt.prakt1.service;

import com.mirea.prakt.prakt1.controller.MainMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class WindowsManager extends MainMenuController {

    private static final String MAIN_MENU_WINDOW_VIEW = "/view/MainMenu.fxml";
    private static final String PLAY_WINDOW_VIEW = "/view/MainView.fxml";
    private static final String FINISH_GAME_WINDOW_VIEW = "/view/FinishGame.fxml";

    private static final String MAIN_ICON_PATH = "/main-icon.png";
    private static final String STYLESHEET_PATH = "/styles.css";
    private static final String WINDOWS_TITLE = "FindThePair";

    private static Stage stag;

    public static void showMainMenuWindow(Stage stage) {
        stag = stage;
        loadWindow(WINDOWS_TITLE, MAIN_MENU_WINDOW_VIEW);
        stag.setResizable(false);
        stag.show();
    }

    public static void showPlayWindow(Stage stage) {
        stag = stage;
        loadWindow(WINDOWS_TITLE, PLAY_WINDOW_VIEW);
        stag.setMaximized(true);
        stag.show();
    }

    public static void showFinishGameWindow(Stage stage) {
        stag = stage;
        loadWindow(WINDOWS_TITLE, FINISH_GAME_WINDOW_VIEW);
        stag.setResizable(false);
        stag.show();
    }

    private static void loadWindow(String windowTitle, String viewPath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            stag.setTitle(windowTitle);
            stag.getIcons().add(new Image(WindowsManager.class.getResourceAsStream(MAIN_ICON_PATH)));

            fxmlLoader.setLocation(WindowsManager.class.getResource(viewPath));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(STYLESHEET_PATH);
            stag.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
