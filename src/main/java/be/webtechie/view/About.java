package be.webtechie.view;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class About extends View {

    public About() {
        this.getStylesheets().add("be/webtechie/view/about.css");

        TextArea about = new TextArea("This application is based on a Java Maven library "
                + " and JavaFX example application which are part of the book"
                + "\"Getting Started with Java on the Raspberry Pi\""
                + " written by Frank Delporte.\n\n"
                + "This book is available as ebook on Leanpub"
                + " and paper book on Elektor");
        about.getStyleClass().add("about");
        about.setWrapText(true);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);
        Button btLeanpub = new Button("View on Leanpub");
        btLeanpub.setOnAction(e -> {
            try {
                new ProcessBuilder("x-www-browser", "https://leanpub.com/gettingstartedwithjavaontheraspberrypi")
                        .start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        Button btElektor = new Button("View on Elektor");
        btElektor.setOnAction(e -> {
            try {
                new ProcessBuilder("x-www-browser",
                        "https://www.elektor.com/getting-started-with-java-on-the-raspberry-pi").start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        buttons.getChildren().addAll(btLeanpub, btElektor);

        ImageView cover = new ImageView("be/webtechie/view/ebook-paperbook.jpg");
        cover.setFitWidth(300);
        cover.setFitHeight(200);
        cover.setSmooth(true);

        Button btWebtechie = new Button("Read more on webtechie.be");
        btWebtechie.setStyle("-fx-min-width: 325px; -fx-max-width: 325px;");
        btWebtechie.setOnAction(e -> {
            try {
                new ProcessBuilder("x-www-browser",
                        "https://www.webtechie.be").start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        VBox holder = new VBox();
        holder.setPadding(new Insets(5));
        holder.setSpacing(15);
        holder.getChildren().addAll(about, buttons, cover, btWebtechie);
        this.getChildren().add(holder);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("About");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
}
