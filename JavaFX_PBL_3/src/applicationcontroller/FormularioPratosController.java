package applicationcontroller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class FormularioPratosController {
	@FXML
	private TextField textFNome;
	@FXML
	private TextField textFPreco;
	@FXML
	private TextField textFCategoria;
	@FXML
	private Button voltarMenu;
	@FXML
	private Button novoPrato;

	// Event Listener on Button[#voltarMenu].onAction
	@FXML
	public void acaoVoltarMenu(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#novoPrato].onAction
	@FXML
	public void acaoAddPrato(ActionEvent event) {
		// TODO Autogenerated
	}
}