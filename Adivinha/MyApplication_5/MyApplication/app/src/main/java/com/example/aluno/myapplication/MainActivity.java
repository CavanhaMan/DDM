package com.example.aluno.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/***********************************/
import java.util.Random;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView mensagem;
    private EditText entrada;
    public TextView contaTentativas;
    int tentativas;
    private int numeroSorteado;
    String msgAlerta;
    Random geraSorteio = new Random();
    String toastMensagem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //preparacaoInicial();
/**************************************************************/
        numeroSorteado = geraSorteio.nextInt(101);
        tentativas = 0;
    }
    /*
    private void preparacaoInicial(){
        mensagem = (TextView) findViewById(R.id.mensagem);
        entrada = (EditText) findViewById(R.id.entrada);
        entrada.setOnKeyListener((View.OnKeyListener) this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_UP){
            verificar();
            return true;
        }
        return false;
    }

    private void verificar(){
        int numero = Integer.parseInt(entrada.getText().toString());
        if(numero==numeroSorteado) {
            mensagem.setText(R.string.texto2);
            numeroSorteado = geraSorteio.nextInt(101);
        }
        else if(numero > numeroSorteado) {
            mensagem.setText(R.string.texto3);
            tentativas++;
        }
        else {
            mensagem.setText(R.string.texto4);
            tentativas++;
        }
        entrada.setText(""); //zera a entrada de números
    }


    /********************************************************************/
    public void tentaAdivinhar (View view) {

        EditText numeroAdivinhado = (EditText) findViewById(R.id.entrada);
        String numeroAdivinhadoString = numeroAdivinhado.getText().toString();
        int numeroAdivinhadoInt=-1;
        mensagem = (TextView) findViewById(R.id.mensagem);
        if (numeroAdivinhadoString.equals("")) {
            toastMensagem = "Insira um número";
            msgAlerta = "Coloque seu palpite abaixo:";
        }
        else {
            numeroAdivinhadoInt = Integer.parseInt(numeroAdivinhadoString);
        }

        //This is where the magic happens
        if (numeroAdivinhadoInt == -1) {
            toastMensagem = "Insira um número";
            msgAlerta = "Coloque seu palpite abaixo:";
        }
        else if (numeroAdivinhadoInt == numeroSorteado) {
            tentativas++;
            toastMensagem = "Parabéns! O número é " + numeroSorteado + ". Você gastou " + tentativas + " tentativas!";
            msgAlerta = "Novo Jogo! Coloque seu palpite abaixo:";

            Random geraSorteio = new Random();
            numeroSorteado = geraSorteio.nextInt(101);
            tentativas = 0;
        } else if (numeroAdivinhadoInt > numeroSorteado) {
            toastMensagem = "É muito. Tente um numero menor.";
            msgAlerta = numeroAdivinhadoInt + " é muito. Tente um numero menor.";
            tentativas++;

        } else {
            toastMensagem = "É pouco. Tente um numero maior.";
            msgAlerta = numeroAdivinhadoInt + " é pouco. Tente um numero maior.";
            tentativas++;

        }

        Toast.makeText(getApplicationContext(), toastMensagem, Toast.LENGTH_LONG).show();
        mensagem.setText(msgAlerta);
        numeroAdivinhado.setText("");
        contaTentativas = (TextView) findViewById(R.id.contaTentativas);
        contaTentativas.setText("Tentativas: " + tentativas);

    }

}
