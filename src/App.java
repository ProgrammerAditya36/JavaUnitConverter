import converterExceptions.MagnitudeException;
import converterGUIconfig.Layout;
import converterThreads.derUnitThread;
import converterThreads.funUnitThread;
import converterThreads.stdUnitThread;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene; 
import javafx.scene.layout.*;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.control.Alert.AlertType;

public class App extends Application {
    void InpAlert(String title, String msg){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    void clearWindow(GridPane root){
        root.getChildren().removeIf(node->node instanceof ComboBox);
        root.getChildren().removeIf(node->node instanceof TextField);
        root.getChildren().removeIf(node->node instanceof Label);
        root.getChildren().removeIf(node->node instanceof Button);
    }
    boolean MagnitudeOutofRange(TextField s){
        return Math.abs(Double.parseDouble(s.getText()))>1E12;
    } 
    int getIndex(String []arr, String ele){
        for (int i=0;i<arr.length;i++){
            if(arr[i].equals(ele)){
                return i;
            }
        }
        return -1;
    }
    void addLabel(FlowPane root, String text){
        Label label = new Label(text);
        root.getChildren().add(label);
    }
    public void start(Stage s) throws MagnitudeException    {
        s.setTitle("Unit Converter");
        Menu stdMenu = new Menu("Standard Unit Conversion"); 
        Menu derMenu = new Menu("Derived Units");
        Menu funMenu = new Menu("Fun Conversions");
        String []stdUnits = {"Mass","Time","Angle","Area","Data","Length","Speed","Temperature","Volume"};
        String []derUnits = {"BMI", "Relative Density"};
        String []funUnits = {"Mass Conversions","Length Conversions","Speed Conversions"};
        String [][] choices = {{"Kg","mg","dg","cg","g","dag","hg","ton","lbs"},{"sec","min","hrs","day","week","month","year"},{"deg","min","sec","rad","rev"},{"sqm","sqin","sqft","sqkm","sqcm","sqmm","sqyd","sqmi","acre","hectare"},{"bit","byt","kb","mb","gb","tb","pb","eb"},{"m","km","mi","y","ft","in","mm","cm","dm","mum","pm","nmi","pc","au","ly"},{"mps","kmph","miph","ypm","roots","mach","knots"},{"celsius","fahrenheit","kelvin","rankin"},{"cm","gal","lit","cf","ci","ml","flo","qui"}};
        MenuItem stdItems[] = new MenuItem[stdUnits.length];
        for(int i =0;i<stdUnits.length;i++){
            stdItems[i] = new MenuItem(stdUnits[i]);
        }
        MenuItem derItems[] = new MenuItem[derUnits.length];
        for(int i =0;i<derUnits.length;i++){
            derItems[i] = new MenuItem(derUnits[i]);
        }
        MenuItem funItems[] = new MenuItem[funUnits.length];
        for(int i =0;i<funUnits.length;i++){
            funItems[i] = new MenuItem(funUnits[i]);
        }
        stdMenu.getItems().addAll(stdItems);
        derMenu.getItems().addAll(derItems);
        funMenu.getItems().addAll(funItems);
        GridPane root = new GridPane();
        root.setLayoutX(1);
        root.setLayoutY(2);        
        root.setPrefSize(367,600);    


        stdMenu.setOnAction( new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {   
                stdMenu.setText(((MenuItem)e.getTarget()).getText()+" Converter");
                derMenu.setText("Derived Units");
                funMenu.setText("Fun Conversions");
                String choice =(((MenuItem)e.getTarget()).getText()); 
                int index = getIndex(stdUnits, choice);                
                ObservableList<String> cboxUnitList = FXCollections.observableArrayList(choices[index]);
                ComboBox<String> fromCbUnit = new ComboBox<String>(cboxUnitList);
                ComboBox<String> toCbUnit = new ComboBox<String>(cboxUnitList);                
                fromCbUnit.setValue(choices[index][0]);
                toCbUnit.setValue(choices[index][1]);
                Label fromLabel = new Label("From:-");
                Label toLabel = new Label("To:-");
                Label inpLabel = new Label("Enter value:-");
                Label resultLabel = new Label("");
                TextField inpField = new TextField();
                Button convertButton = new Button("Convert");                
                clearWindow(root);
                Layout.setStdUnitWindow(root, inpLabel, inpField, fromLabel, fromCbUnit, toLabel, toCbUnit, convertButton, resultLabel);             
                
                convertButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e){                  
                        try {
                            String inp = inpField.getText()+"#"+fromCbUnit.getValue()+"#"+toCbUnit.getValue();
                            stdUnitThread t = new stdUnitThread(index+1, inp);
                            t.join();

                            if(MagnitudeOutofRange(inpField)){
                                throw new MagnitudeException();
                            }
                            else{
                                resultLabel.setText(t.uc.toString());
                            }

                        } 
                        catch(MagnitudeException exc){
                            InpAlert("Input Exceeds Range", "Please input correct number within -1E12 to 1E12");
                        }
                        catch (NumberFormatException exe) {
                            InpAlert("Invalid Input", "Please enter a number");
                        }                        
                        catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        
                        
                    }
                });          
            } 
        } );  
        derMenu.setOnAction( new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {   
                derMenu.setText(((MenuItem)e.getTarget()).getText()+" Calculator");
                stdMenu.setText("Standard Unit Converter");
                funMenu.setText("Fun Conversions");
                String choice =(((MenuItem)e.getTarget()).getText());
                Label inp1Label = new Label("");                         
                TextField inp1Field = new TextField();
                Label inp2Label = new Label("");
                TextField inp2Field = new TextField();
                ComboBox<String> inp1CbUnit= new ComboBox<String>() ;
                ComboBox<String> inp2CbUnit= new ComboBox<String>();
                Label resultLabel = new Label("");
                Button convertButton = new Button("Enter");
                clearWindow(root);
                Layout.setDerUnitWindow(root, inp1Label, inp1Field, inp1CbUnit, inp2Label, inp2Field, inp2CbUnit, convertButton, resultLabel);
                
                switch (getIndex(derUnits, choice)) {
                    case 0:
                        ObservableList<String> inp1UnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Mass")]);
                        inp1Label.setText("Enter Weight:-");
                        inp2Label.setText("Enter Height:-");
                        ObservableList<String> inp2UnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Length")]);
                        inp1CbUnit.setValue(choices[getIndex(stdUnits, "Mass")][0]);                        
                        inp1CbUnit.setItems(inp1UnitList);
                        inp2CbUnit.setValue(choices[getIndex(stdUnits, "Length")][0]);
                        inp2CbUnit.setItems(inp2UnitList);                        
                        break;
                    case 1:{
                        inp1UnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Mass")]);
                        inp1Label.setText("Enter Mass:-");
                        inp2Label.setText("Enter Volume:-");
                        inp2UnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Volume")]);
                        inp1CbUnit.setValue(choices[getIndex(stdUnits, "Mass")][0]);                        
                        inp1CbUnit.setItems(inp1UnitList);
                        inp2CbUnit.setValue(choices[getIndex(stdUnits, "Volume")][0]);
                        inp2CbUnit.setItems(inp2UnitList);                        
                        break;
                    }
                    default:
                        break;
                }
                convertButton.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e){
                                try{
                                    derUnitThread dt = new derUnitThread(getIndex(derUnits, choice)+1, inp1Field.getText(),inp1CbUnit.getValue(),inp2Field.getText(),inp2CbUnit.getValue());
                                    dt.t.join();
                                    if(MagnitudeOutofRange(inp1Field)||MagnitudeOutofRange(inp2Field)) {
                                        throw new MagnitudeException();
                                    } else{
                                        resultLabel.setText(dt.du.toString());
                                    }
                                }catch(NumberFormatException exe){
                                    InpAlert("No Number entered", "Please enter a number");
                                }
                                catch(MagnitudeException exc){
                                    InpAlert("Input Exceeds Range", "Please input correct number within -1E12 to 1E12");
                                }
                                catch(InterruptedException ex){
                                    ex.printStackTrace();
                                }                              
                                
                            }
                        });
                
            
            } 
        } );  
        funMenu.setOnAction( new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {   
                funMenu.setText(((MenuItem)e.getTarget()).getText());
                stdMenu.setText("Standard Unit Converter");
                derMenu.setText("Derived Units");
                String choice =(((MenuItem)e.getTarget()).getText());
                Label inpLabel = new Label("");                         
                TextField inpField = new TextField();                
                ComboBox<String> inpCbUnit= new ComboBox<String>() ;
                ComboBox<String> outCbUnit= new ComboBox<String>() ;
                Label resultLabel = new Label("");
                Button convertButton = new Button("Enter");
                clearWindow(root);
                Layout.setFunUnitWindow(root, inpLabel, inpField, inpCbUnit, outCbUnit, convertButton, resultLabel);
                
                switch (getIndex(funUnits, choice)) {
                    case 0:{
                        String choices_f[] = {"humans","dogs","suns","tigers","earths","hydrogen atom"};
                        ObservableList<String> inpUnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Mass")]);
                        inpLabel.setText("Enter Weight:-");                        
                        ObservableList<String> inp2UnitList = FXCollections.observableArrayList(choices_f);
                        inpCbUnit.setValue(choices[getIndex(stdUnits, "Mass")][0]);                        
                        inpCbUnit.setItems(inpUnitList);
                        outCbUnit.setValue("Choose Weight Equivalence");
                        outCbUnit.setItems(inp2UnitList);                

                        break;
                    }
                    case 1:{
                        String choices_f[] = {"humans","ruler","tree","football stadium","earths","hydrogen atom"};
                        ObservableList<String> inpUnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Length")]);
                        inpLabel.setText("Enter Length:-");                        
                        ObservableList<String> inp2UnitList = FXCollections.observableArrayList(choices_f);
                        inpCbUnit.setValue(choices[getIndex(stdUnits, "Length")][0]);                        
                        inpCbUnit.setItems(inpUnitList);
                        outCbUnit.setValue("Choose Length Equivalence");
                        outCbUnit.setItems(inp2UnitList);
                        break;
                    }
                    case 2:{
                        String choices_f[] = {"humans","cheetah","earth orbitspeed","light","tortoise","electron"};
                        ObservableList<String> inpUnitList = FXCollections.observableArrayList(choices[getIndex(stdUnits, "Speed")]);
                        inpLabel.setText("Enter Speed:-");                        
                        ObservableList<String> inp2UnitList = FXCollections.observableArrayList(choices_f);
                        inpCbUnit.setValue(choices[getIndex(stdUnits, "Speed")][0]);                        
                        inpCbUnit.setItems(inpUnitList);
                        outCbUnit.setValue("Choose Speed Equivalence");
                        outCbUnit.setItems(inp2UnitList);
                        break;
                    }
                    default:
                        break;
                }
                convertButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e){
                        try{
                            funUnitThread ft = new funUnitThread(getIndex(funUnits, choice)+1,outCbUnit.getValue(),inpField.getText(),inpCbUnit.getValue());
                            ft.join();
                            if(MagnitudeOutofRange(inpField))
                                throw new MagnitudeException();
                            else{
                            resultLabel.setText(ft.funConversions.toString());
                            }
                        }
                        catch(NumberFormatException exe){
                            InpAlert("No Number entered", "Please enter a number");
                        }
                        catch(MagnitudeException exc){
                            InpAlert("Input Exceeds Range", "Please input correct number within -1E12 to 1E12");
                        }
                        catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                    }
                });
                
            
            } 
        } );  

        MenuBar stdMenuBar = new MenuBar();         
        stdMenuBar.getMenus().addAll(stdMenu,derMenu,funMenu); 
        

        

        root.add(stdMenuBar, 0, 0, 4, 1);
        root.getColumnConstraints().addAll(Layout.setColumnConstraints());
        root.getRowConstraints().addAll(Layout.setRowConstraints());
        Scene sc = new Scene(root, 600, 400);
        s.setScene(sc);
        s.show();
        
    } 
  
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} 