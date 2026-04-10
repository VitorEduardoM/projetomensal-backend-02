import config.FlyWayConfiguracao;
import iniciadorSistema.SistemaIniciar;

public class Main {
    public static void main(String[] args) {
        FlyWayConfiguracao.migrate();
        SistemaIniciar sistemaIniciar = new SistemaIniciar();
        sistemaIniciar.iniciar();
    }
}