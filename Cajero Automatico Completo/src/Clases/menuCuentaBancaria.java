package Clases;

import javax.swing.JOptionPane;

// Clase para manejar el menú de cuentas bancarias
public class menuCuentaBancaria {

    // Atributo para manejar una cuenta bancaria específica
    private cuentaBancaria objCuenta;
    // Array para almacenar varias cuentas bancarias
    private cuentaBancaria[] cuentas = new cuentaBancaria[3];

    // Método para mostrar el menú de opciones
    public void mostrarMenu() {

        JOptionPane.showMessageDialog(null, "Inserta tu Tarjeta");

        // Inicializar cuentas bancarias
        this.objCuenta = new cuentaBancaria();
        this.objCuenta.setNombreCliente("María Ortega");
        this.objCuenta.setNumeroCuenta("1000001");
        this.objCuenta.setSaldo(400);

        this.objCuenta = new cuentaBancaria();
        this.objCuenta.setNombreCliente("Roberto Arteaga");
        this.objCuenta.setNumeroCuenta("1000002");
        this.objCuenta.setSaldo(200);

        this.objCuenta = new cuentaBancaria();
        this.objCuenta.setNombreCliente("Carlos Marroquin");
        this.objCuenta.setNumeroCuenta("1000004");
        this.objCuenta.setSaldo(500);

        // Asignar las cuentas al array
        cuentas[0] = this.objCuenta;

        cuentaBancaria cuenta1 = new cuentaBancaria();
        cuenta1.setNombreCliente("María Ortega");
        cuenta1.setNumeroCuenta("1000001");
        cuenta1.setSaldo(400);
        cuentas[0] = cuenta1;

        cuentaBancaria cuenta2 = new cuentaBancaria();
        cuenta2.setNombreCliente("Roberto Arteaga");
        cuenta2.setNumeroCuenta("1000002");
        cuenta2.setSaldo(200);
        cuentas[1] = cuenta2;

        cuentaBancaria cuenta3 = new cuentaBancaria();
        cuenta3.setNombreCliente("Carlos Marroquin");
        cuenta3.setNumeroCuenta("1000004");
        cuenta3.setSaldo(500);
        cuentas[2] = cuenta3;

        // Solicitar al usuario que ingrese su número de cuenta
        String numeroCuenta = JOptionPane.showInputDialog("Ingrese su número de cuenta");

        // Buscar la cuenta bancaria correspondiente al número ingresado
        objCuenta = cuentaBancaria.buscarCuenta(cuentas, numeroCuenta);

        // Si se encuentra la cuenta
        if (objCuenta != null) {
            String dato = "";
            int opcion = 0;

            // Mostrar el menú de opciones
            String opcionMenu = "Elija una opción : \n";
            opcionMenu += "1. Consulta tu saldo\n";
            opcionMenu += "2. Retiros\n";
            opcionMenu += "3. Consignaciones\n";
            opcionMenu += "4. Transferencias\n";
            opcionMenu += "5. Salir\n";

            // Ciclo para mostrar el menú hasta que el usuario decida salir
            do {
                boolean validInput = false;

                while (!validInput) {
                    dato = JOptionPane.showInputDialog(opcionMenu);
                    if (dato == null || dato.isEmpty() || !dato.matches("[1-5]")) {
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido entre 1 y 5.");
                    } else {
                        opcion = Integer.parseInt(dato);
                        validInput = true;
                    }
                }

                // Manejo de las opciones del menú
                switch (opcion) {
                    case 1: // Consulta de saldo
                        JOptionPane.showMessageDialog(null, "El saldo actual de la cuenta " + numeroCuenta + " \nes $" + this.objCuenta.getSaldo());
                        break;

                    case 2: // Retiro de efectivo
                        double montoRetiro = 0;
                        boolean validRetiro = false;
                        while (!validRetiro) {
                            dato = JOptionPane.showInputDialog(null, "Cantidad a retirar?");
                            if (dato == null || dato.isEmpty() || !dato.matches("\\d+")) { // Verificar que la entrada sea un número positivo
                                JOptionPane.showMessageDialog(null, "Error: Debe ingresar una cantidad válida.");
                                if (dato == null)
                                    //EL usuario presiono "Cancelar", regresar al menú
                                    break;
                            } else {
                                montoRetiro = Double.parseDouble(dato);
                                if (montoRetiro > 0) {
                                    if (this.objCuenta.retiroEfectivo(montoRetiro)) {
                                        JOptionPane.showMessageDialog(null, "RETIRO EXITOSO!!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Fondos insuficientes");
                                    }
                                    validRetiro = true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser positiva.");
                                }
                            }
                        }
                        break;

                    case 3: // Consignaciones
                        double montoDeposito = 0;
                        boolean validDeposito = false;
                        while (!validDeposito) {
                            dato = JOptionPane.showInputDialog("Cantidad a consignar");
                            if (dato == null || dato.isEmpty() || !dato.matches("\\d+")) { // Verificar que la entrada sea un número positivo
                                JOptionPane.showMessageDialog(null, "Error: Debe ingresar una cantidad válida.");
                                if (dato == null)
                                    //EL usuario presiono "Cancelar", regresar al menú
                                    break;
                            } else {
                                montoDeposito = Double.parseDouble(dato);
                                if (montoDeposito > 0) {
                                    this.objCuenta.depositarEfectivo(montoDeposito);
                                    JOptionPane.showMessageDialog(null, "CONSIGNACION EXITOSA!! ");
                                    validDeposito = true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser positiva.");
                                }
                            }
                        }
                        break;

                    case 4: // Transferencias
                        double montoEnvio = 0;
                        String NumeroEnvio = JOptionPane.showInputDialog(null, "Cuenta de destino");
                        boolean validTransferencia = false;
                        while (!validTransferencia) {
                            dato = JOptionPane.showInputDialog(null, "Cantidad a transferir?");
                            if (dato == null || dato.isEmpty() || !dato.matches("\\d+")) { // Verificar que la entrada sea un número positivo
                                JOptionPane.showMessageDialog(null, "Error: Debe ingresar una cantidad válida.");
                                if (dato == null)
                                    //EL usuario presiono "Cancelar", regresar al menú
                                    break;
                            } else {
                                montoEnvio = Double.parseDouble(dato);
                                if (montoEnvio > 0) {
                                    if (this.objCuenta.transferenciaSaldo(montoEnvio)) {
                                        JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA A LA CUENTA: " + NumeroEnvio);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Fondos insuficientes");
                                    }
                                    validTransferencia = true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser positiva.");
                                }
                            }
                        }
                        break;

                    case 5: // Salir
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿REALMENTE DESEAS SALIR?", "EXIT", JOptionPane.YES_NO_OPTION);

                        if (respuesta == JOptionPane.YES_OPTION) {
                            System.out.println("Has seleccionado Sí");
                        } else if (respuesta == JOptionPane.NO_OPTION) {
                            System.out.println("Has seleccionado No");
                            opcion = 0; // Regresar al menú
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida, por favor elija una opción del menú");
                        break;
                }
            } while (opcion != 5); // Repetir hasta que la opción sea 5 (salir)
        } else {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
        }
    }
}
