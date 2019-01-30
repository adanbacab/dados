package com.example.eadadel.myapplication;



import java.util.Random;

public class Dado {

    //private ImageButton dado;
    //private TextView textViewResultadoNumerico;
    private int resultadoNumerico;
    //private int resultado; //EXITO=1 FRACASO=-1 O PISTA=0. //DIENTE = -2 HERIDA= 1 CONGELACION=2 O FRACASO=-1
    private int caras;
    //private int resultadoDHCF;


//
//    Context context;

//    public final int DOW = 1;
//    public final int MOM = 2;
//
//    private final int EXITO = 1;
//    private final int PISTA = 0;
//    private final int FRACASO = -1;
//
//    private final int DIENTE = -2;
//    //private final int FRACASO = -1;
//    private final int HERIDA = 1;
//    private final int CONGELACION = 2;

    public Dado(int caras) {
        this.caras = caras;
        lanzarDado();
    }

//    public Dado(Context context, int juego) {
//        this.context = context;
//        this.dado = new ImageButton(context);
//        this.textViewResultadoNumerico = new TextView(context);
//        //lanzarDado(juego);
//        //establecerFondoyDigito(juego);
//        //establecerparametrosLayout();
//
//    }

//    public int getResultadoEPF() {
//        return resultado;
//    }

//    public ImageButton getDado() {
//        return dado;
//    }

    public int getResultadoNumerico() {
        return resultadoNumerico;
    }



//    public TextView getTextViewResultadoNumerico() {
//        return textViewResultadoNumerico;
//    }

    public void setResultadoNumerico(int resultadoNumerico) {
        this.resultadoNumerico = resultadoNumerico;
    }

//    public void lanzarDado(int juego) {
//        Random random = new Random();
//        int carasDado = 0;
//        switch (juego){
//            case DOW:
//                carasDado = 8;
//                break;
//            case MOM:
//                carasDado = 12;
//                break;
//        }
//
//        this.resultadoNumerico = random.nextInt(carasDado) + 1;
//        //this.resultado = seleccionarResultado(this.resultadoNumerico,juego);
//        //establecerFondoyDigito(juego);
//
//    }

    public void lanzarDado(){
        Random random = new Random();
        int nuevoResultado = random.nextInt(this.caras) + 1;;
        setResultadoNumerico(nuevoResultado);
    }

//    public int seleccionarResultado(int resultado, int juego) {
//        // FRACASO 1,4,7
//        // EXITO 2,5,8
//
//        // PISTA 3,6
//        if (juego == MOM) {
//            switch (resultado) {
//                case 1:
//                case 4:
//                case 7:
//                    return FRACASO;
//                case 2:
//                case 5:
//                case 8:
//                    return EXITO;
//                case 3:
//                case 6:
//                    return PISTA;
//            }
//        }
//        if (juego == DOW){
//            switch (resultado){
//                case 1://DIENTE
//                return DIENTE;
//                case 4: //CONGELACION
//                case 8: //CONGELACION
//                    return CONGELACION;
//                case 6: //HERIDA
//                case 10: //HERIDA
//                    return HERIDA;
//                case 2: //FRACASO
//                case 3: //FRACASO
//                case 5: //FRACASO
//                case 7: //FRACASO
//                case 9: //FRACASO
//                case 11: //FRACASO
//                case 12: //FRACASO
//                    return FRACASO;
//            }
//        }
//        return 0;
//
//    }

//    public void establecerFondoyDigito(int juego) {
//        this.textViewResultadoNumerico.setText(this.resultadoNumerico + "");
//
//        if (juego == MOM) {
//            switch (this.resultado) {
//                case EXITO:
//                    this.dado.setBackground(context.getDrawable(R.drawable.simbolo_arcano));
//                    return;
//                case PISTA:
//                    this.dado.setBackground(context.getDrawable(R.drawable.pista));
//                    return;
//                case FRACASO:
//                    this.dado.setBackground(context.getDrawable(R.drawable.fracaso));
//                    return;
//                default:
//                    return;
//            }
//        }
//
//        if (juego == DOW){
//            switch (this.resultado){
//                case DIENTE:
//                    this.dado.setBackground(context.getDrawable(R.drawable.diente));
//                    return;
//                case HERIDA:
//                    this.dado.setBackground(context.getDrawable(R.drawable.herida));
//                    return;
//                case CONGELACION:
//                    this.dado.setBackground(context.getDrawable(R.drawable.congelacion));
//                    return;
//                case FRACASO:
//                    this.dado.setBackground(context.getDrawable(R.drawable.fracaso));
//                    return;
//            }
//        }
//    }

//    private void establecerparametrosLayout() {
//        //LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 200);
//        //lp.setMargins(5, 5, 5, 5);
//        //dado.setLayoutParams(lp);
//
//        dado.setClickable(true);
//        dado.setFocusable(true);
//
//        //lp = new LinearLayout.LayoutParams(70, 70);
//        //lp.setMargins(5, 5, 5, 5);
//        //textViewResultadoNumerico.setLayoutParams(lp);
//        textViewResultadoNumerico.setTextColor(Color.WHITE);
//    }


}