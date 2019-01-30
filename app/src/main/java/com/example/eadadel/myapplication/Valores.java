package com.example.eadadel.myapplication;

public class Valores {

    public static final int EXITO = 1;
    public static final int PISTA = 0;
    public static final int FRACASO = -1;
    public static final int DIENTE = -3;
    public static final int HERIDA = -2;
    public static final int CONGELACION = -1;

    public static int obtenerEFP(int resultadoNumerico){

        switch (resultadoNumerico) {
            case 1:
            case 4:
            case 7:
                return FRACASO;
            case 2:
            case 5:
            case 8:
                return EXITO;
            case 3:
            case 6:
                return PISTA;
        }
        return -100;
    }

 public static int obtenerDCHF(int resultadoNumerico){
        switch (resultadoNumerico){
         case 1://DIENTE
             return DIENTE;
         case 4: //CONGELACION
         case 8: //CONGELACION
             return CONGELACION;
         case 6: //HERIDA
         case 10: //HERIDA
             return HERIDA;
         case 2: //FRACASO
         case 3: //FRACASO
         case 5: //FRACASO
         case 7: //FRACASO
         case 9: //FRACASO
         case 11: //FRACASO
         case 12: //FRACASO
             return FRACASO;
     }
     return -100;
 }
}

