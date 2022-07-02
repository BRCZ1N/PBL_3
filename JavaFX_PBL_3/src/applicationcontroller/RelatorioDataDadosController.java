package applicationcontroller;

import java.time.LocalDate;
import applicationmain.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class RelatorioDataDadosController {

	@FXML
	private Button botaoCancelar;
	@FXML
	private Button botaoConfirmar;
	@FXML
	private DatePicker datePickerFinal;
	@FXML
	private DatePicker datePickerInicial;

	private static boolean resposta;

	private static LocalDate dataInicial;
	
	private static LocalDate dataFinal;

	public static boolean isRespostaAlerta() {
		return resposta;
	}
	/**
	 * M�todo para setar a resposta de um botão 
	 * 
	 * @param reposta boolean
	 */
	public static void setResposta(boolean resposta) {
		RelatorioDataDadosController.resposta = resposta;
	}

	/**
	 * M�todo para retorno da quantidade de um produto
	 * 
	 * @return LocalDate dataInicial
	 */

	public static LocalDate getDataInicial() {
		return dataInicial;
	}
	
	/**
	 * M�todo para retorno da quantidade de um produto
	 * 
	 * @return LocalDate dataFinal
	 */
	
	public static LocalDate getDataFinal() {
		return dataFinal;
	}

	/**
	 * M�todo para setar a data inicial da geração de relatorio por periodo
	 * 
	 * @param LocalDate dataInicial
	 */
	public static void setDataInicial(LocalDate dataInicial) {
		RelatorioDataDadosController.dataInicial = dataInicial;
	}
	
	/**
	 * M�todo para setar a data final da gereação de relatorio por periodo
	 * 
	 * @param LocalDate dataFinal
	 */
	
	public static void setDataFinal(LocalDate dataFinal) {
		RelatorioDataDadosController.dataFinal = dataFinal;
	}

	/**
	 * M�todo para confirmar a seleção das datas e gerar relatorio
	 * @param ActionEvent event
	 */
	@FXML
	public void botaoConfirmarAcao(ActionEvent event) {

		setResposta(true);
		setDataInicial(datePickerInicial.getValue());
		setDataFinal(datePickerFinal.getValue());
		Main.getStage2().close();
	}

	/**
	 * M�todo para cancelar a seleção de datas para criação do relatorio
	 * @param ActionEvent event
	 */
	@FXML
	public void botaoCancelarAcao(ActionEvent event) {

		setResposta(false);
		Main.getStage2().close();

	}

}
