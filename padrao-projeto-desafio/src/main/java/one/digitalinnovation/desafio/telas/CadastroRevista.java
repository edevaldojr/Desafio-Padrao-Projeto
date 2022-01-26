package one.digitalinnovation.desafio.telas;

import one.digitalinnovation.desafio.repositorios.Biblioteca;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroRevista {
    
    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfEditora;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfPaginas;

    @FXML
    private TextField tfAnoPublicacao;

    
    private Biblioteca biblioteca;

    
    public CadastroRevista(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
       
    }
    @FXML
    private void cadastrar(){
        String titulo = tfTitulo.getText();
        String editora = tfEditora.getText();
        int anoPublicacao = Integer.valueOf(tfAnoPublicacao.getText());
        int numero = Integer.valueOf(tfNumero.getText());
        int paginas = Integer.valueOf(tfPaginas.getText());

        String msg = "";
        boolean flag = true;

        if( paginas < 10 ){
            msg += "Número de páginas inválido!";
            flag = false;
        }

        if(flag){
            
            boolean ret = biblioteca.cadastraRevista(titulo, numero, anoPublicacao, paginas, editora);
            if(ret){
                msg = "Cadastro realizado!";
                limpar();
            }else{
                msg = "Cadastro não realizado!";
            }
        }

        Alert popup = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        popup.showAndWait();
    }
    @FXML
    private void limpar(){
        tfTitulo.setText("");
        tfAnoPublicacao.setText("");
        tfEditora.setText("");
        tfNumero.setText("");
        tfPaginas.setText("");
    }

}
