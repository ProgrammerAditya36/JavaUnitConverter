package converterGUIconfig;
import javafx.scene.layout.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*; 

public class Layout {
    public static ColumnConstraints[] setColumnConstraints(){
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints array[] = {col1,col2};
        return array;
    }
    public static RowConstraints[] setRowConstraints(){
        RowConstraints row1 = new RowConstraints();        
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();
        RowConstraints row6 = new RowConstraints();


        RowConstraints array[] = {row1,row2,row3,row4,row5,row6};
        return array;
    }
    
    public static void setStdUnitWindow(GridPane gp,Label inpLabel,TextField inpField,Label fromLabel,ComboBox<String> fromCbUnit,Label toLabel,ComboBox<String>toCbUnit,Button convertButton,Label resultLabel){
        // inpField
        inpField.setPrefSize(300,5);
        GridPane.setMargin(inpField, new Insets(10));
        GridPane.setRowIndex(inpField, 2);
        GridPane.setColumnIndex(inpField, 1);
        // inpLabel
        inpLabel.setPrefSize(300,18);
        inpLabel.setPadding(new Insets(10));
        GridPane.setRowIndex(inpLabel, 2);
        GridPane.setColumnIndex(inpLabel, 0);
        // fromLabel
        fromLabel.setPrefSize(300, 18);
        fromLabel.setPadding(new Insets(10));
        GridPane.setRowIndex(fromLabel, 3);
        GridPane.setColumnIndex(fromLabel, 0);
        // fromCbUnit
        fromCbUnit.setPrefWidth(150);
        GridPane.setHalignment(fromCbUnit, HPos.RIGHT);
        GridPane.setMargin(fromCbUnit, new Insets(10));
        GridPane.setRowIndex(fromCbUnit, 3);
        GridPane.setColumnIndex(fromCbUnit, 0);
        // toLabel
        toLabel.setPrefSize(300, 18);
        toLabel.setPadding(new Insets(10));
        GridPane.setRowIndex(toLabel, 3);
        GridPane.setColumnIndex(toLabel, 1);
        // toCbUnit
        toCbUnit.setPrefWidth(150);
        GridPane.setHalignment(toCbUnit, HPos.RIGHT);
        GridPane.setMargin(toCbUnit, new Insets(10));
        GridPane.setRowIndex(toCbUnit, 3);
        GridPane.setColumnIndex(toCbUnit, 1);
        // convertButton
        convertButton.setPrefWidth(600);
        GridPane.setMargin(convertButton, new Insets(10));
        GridPane.setRowIndex(convertButton, 4);
        GridPane.setColumnIndex(convertButton, 0);
        GridPane.setColumnSpan(convertButton, 2);
        // resultLabel
        resultLabel.setPrefSize(600, 18);
        resultLabel.setPadding(new Insets(10));
        GridPane.setRowIndex(resultLabel, 5);
        GridPane.setColumnIndex(resultLabel, 0);
        GridPane.setColumnSpan(resultLabel, 2);
        resultLabel.setAlignment(Pos.CENTER);
        // add to gridpane
        gp.getChildren().addAll(inpLabel,inpField,fromLabel,fromCbUnit,toLabel,toCbUnit,convertButton,resultLabel); 
    }
    public static void setDerUnitWindow(GridPane gp, Label inp1Label,TextField inp1Field,ComboBox<String>inp1CbUnit,Label inp2Label,TextField inp2Field,ComboBox<String>inp2CbUnit,Button convertButton,Label resultLabel){
        // inp1Label
        GridPane.setHalignment(inp1Label, HPos.LEFT);
        GridPane.setMargin(inp1Label, new Insets(10));
        GridPane.setRowIndex(inp1Label, 2);
        GridPane.setColumnIndex(inp1Label, 0);
        inp1Label.setPadding(new Insets(10));
        // inp1Field
        GridPane.setValignment(inp1Field, VPos.CENTER);
        GridPane.setMargin(inp1Field, new Insets(10));
        GridPane.setRowIndex(inp1Field, 2);
        GridPane.setColumnIndex(inp1Field, 1);

        // inp1CbUnit
        GridPane.setHalignment(inp1CbUnit, HPos.CENTER);
        GridPane.setMargin(inp1CbUnit, new Insets(10));
        GridPane.setRowIndex(inp1CbUnit, 2);
        GridPane.setColumnIndex(inp1CbUnit, 2);
        inp1CbUnit.setPrefWidth(150);
        // inp2Label
        GridPane.setHalignment(inp2Label, HPos.LEFT);
        GridPane.setMargin(inp2Label, new Insets(10));
        GridPane.setRowIndex(inp2Label, 3);
        GridPane.setColumnIndex(inp2Label, 0);
        inp2Label.setPadding(new Insets(10));
        // inp2Field
        GridPane.setValignment(inp2Field, VPos.CENTER);
        GridPane.setMargin(inp2Field, new Insets(10));
        GridPane.setRowIndex(inp2Field, 3);
        GridPane.setColumnIndex(inp2Field, 1);

        // inp2CbUnit
        GridPane.setHalignment(inp2CbUnit, HPos.CENTER);
        GridPane.setMargin(inp2CbUnit, new Insets(10));
        GridPane.setRowIndex(inp2CbUnit, 3);
        GridPane.setColumnIndex(inp2CbUnit, 2);
        inp2CbUnit.setPrefWidth(150);
        
        // convertButton
        convertButton.setPrefWidth(600);
        GridPane.setMargin(convertButton, new Insets(10));
        GridPane.setRowIndex(convertButton, 4);
        GridPane.setColumnIndex(convertButton, 0);
        GridPane.setColumnSpan(convertButton, 3);
        // resultLabel
        resultLabel.setPrefWidth(600);
        resultLabel.setPadding(new Insets(10));
        GridPane.setRowIndex(resultLabel, 5);
        GridPane.setColumnIndex(resultLabel, 0);
        GridPane.setColumnSpan(resultLabel, 3);
        resultLabel.setAlignment(Pos.CENTER);
        // add to gridpane
        gp.getChildren().addAll(inp1Label,inp1Field,inp1CbUnit,inp2Label,inp2Field,inp2CbUnit,convertButton,resultLabel);
    }
    public static void setFunUnitWindow(GridPane gp,Label inpLabel,TextField inpField, ComboBox<String>inpCbUnit,ComboBox<String>outCbUnit,Button convertButton,Label resultLabel){
        // inpLabel
        GridPane.setHalignment(inpLabel, HPos.LEFT);
        GridPane.setMargin(inpLabel, new Insets(10));
        GridPane.setRowIndex(inpLabel, 2);
        GridPane.setColumnIndex(inpLabel, 0);
        inpLabel.setPadding(new Insets(10));
        // inpField
        GridPane.setHalignment(inpField, HPos.LEFT);
        GridPane.setValignment(inpField, VPos.CENTER);
        GridPane.setMargin(inpField, new Insets(10));
        GridPane.setRowIndex(inpField, 2);
        GridPane.setColumnIndex(inpField, 1);
        // inpCbUnit
        GridPane.setHalignment(inpCbUnit, HPos.CENTER);
        GridPane.setMargin(inpCbUnit, new Insets(10));
        GridPane.setRowIndex(inpCbUnit, 2);
        GridPane.setColumnIndex(inpCbUnit, 2);
        inpCbUnit.setPrefWidth(217);
        // outCbUnit
        GridPane.setHalignment(outCbUnit, HPos.CENTER);
        GridPane.setMargin(outCbUnit, new Insets(10));
        GridPane.setRowIndex(outCbUnit, 3);
        GridPane.setColumnIndex(outCbUnit, 0);
        GridPane.setColumnSpan(outCbUnit, 3);
        outCbUnit.setPrefWidth(658);
        // convertButton
        convertButton.setPrefWidth(600);
        GridPane.setMargin(convertButton, new Insets(10));
        GridPane.setRowIndex(convertButton, 4);
        GridPane.setColumnIndex(convertButton, 0);
        GridPane.setColumnSpan(convertButton, 3);
        // resultLabel
        resultLabel.setPrefWidth(600);
        resultLabel.setPadding(new Insets(10));
        GridPane.setRowIndex(resultLabel, 5);
        GridPane.setColumnIndex(resultLabel, 0);
        GridPane.setColumnSpan(resultLabel, 3);
        resultLabel.setAlignment(Pos.CENTER);
        // add to gridpane
        gp.getChildren().addAll(inpLabel,inpField,inpCbUnit,outCbUnit,convertButton,resultLabel);


    }
}
