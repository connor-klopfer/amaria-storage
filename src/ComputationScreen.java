import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class ComputationScreen extends VBox{
	GridPane numberScreen;
	HBox buttonPane;
	HBox stateOptions;
	RadioButton liquidOption;
	RadioButton solidOption;
	AdditionLabel targetVolumeLabel; 
	InventoryTextFields targetVolumeInput;
	AdditionLabel targetConcentrationLabel;
	InventoryTextFields targetConcentrationInput;
	AdditionLabel drugOptionLabel;
	ComboBox<String> options;
	AdditionLabel diluentLabel;
	InventoryTextFields diluentInput;
	AdditionLabel drugLabel;
	InventoryTextFields drugInput;
	ToggleGroup stateGroupings;
	
	InventoryButton aliquotButton;
	InventoryButton byMassButton;
	InventoryButton byVolumeButton;
	
	
	
	//Insert Coluclations buttons here, which are dynamic and change with the dirrerent options
	
	
	ComputationScreen(ArrayList<Compound> compounds){
		
		this.setAlignment(Pos.CENTER);
		stateOptions = new HBox();
		stateOptions.setAlignment(Pos.CENTER);
		
		liquidOption = new RadioButton("Liquid");
		solidOption  = new RadioButton("Solid");
		stateGroupings = new ToggleGroup();
		solidOption.setToggleGroup(stateGroupings);
		liquidOption.setToggleGroup(stateGroupings);
		stateOptions.getChildren().addAll(liquidOption, solidOption);
		numberScreen = new GridPane();
		numberScreen.setAlignment(Pos.CENTER);
		
		this.setSpacing(Screen.getPrimary().getBounds().getHeight() * .01);
		numberScreen.setLayoutX(Screen.getPrimary().getBounds().getWidth() *.3);
		numberScreen.setLayoutY(Screen.getPrimary().getBounds().getHeight());
		
		
		targetVolumeLabel = new AdditionLabel("Target Volume: ");
		targetVolumeInput = new InventoryTextFields();
		targetConcentrationLabel = new AdditionLabel("Target Concentration: ");
		targetConcentrationInput = new InventoryTextFields();
		targetConcentrationInput.setText("Target Concentration Here");
		
		drugOptionLabel = new AdditionLabel("Drug Option: ");
		options = new ComboBox<String>();
		diluentLabel = new AdditionLabel("Amount of Diluent: ");
		diluentInput = new InventoryTextFields();
		drugLabel = new AdditionLabel("Amount of Diluent: ");
		drugInput = new InventoryTextFields();
		aliquotButton = new InventoryButton("Make Aliquots");
		byMassButton  = new InventoryButton("Find By Mass");
		byVolumeButton = new InventoryButton("Find By Volume");
		
		numberScreen.add(targetVolumeLabel, 0,0); numberScreen.add(targetVolumeInput, 1, 0);
		numberScreen.add(targetConcentrationLabel, 0, 1); numberScreen.add(targetConcentrationInput, 1, 1);
		numberScreen.add(drugOptionLabel, 0, 2); numberScreen.add(options, 1, 2);
		numberScreen.add(diluentLabel, 0, 3); numberScreen.add(diluentInput, 1, 3);
		numberScreen.add(drugLabel, 0, 4); numberScreen.add(drugInput, 1, 4);
		
		numberScreen.setHgap(Screen.getPrimary().getBounds().getWidth() * .1);
		numberScreen.setVgap(Screen.getPrimary().getBounds().getHeight() * .01);
		
		buttonPane = new HBox();
		buttonPane.getChildren().addAll(aliquotButton, byMassButton, byVolumeButton);
		buttonPane.setSpacing(Screen.getPrimary().getBounds().getWidth() *.01);
		buttonPane.setAlignment(Pos.CENTER);;
		
		for(Compound x : compounds){
			options.getItems().add(x.toString());
		}
		
		this.getChildren().addAll(stateOptions, numberScreen, buttonPane);
		
	}
	
	void buildScreen(InventoryButton backButton){
		if(this.buttonPane.getChildren().size() > 1){
			this.buttonPane.getChildren().remove(backButton);
		}
		this.buttonPane.getChildren().add(backButton);
	}


	/**
	 * @return the liquidOption
	 */
	public RadioButton getLiquidOption() {
		return liquidOption;
	}


	/**
	 * @return the solidOption
	 */
	public RadioButton getSolidOption() {
		return solidOption;
	}


	/**
	 * @return the targetVolumenInput
	 */
	public InventoryTextFields getTargetVolumenInput() {
		return targetVolumeInput;
	}


	/**
	 * @return the targetConcentrationInput
	 */
	public InventoryTextFields getTargetConcentrationInput() {
		return targetConcentrationInput;
	}


	/**
	 * @return the drugOption
	 */
	public AdditionLabel getDrugOption() {
		return drugOptionLabel;
	}


	/**
	 * @return the options
	 */
	public ComboBox<String> getOptions() {
		return options;
	}


	/**
	 * @return the drugInput
	 */
	public InventoryTextFields getDrugInput() {
		return drugInput;
	}


	/**
	 * @param liquidOption the liquidOption to set
	 */
	public void setLiquidOption(RadioButton liquidOption) {
		this.liquidOption = liquidOption;
	}


	/**
	 * @param solidOption the solidOption to set
	 */
	public void setSolidOption(RadioButton solidOption) {
		this.solidOption = solidOption;
	}


	/**
	 * @param targetVolumenInput the targetVolumenInput to set
	 */
	public void setTargetVolumenInput(InventoryTextFields targetVolumenInput) {
		this.targetVolumeInput = targetVolumenInput;
	}


	/**
	 * @param targetConcentrationInput the targetConcentrationInput to set
	 */
	public void setTargetConcentrationInput(InventoryTextFields targetConcentrationInput) {
		this.targetConcentrationInput = targetConcentrationInput;
	}


	/**
	 * @param drugOption the drugOption to set
	 */
	public void setDrugOption(AdditionLabel drugOption) {
		this.drugOptionLabel = drugOption;
	}


	/**
	 * @param options the options to set
	 */
	public void setOptions(ComboBox<String> options) {
		this.options = options;
	}


	/**
	 * @param drugInput the drugInput to set
	 */
	public void setDrugInput(InventoryTextFields drugInput) {
		this.drugInput = drugInput;
	}
	

}