package com.example.eadadel.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdaptadorGrid extends BaseAdapter {

    private Context context;
    private List<Dado> listaDados;

    public AdaptadorGrid(Context context, List<Dado> listaDados) {
        this.context = context;
        this.listaDados = listaDados;
    }

    @Override
    public int getCount() {
        return listaDados.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.dado_grid,null);
        }

        ImageView imageViewDadoGrid = convertView.findViewById(R.id.imageViewDadoGrid);
        //final ImageButton imageButtonResultado = convertView.findViewById(R.id.imageButtonDadoGrid);

        //imageViewDadoGrid.setBackground(listaDados.get(position).getDado().getBackground());
        //imageViewDadoGrid.setBackgroundColor(Color.WHITE);

        //asignarImagen(imageButtonResultado, position);
        asignarImagen(imageViewDadoGrid,position);

        //imageViewDadoGrid.setBackground(context.getDrawable(R.drawable.simbolo_arcano));
        //imageViewDadoGrid.setImageDrawable(context.getDrawable(R.drawable.simbolo_arcano));
        //imageViewDadoGrid.setImageDrawable(listaDados.get(position).getDado().getBackground());
        //int width = listaDados.get(position).getDado().getBackground().getIntrinsicHeight();
        //int height = listaDados.get(position).getDado().getBackground().getIntrinsicWidth();


        imageViewDadoGrid.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        //imageButtonResultado.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);


        //ConstraintLayout.LayoutParams lpcl = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        //lpcl.setMargins(5,5,5,5);
        //imageViewDadoGrid.setLayoutParams(lpcl);

        //LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,100);
        lp.setMargins(5, 5, 5, 5);
        imageViewDadoGrid.setLayoutParams(lp);

        //imageButtonResultado.setLayoutParams(lp);


        final TextView textViewResultadoNumericoGrid = convertView.findViewById(R.id.textViewResultadoNumericoGrid);
        asignarTexto(textViewResultadoNumericoGrid,position);
        //textViewResultadoNumericoGrid.setText(listaDados.get(position).getResultadoNumerico() + "");
        //textViewResultadoNumericoGrid.setLayoutParams(lpcl);
        textViewResultadoNumericoGrid.setLayoutParams(lp);
        textViewResultadoNumericoGrid.setTextColor(Color.WHITE);


//        imageButtonResultado.setOnClickListener(new View.OnClickListener() {
 //           @Override
  //          public void onClick(View v) {
   //             listaDados.get(position).lanzarDado();
    //            asignarImagen(imageButtonResultado,position);
     //           asignarTexto(textViewResultadoNumericoGrid,position);
//
  //          }
  //      });
        return convertView;
    }

    private void asignarTexto(TextView textViewResultadoNumericoGrid, int position) {
        textViewResultadoNumericoGrid.setText(listaDados.get(position).getResultadoNumerico() + "");
    }

    private void asignarImagen(ImageButton imageButtonResultado,int position){
        switch (Valores.obtenerEFP(listaDados.get(position).getResultadoNumerico())) {
            case Valores.EXITO:
                imageButtonResultado.setBackground(context.getDrawable(R.drawable.simbolo_arcano));
                break;
            case Valores.PISTA:
                imageButtonResultado.setBackground(context.getDrawable(R.drawable.pista));
                break;
            case Valores.FRACASO:
                imageButtonResultado.setBackground(context.getDrawable(R.drawable.fracaso));
                break;
            default:
                break;
        }
    }

    private void asignarImagen(ImageView imageViewResultado,int position){
        switch (Valores.obtenerEFP(listaDados.get(position).getResultadoNumerico())) {
            case Valores.EXITO:
                imageViewResultado.setBackground(context.getDrawable(R.drawable.simbolo_arcano));
                break;
            case Valores.PISTA:
                imageViewResultado.setBackground(context.getDrawable(R.drawable.pista));
                break;
            case Valores.FRACASO:
                imageViewResultado.setBackground(context.getDrawable(R.drawable.fracaso));
                break;
            default:
                break;
        }
    }
}
