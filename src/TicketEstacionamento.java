public class TicketEstacionamento {
    private int numero;
    private double valor;
    private boolean pago;

    public TicketEstacionamento(int numero) {
        this.numero = numero;
        this.valor = 12.0;
        this.pago = false;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void pagar() {
        this.pago = true;
        System.out.println("Pagamento feito com sucesso!");
    }
}