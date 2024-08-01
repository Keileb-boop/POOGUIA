package Clases;

public class principalCuentaBancaria {

    // Método principal donde comienza la ejecución del programa
    public static void main(String[] args) {

        // Declaración de una variable para manejar el menú de cuentas bancarias
        menuCuentaBancaria objetMenuCuenta;

        // Creación de una instancia del menú de cuentas bancarias
        objetMenuCuenta = new menuCuentaBancaria();

        // Llamada al método para mostrar el menú de opciones al usuario
        objetMenuCuenta.mostrarMenu();

        // Finalización del programa
        System.exit(0);
    }
}
