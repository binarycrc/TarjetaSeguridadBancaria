/*
 * Copyright (C) 2019 Pablo Ugalde Trejos
 * UNIVERSIDAD ESTATAL A DISTANCIA
 * 00824 Programacion Intermedia
 */
package tarjetaseguridadbancaria;

import java.util.Random;
/**
 *
 * @author Pablo Ugalde Trejos
 */
class Cliente extends Persona{
    /*********************************/
    /* Atributos de la clase Cliente */
    /*********************************/
    private int[] numerocliente; //arreglo para numero de cliente
    public int[][] numerotarjeta; //arreglo para numero de tarjeta
    private int intMinimo; //variable para el rango minimo de valores al azar
    private int intMaximo; //variable para el rango maximo de valores al azar
    private String[] celdas = new String[6]; //Arreglo para valores aleatorios del simulacro

    //constructor con parametros para el rango de datos aleatorios
    public Cliente(int intMinimo, int intMaximo) {
        this.intMinimo = intMinimo;
        this.intMaximo = intMaximo;
    }

    //Metodo para retornar numero cliente
    public int[] getNumerocliente() {return numerocliente;}
    //metodo para asignar arreglo numero cliente
    public void setNumerocliente(int[] numerocliente) {this.numerocliente = numerocliente;}
    //metodo para asignar arreglo numero cliente desde un string
    public void setNumerocliente(int intnumerocliente) {
        String temp = Integer.toString(intnumerocliente);
        int[] numerocliente = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            numerocliente[i] = temp.charAt(i) - '0';
        }
        this.numerocliente = numerocliente;
    }
    //metodo para crear el arreglo numero de cliente
    public void setNumerocliente() { numerocliente = new int[10]; } 
    //Metodo para retornar arreglo tarjeta
    public int[][] getNumerotarjeta() {return numerotarjeta;}
    //metodo para asignar arreglo numero tarjeta
    public void setNumerotarjeta(int[][] numerotarjeta) {this.numerotarjeta = numerotarjeta;}
    //metodo para crear el arreglo numero de tarjeta
    public void setNumerotarjeta() { numerotarjeta = new int[8][8]; }
    //Metodo para retornar rango minimo
    public int getIntMinimo() {return intMinimo;}
    //metodo para asignar rango minimo de los numeros aleatorios de la tarjeta
    public void setIntMinimo(int intMinimo) {this.intMinimo = intMinimo;}
    //Metodo para retornar rango maximo
    public int getIntMaximo() {return intMaximo;}
    //metodo para asignar rango maximo de los numeros aleatorios de la tarjeta
    public void setIntMaximo(int intMaximo) {this.intMaximo = intMaximo;}
    //metodo para crear el arreglo de celdas para el simulacro
    public void setCeldas() { celdas = new String[5]; } 
    //metodo para asignar en el arreglo los campos aleatorios para el simulacro
    public void setTarjetaCelda() {
        String retorno = "";
        Random intRandom = new Random();
        int intFila = 0;
        int intColumna = 0;
        for (int i = 0; i < 3; i++) {//filas
            //do {
                intFila = intRandom.nextInt(8);
                intColumna = intRandom.nextInt(8);
                switch(intColumna)
                {
                   case 0 : retorno = "A";break; 
                   case 1 : retorno = "B";break; 
                   case 2 : retorno = "C";break; 
                   case 3 : retorno = "D";break; 
                   case 4 : retorno = "E";break; 
                   case 5 : retorno = "F";break; 
                   case 6 : retorno = "G";break; 
                   case 7 : retorno = "H";break; 
                }                    
                switch(i)
                {
                   case 0 : 
                       celdas[0]=retorno + String.valueOf(intFila+1);
                       celdas[1]= String.valueOf(numerotarjeta[intFila][intColumna]);
                       break; 
                   case 1 : 
                       celdas[2]=retorno + String.valueOf(intFila+1);
                       celdas[3]= String.valueOf(numerotarjeta[intFila][intColumna]);
                       break; 
                   case 2 : 
                       celdas[4]=retorno + String.valueOf(intFila+1);
                       celdas[5]= String.valueOf(numerotarjeta[intFila][intColumna]);
                       break; 
                }
                //Boolean temb =  Arrays.asList(celdas).contains(String.valueOf(numerotarjeta[intFila][intColumna]));
            //} while (Arrays.asList(celdas).contains(String.valueOf(numerotarjeta[intFila][intColumna])));
        }
        retorno = "";
        //} while (Arrays.asList(celdas).contains(yourValue));
        //numerotarjeta[i][j] = intAleatorio;
    }
    //Metodo para retornar valor de la posicion en el arreglo de celdas
    public String getTarjetaCelda(int celda) {return celdas[celda];}
    //metodo para llenar con numeros aleatorios segun el rango
    public void LlenaTarjeta() {
        Random intRandom = new Random();
        int intAleatorio = 0;
        int i; //filas
        int j; //columnas
        for (i = 0; i < numerotarjeta.length; i++) {//filas
            for (j = 0; j < numerotarjeta[i].length; j++) {//columnas
                //asignacion de numero aleatorio 
                //java.util.Random.nextInt(int n) : 
                //The nextInt(int n) is used to get a random number 
                //between 0(inclusive) and 
                //the number passed in this argument(n), exclusive.                    
                do {
                    intAleatorio = intRandom.nextInt(intMaximo+1);
                } while (intAleatorio < getIntMinimo() || intAleatorio > getIntMaximo());
                numerotarjeta[i][j] = intAleatorio;
            }
        }
    }
}