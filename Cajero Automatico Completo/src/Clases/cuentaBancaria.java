package Clases;

public class cuentaBancaria {

    // Creación de atributos
    private String numeroCuenta; // Número de cuenta del cliente
    private String NombreCliente; // Nombre del cliente
    private double saldo; // Saldo de la cuenta

    // Un objeto de la misma clase para manejar una cuenta específica
    private cuentaBancaria objCuenta;

    // Un array para almacenar varias cuentas bancarias
    private cuentaBancaria[] cuentas = new cuentaBancaria[3];

    // Método estático para buscar una cuenta en el array de cuentas
    public static cuentaBancaria buscarCuenta(cuentaBancaria[] cuentas, String numeroCuenta) {
        // Recorrer el array de cuentas
        for (cuentaBancaria cuenta : cuentas) {
            // Si se encuentra una cuenta con el número de cuenta buscado, se retorna
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        // Si no se encuentra la cuenta, se retorna null
        return null;
    }

    // Métodos setter y getter para los atributos

    public void setNumeroCuenta(String pvalor) {
        numeroCuenta = pvalor;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNombreCliente(String pValor) {
        NombreCliente = pValor;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setSaldo(double pValor) {
        saldo = pValor;
    }

    public double getSaldo() {
        return saldo;
    }

    // Inicializar método constructor
    public cuentaBancaria() {
        numeroCuenta = "###-###"; // Valor por defecto del número de cuenta
        NombreCliente = "No asignado"; // Valor por defecto del nombre del cliente
        saldo = 0; // Valor por defecto del saldo
    }

    // Método para depositar efectivo en la cuenta
    public void depositarEfectivo(double monto) {
        this.setSaldo(this.getSaldo() + monto);
    }

    // Método para retirar efectivo de la cuenta
    public boolean retiroEfectivo(double monto) {
        boolean retirado = false;
        // Verificar si hay saldo suficiente para retirar
        if (this.getSaldo() >= monto) {
            this.setSaldo(this.getSaldo() - monto);
            retirado = true; // Retiro exitoso
        } else {
            System.out.println("Cantidad insuficiente");
        }
        return retirado;
    }

    // Método para consultar el saldo
    public double consultaSaldo(double saldo) {
        this.setSaldo(this.getSaldo() + saldo);
        return saldo;
    }

    // Método para transferir saldo a otra cuenta
    public boolean transferenciaSaldo(double monto) {
        boolean transferido = false;
        // Verificar si hay saldo suficiente para transferir
        if (this.getSaldo() >= monto) {
            this.setSaldo(this.getSaldo() - monto);
            transferido = true; // Transferencia exitosa
        } else {
            System.out.println("Cantidad insuficiente.");
        }
        return transferido;
    }

    // Atributo no utilizado en el código
    int numero = 0;
} // Cierre de clase
