import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.Console;

public class JewelleryStore extends Application {
    private DisplayCase currentCase;
    private DisplayTray currentTray;
    private Jewellery currentJewellery;

    @Override
    public void start(Stage s) {
        //window
        BorderPane root = new BorderPane();

        //flowpanes
        FlowPane fpCases = new FlowPane();
        FlowPane fpTrays = new FlowPane();
        FlowPane fpJewellery = new FlowPane();
        FlowPane fpMaterials = new FlowPane();

        AnchorPane apMaterials = new AnchorPane();

        //add buttons
        Button addCase = new Button("Add Display Case");
        Button addTray = new Button("Add Display Tray");
        Button addJewellery = new Button("Add Jewellery");

        //delete buttons
        Button deleteCase = new Button("Delete This Display Case");
        Button deleteTray = new Button("Delete This Display Tray");
        Button deleteJewellery = new Button("Delete This Item of Jewellery");

        //clearall buttons
        Button clearCases = new Button("Reset Cases");
        Button clearTrays = new Button("Reset Trays");
        Button clearJewellery = new Button("Reset Jewellery");

        Button viewAllJewellery = new Button("View All Jewellery");

        Button setMats = new Button("Set");

        //back buttons
        Button backToCases = new Button("Back to Home");
        Button backToTrays = new Button("Back to Case");
        Button backToJewellery = new Button("Back");

        //case variable boxes
        ChoiceBox<String> caseTypes = new ChoiceBox<>();
        CheckBox isLit = new CheckBox();

        //tray variable boxes
        ChoiceBox<String> trayColors = new ChoiceBox<>();
        ChoiceBox<String> trayDimensions = new ChoiceBox<>();

        //jewellery variable boxes
        TextField jewelDesc = new TextField();
        ChoiceBox<String> jewelType = new ChoiceBox<>();
        ChoiceBox<String> jewelGender = new ChoiceBox<>();
        ComboBox<String> jewelPrice = new ComboBox<String>();

        //material variable boxes
        ComboBox<String> materialType = new ComboBox<>();
        TextField materialDesc = new TextField();
        ComboBox<String> materialWeight = new ComboBox<>();
        ChoiceBox<String> materialQuality = new ChoiceBox<>();

        //listviews
        ListView<String> displayCases = new ListView<>();
        ListView<String> displayTrays = new ListView<>();
        ListView<String> jewelleryList = new ListView<>();
        ListView<String> materialList = new ListView<>();

        //collection
        JewelleryCollection jc = new JewelleryCollection();

        //buttons added to flowpanes
        fpCases.getChildren().addAll(new Label(" Case Type"), caseTypes, new Label(" Lighting: "), isLit, addCase, clearCases, viewAllJewellery);
        fpTrays.getChildren().addAll(new Label(" Tray Color"), trayColors, new Label(" Tray Dimensions: "), trayDimensions, addTray, clearTrays, deleteCase);
        fpJewellery.getChildren().addAll(new Label(" Description: "), jewelDesc, new Label(" J. Type: "), jewelType, new Label(" Gender: "), jewelGender, new Label(" Price: "), jewelPrice, addJewellery);
        fpMaterials.getChildren().addAll(new Label(" Description: "), materialDesc, new Label(" M. Type: "), materialType, new Label(" Weight: "), materialWeight, new Label(" Quality: "), materialQuality, setMats);

        //set root contents to flowpane and list for cases
        root.setTop(fpCases);
        root.setCenter(displayCases);

        caseTypes.getItems().addAll("Wall-mounted", "Freestanding");

        trayColors.getItems().addAll("Red", "Green", "Blue");
        trayDimensions.getItems().addAll("30x20cm", "15x20cm", "10x10cm", "5x5cm");

        jewelType.getItems().addAll("Necklace", "Earrings", "Bracelet", "Ring", "Gem", "Charm", "Charm Band");
        jewelGender.getItems().addAll("Male", "Female", "Unisex", "Other");
        jewelPrice.getItems().addAll("€59.99", "€79.99", "€99.99", "€149.99", "€199.99", "€299.99", "€499.99");
        jewelPrice.setEditable(true);

        materialType.getItems().addAll("Gold", "Silver", "Platinum", "Diamond", "Sapphire", "Emerald", "Ruby", "Pearl");
        materialType.setEditable(true);
        materialWeight.getItems().addAll();
        materialWeight.setEditable(true);
        materialQuality.getItems().addAll("9K", "10K", "14K", "18K", "22K", "24K");

        viewAllJewellery.setOnAction(e -> {
            if (jc.head != null) {
                DisplayCase tempCase = jc.head;

                while (tempCase.next != null) {

                    if (tempCase.head != null) {
                        DisplayTray tempTray = tempCase.head;

                        while (tempTray.next != null) {

                            if (tempTray.head != null) {
                                Jewellery tempJewel = tempTray.head;
                                jewelleryList.getItems().add(tempJewel.getJewelID() + " " + tempJewel.getJType());

                                while (tempJewel.next != null) {
                                    tempJewel = tempJewel.next;
                                    jewelleryList.getItems().add(tempJewel.toString());
                                }
                            }

                            tempTray = tempTray.next;
                            System.out.println("We got to the next tray");
                        }

                        // This if is for the last tray in the while loop that won't have anything after it
                        if (tempTray.head != null) {
                            Jewellery tempJewel = tempTray.head;
                            jewelleryList.getItems().add(tempJewel.getJewelID() + " " + tempJewel.getJType());

                            while (tempJewel.next != null) {
                                tempJewel = tempJewel.next;
                                jewelleryList.getItems().add(tempJewel.toString());
                            }
                        }
                    }

                    tempCase = tempCase.next;
                    System.out.println("We got to the next case");
                }

                //This if is for the last case in the while loop that won't have anything after it
                if (tempCase.head != null) {
                    DisplayTray tempTray = tempCase.head;

                    while (tempTray.next != null) {

                        if (tempTray.head != null) {
                            Jewellery tempJewel = tempTray.head;
                            jewelleryList.getItems().add(tempJewel.getJewelID() + " " + tempJewel.getJType());

                            while (tempJewel.next != null) {
                                tempJewel = tempJewel.next;
                                jewelleryList.getItems().add(tempJewel.toString());
                            }
                        }

                        tempTray = tempTray.next;
                        System.out.println("We got to the next tray");
                    }

                    //Same tray end as before
                    if (tempTray.head != null) {
                        Jewellery tempJewel = tempTray.head;
                        jewelleryList.getItems().add(tempJewel.getJewelID() + " " + tempJewel.getJType());

                        while (tempJewel.next != null) {
                            tempJewel = tempJewel.next;
                            jewelleryList.getItems().add(tempJewel.toString());
                        }
                    }
                }
            }

            root.setTop(null);
            root.setCenter(jewelleryList);
            root.setBottom(backToCases);
        });

        addCase.setOnAction(e -> {
            jc.addDisplayCase(caseTypes.getValue(), isLit.isSelected());
            displayCases.getItems().add(jc.getLastDisplayCase().toString());
        });

        addTray.setOnAction(e -> {
            currentCase.addDisplayTray(trayColors.getValue(), trayDimensions.getValue());
            displayTrays.getItems().add(currentCase.getLastDisplayTray().toString());
        });

        addJewellery.setOnAction(e -> {
            currentTray.addJewellery(jewelDesc.getText(), jewelType.getValue(), jewelGender.getValue(), jewelPrice.getValue());
            Jewellery temp = currentTray.getLastJewelleryItem();
            jewelleryList.getItems().add(temp.getJewelID()+" "+ temp.getDescription() +" "+ temp.getJType() +" "+ temp.getGender() +" "+temp.getPrice());
        });

        displayCases.setOnMouseClicked(e -> {
            if(displayCases.getSelectionModel().getSelectedItem() != null) {
                String[] caseListing = displayCases.getSelectionModel().getSelectedItem().split(" ");
                int caseUID = Integer.parseInt(caseListing[0].trim());
                System.out.println(caseUID);

                root.setTop(fpTrays);
                root.setCenter(displayTrays);
                root.setBottom(backToCases);

                currentCase = jc.getDisplayCaseWithID(caseUID);
                DisplayTray trayHead = currentCase.head;
                if (trayHead != null) {
                    DisplayTray temp = trayHead;
                    while (temp.next != null) {
                        displayTrays.getItems().add(temp.getTrayID()+ " " + temp.getInlayColor() + " " + temp.getTrayDimensions());
                        temp = temp.next;
                    }
                    displayTrays.getItems().add(temp.getTrayID()+ " " + temp.getInlayColor() + " " + temp.getTrayDimensions());
                }
            }
        });

        displayTrays.setOnMouseClicked(e -> {
            if(displayTrays.getSelectionModel().getSelectedItem() != null) {
                String[] trayListing = displayTrays.getSelectionModel().getSelectedItem().split(" ");
                int trayUID = Integer.parseInt(trayListing[0].trim());
                System.out.println(trayUID);

                root.setTop(fpJewellery);
                root.setCenter(jewelleryList);
                root.setBottom(backToTrays);

                currentTray = currentCase.getDisplayTrayWithID(trayUID);
                if (currentTray.head != null) {
                    Jewellery temp = currentTray.head;
                    while (temp.next != null) {
                        jewelleryList.getItems().add(temp.getJewelID()+" "+ temp.getJType() +" "+ temp.getPrice());
                        temp = temp.next;
                    }
                    jewelleryList.getItems().add(temp.getJewelID()+" "+ temp.getJType()+ " " + temp.getPrice());
                }
            }
        });

        jewelleryList.setOnMouseClicked(e -> {
            if(jewelleryList.getSelectionModel().getSelectedItem() != null) {
                String[] jewelleryListing = jewelleryList.getSelectionModel().getSelectedItem().split(" ");
                int jewelleryUID = Integer.parseInt(jewelleryListing[0].trim());
                System.out.println(jewelleryUID);

                currentJewellery = currentTray.getDisplayJewelleryWithID(jewelleryUID);
                if (currentJewellery.getMats() != null) {
                    materialList.getItems().add("Description: " + currentJewellery.getMats().getDescription());
                    materialList.getItems().add("Material Type: " + currentJewellery.getMats().getType());
                    materialList.getItems().add("Weight: " + currentJewellery.getMats().getWeight() + "g");
                    materialList.getItems().add("Quality: " + currentJewellery.getMats().getQuality()+ "K");
                }

                root.setTop(fpMaterials);
                root.setCenter(materialList);
                root.setBottom(backToJewellery);
            }
        });

        setMats.setOnAction(e -> {
            currentJewellery.getMats().setDescription(materialDesc.getText());
            currentJewellery.getMats().setType(materialType.getValue());
            currentJewellery.getMats().setWeight(Integer.parseInt(materialWeight.getValue().replaceAll("[^\\d]", "")));
            currentJewellery.getMats().setQuality(Integer.parseInt(materialQuality.getValue().replaceAll("[^\\d]", "")));
            materialList.getItems().clear();
            materialList.getItems().add("Description: " + currentJewellery.getMats().getDescription());
            materialList.getItems().add("Material Type: " + currentJewellery.getMats().getType());
            materialList.getItems().add("Weight: " + currentJewellery.getMats().getWeight() + "g");
            materialList.getItems().add("Quality: " + currentJewellery.getMats().getQuality()+ "K");
        });

        backToCases.setOnAction(e -> {
            displayTrays.getItems().clear();
            jewelleryList.getItems().clear();
            currentCase = null;
            root.setTop(fpCases);
            root.setCenter(displayCases);
            root.setBottom(null);
        });

        backToTrays.setOnAction(e -> {
            jewelleryList.getItems().clear();
            currentTray = null;
            root.setTop(fpTrays);
            root.setCenter(displayTrays);
            root.setBottom(backToCases);
        });

        backToJewellery.setOnAction(e -> {
            materialList.getItems().clear();
            currentJewellery = null;
            root.setTop(fpJewellery);
            root.setCenter(jewelleryList);
            root.setBottom(backToTrays);
        });

        clearCases.setOnAction(e -> {
            displayCases.getItems().clear();
            jc.clearCollection();
            jc.setCaseUID(0);
        });

        clearTrays.setOnAction(e -> {
            DisplayCase cc = jc.getDisplayCaseWithID(Integer.parseInt(displayCases.getSelectionModel().getSelectedItem().replaceAll("[\\D]", "")));
            displayTrays.getItems().clear();
            cc.clearDisplayTrays();
            cc.setTrayUID(0);
        });

        deleteCase.setOnAction(e -> {
            jc.removeCaseWithID(Integer.parseInt(displayCases.getSelectionModel().getSelectedItem().replaceAll("[\\D]", "")));
            displayCases.getItems().remove(displayCases.getSelectionModel().getSelectedIndex());
            displayTrays.getItems().clear();
            root.setTop(fpCases);
            root.setCenter(displayCases);
            root.setBottom(null);
        });

        s.setScene(new Scene(root, 800, 600));
        s.setTitle("Jewellery Store");
        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}