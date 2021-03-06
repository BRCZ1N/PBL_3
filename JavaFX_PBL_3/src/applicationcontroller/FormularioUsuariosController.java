package applicationcontroller;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationexeceptions.CamposNulosException;
import applicationexeceptions.LoginExistenteException;
import applicationmain.Main;
import applicationmodel.Usuarios;
import applicationmodeldao.DaoFacade;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * Classe controlador do formulario de usuarios
 * 
 * @author Bruno Campos de Oliveira Rocha
 * @author Alex da Fonseca Dantas Junior
 * @version 1.0
 * @since 2022
 */

public class FormularioUsuariosController implements Initializable {
	@FXML
	private TextField textFNome;
	@FXML
	private TextField textFLogin;
	@FXML
	private PasswordField textFSenha;
	@FXML
	private Button voltarMenu;
	@FXML
	private Label labelNovoUsuario;
	@FXML
	private Label labelEditarUsuario;
	@FXML
	private Button novoUsuario;
	@FXML
	private Button editarUsuario;

	private static Usuarios usuarioAtual;

	/**
	 * M�todo para retorno do conteudo do usuario selecionado.
	 * 
	 * @return Usuarios usuarioAtual
	 */
	public static Usuarios getUsuarioAtual() {
		return usuarioAtual;
	}

	/**
	 * M�todo para setar o conteudo do usuario selecionado.
	 * 
	 * @param usuarioAtual Usuarios
	 */
	public static void setUsuarioAtual(Usuarios usuarioAtual) {
		FormularioUsuariosController.usuarioAtual = usuarioAtual;
	}

	/**
	 * M�todo para retornar ao gerenciamento de usuarios.
	 * 
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	public void voltarMenuAcao(ActionEvent event) throws IOException {

		mudarJanela("/applicationviewcssfxml/GerenciamentoUsuarios.fxml");
		limparUsuario();

	}

	/**
	 * M�todo para salvar o Usuario apos a confirmação.
	 * 
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	public void salvarUsuarioAcao(ActionEvent event) throws IOException, LoginExistenteException {

		try {
			if (usuarioAtual == null) {

				DaoFacade.addEditUsuarios(null, textFLogin.getText(), textFSenha.getText(), textFNome.getText());
				// DaoUsuarios.addEditDados(usuarioNovo, null);

			} else {

				DaoFacade.addEditUsuarios(usuarioAtual.getId(), textFLogin.getText(), textFSenha.getText(),
						textFNome.getText());
				// DaoUsuarios.addEditDados(usuarioNovo, usuarioAtual.getId());

			}

			mudarJanela("/applicationviewcssfxml/GerenciamentoUsuarios.fxml");
			limparUsuario();

		} catch (LoginExistenteException | CamposNulosException e) {
			Alertas.erro(e.getMessage());
		}

	}

	/**
	 * M�todo para inicializar a pagina selecionada pelo gerenciamento
	 * 
	 * @param arg0 URL
	 * @param arg1 ResourceBundle
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (usuarioAtual != null) {

			textFLogin.setText(usuarioAtual.getLoginUsuario());
			textFNome.setText(usuarioAtual.getNomeUsuario());
			textFSenha.setText(usuarioAtual.getSenhaUsuario());

		}

	}

	/**
	 * Metodo para setar o usuario atual como nulo
	 */
	public void limparUsuario() {

		usuarioAtual = null;

	}

	/**
	 * M�todo para mudar para a janela determinada.
	 * 
	 * @param urlScene String
	 * @throws IOException
	 */
	public void mudarJanela(String urlScene) throws IOException {

		Main.getStage().setScene(novaCena(urlScene));
		;
	}

	/**
	 * M�todo para criar uma nova janela determinada
	 * 
	 * @param urlScene String
	 * @throws IOException
	 */
	public Scene novaCena(String urlScene) throws IOException {

		FXMLLoader fxml = new FXMLLoader(getClass().getResource(urlScene));
		Parent root = fxml.load();
		Scene scene = new Scene(root);

		return scene;

	}

}
