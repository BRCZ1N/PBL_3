package applicationcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import applicationmain.Main;
import applicationmodel.Clientes;
import applicationmodel.Vendas;
import applicationmodeldao.DaoVendas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Classe controlador da tela de detalhes do cliente
 * 
 * @author Bruno Campos de Oliveira Rocha
 * @author Alex da Fonseca Dantas Junior
 * @version 1.0
 * @since 2022
 */
public class TelaDetalhesClientesController implements Initializable {

	@FXML
	private TextField textFNomeExibir;
	@FXML
	private TextField textFTelefoneExibir;
	@FXML
	private TextField textFEmailExibir;
	@FXML
	private TextField textFCpfExibir;
	@FXML
	private Button voltarMenu;
	@FXML
	private TableColumn<Vendas, String> columnCarrinhoVendaId;
	@FXML
	private TableColumn<Vendas, Double> columnCarrinhoVendaValor;
	@FXML
	private TableView<Vendas> tabelaCompraClienteExibir;

	private ArrayList<Vendas> listaVendasCarrinho = new ArrayList<Vendas>();

	private static Clientes clienteAtual;

	/**
	 * M�todo para retorno do conteudo do cliente selecionado.
	 * 
	 * @return Clientes clienteAtual
	 */
	public static Clientes getClienteAtual() {
		return clienteAtual;
	}

	/**
	 * M�todo para setar o conteudo do cliente selecionado.
	 * 
	 * @param clienteAtual Clientes
	 */
	public static void setClienteAtual(Clientes clienteAtual) {
		TelaDetalhesClientesController.clienteAtual = clienteAtual;
	}

	/**
	 * M�todo para retornar ao gerenciamento de Clientes.
	 * 
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	public void voltarMenuAcao(ActionEvent event) throws IOException {

		mudarJanela("/applicationviewcssfxml/GerenciamentoCliente.fxml");
		limparCliente();

	}

	/**
	 * M�todo para mudar para a janela determinada.
	 * 
	 * @param urlScene String
	 * @throws IOException
	 */
	public void mudarJanela(String urlScene) throws IOException {

		Main.getStage().setScene(novaCena(urlScene));

	}

	/**
	 * Metodo para setar o cliente atual como nulo
	 */
	public void limparCliente() {

		clienteAtual = null;

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

	/**
	 * M�todo para criar uma tabela onde serão exibidos as informações de forma mais
	 * explicita.
	 */
	public void tabelaDetalhes() {

		ObservableList<Vendas> observableVendaCarrinho = FXCollections.observableArrayList(listaVendasCarrinho);
		tabelaCompraClienteExibir.setItems(observableVendaCarrinho);
		columnCarrinhoVendaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnCarrinhoVendaValor.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));

	}

	/**
	 * M�todo para inicializar a pagina selecionada pelo gerenciamento
	 * 
	 * @param arg0 URL
	 * @param arg1 ResourceBundle
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (clienteAtual != null) {

			textFNomeExibir.setText(clienteAtual.getNome());
			textFCpfExibir.setText(clienteAtual.getCpf());
			textFEmailExibir.setText(clienteAtual.getEmail());
			textFTelefoneExibir.setText(clienteAtual.getTelefone());
			listaVendasCarrinho.addAll(DaoVendas.getListaVenda(clienteAtual.getIdHistoricoCompras()));

		}

		tabelaDetalhes();

	}

}
