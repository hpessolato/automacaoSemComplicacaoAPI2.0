package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silviosantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {

        xuxa = new Cliente("Xuxa", "12345678900", "123456789");
        silviosantos = new Cliente("Silvio Santos", "00987654321", "987654321");

        contaXuxa = new Conta("0001", "12345", 2500.00, xuxa);
        contaSilvio = new Conta("0002", "67890", 3500.00, silviosantos);

    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00, contaSilvio);

        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());

        }

    @Test
    public void validarTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);

        assertFalse(resultado);

        }

    @Test
    public void validarProprietario(){

        assertEquals(xuxa, contaXuxa.getProprietario());
        assertEquals(silviosantos, contaSilvio.getProprietario());

    }

    @Test
    public void validarAgencia(){

        assertEquals("0001", contaXuxa.getAgencia());
        assertEquals("0002", contaSilvio.getAgencia());

    }

    @Test
    public void validarNumeroConta(){

        assertEquals("12345", contaXuxa.getNumeroConta());
        assertEquals("67890", contaSilvio.getNumeroConta());

    }

    @Test
    public void validarNome(){

        assertEquals("Xuxa", xuxa.getNome());
        assertEquals("Silvio Santos", silviosantos.getNome());

    }


    @Test
    public void validarCPF(){

        assertEquals("12345678900", xuxa.getCpf());
        assertEquals("00987654321", silviosantos.getCpf());

    }

    @Test
    public void validarRG(){

        assertEquals("123456789", xuxa.getRg());
        assertEquals("987654321", silviosantos.getRg());

    }

}