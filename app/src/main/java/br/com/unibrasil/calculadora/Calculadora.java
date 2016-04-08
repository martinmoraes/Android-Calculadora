package br.com.unibrasil.calculadora;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


/*
Calculadora implementada para fins didáticos no desenvolvimento Android.
Não realiza as operações na forma esperada, como percebido nas demais calculadoras.
As operações caracem de implementação lógica de usabilidade e resultados.

prof. Martin Morães

 */


public class Calculadora extends AppCompatActivity implements View.OnClickListener {
    TextView tvValores;
    ImageButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btAdicao, btSubtracao, btMultiplicacao, btDivisao, btPonto;
    double vlr1, vlr2, resultado = 0;
    char operacao = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        tvValores = (TextView) findViewById(R.id.tvValores);
        bt1 = (ImageButton) findViewById(R.id.btUm);
        bt2 = (ImageButton) findViewById(R.id.btDois);
        bt3 = (ImageButton) findViewById(R.id.btTres);
        bt4 = (ImageButton) findViewById(R.id.btQuatro);
        bt5 = (ImageButton) findViewById(R.id.btCinco);
        bt6 = (ImageButton) findViewById(R.id.btSeis);
        bt7 = (ImageButton) findViewById(R.id.btSete);
        bt8 = (ImageButton) findViewById(R.id.btOito);
        bt9 = (ImageButton) findViewById(R.id.btNove);
        bt0 = (ImageButton) findViewById(R.id.btZero);
        btAdicao = (ImageButton) findViewById(R.id.btAdicao);
        btSubtracao = (ImageButton) findViewById(R.id.btSubtracao);
        btMultiplicacao = (ImageButton) findViewById(R.id.btMultiplicacao);
        btDivisao = (ImageButton) findViewById(R.id.btDivisao);
        btPonto = (ImageButton) findViewById(R.id.btPonto);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);
        btAdicao.setOnClickListener(this);
        btSubtracao.setOnClickListener(this);
        btMultiplicacao.setOnClickListener(this);
        btDivisao.setOnClickListener(this);
        btPonto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int view = v.getId();

        switch (view) {
            case R.id.btUm:
                addNumero('1');
                break;
            case R.id.btDois:
                addNumero('2');
                break;
            case R.id.btTres:
                addNumero('3');
                break;
            case R.id.btQuatro:
                addNumero('4');
                break;
            case R.id.btCinco:
                addNumero('5');
                break;
            case R.id.btSeis:
                addNumero('6');
                break;
            case R.id.btSete:
                addNumero('7');
                break;
            case R.id.btOito:
                addNumero('8');
                break;
            case R.id.btNove:
                addNumero('9');
                break;
            case R.id.btZero:
                addNumero('0');
                break;
            case R.id.btPonto:
                addNumero('.');
                break;
            case R.id.btAdicao:
                calcula('+');
                break;
            case R.id.btSubtracao:
                calcula('-');
                break;
            case R.id.btMultiplicacao:
                calcula('*');
                break;
            case R.id.btDivisao:
                calcula('/');
                break;
        }
    }

    public void addNumero(char c) {
        String vlr = tvValores.getText().toString();
        vlr = vlr + c;
        tvValores.setText(vlr);
    }


    public void calcula(char op) {
        operacao = op;

        if (vlr1 == 0) {
            vlr1 = Double.parseDouble(tvValores.getText().toString());
            tvValores.setText("");
        } else {
            vlr2 = Double.parseDouble(tvValores.getText().toString());

            switch (operacao) {
                case '+':
                    resultado = vlr1 + vlr2;
                    break;
                case '-':
                    resultado = vlr1 - vlr2;
                    break;
                case '*':
                    resultado = vlr1 * vlr2;
                    break;
                case '/':
                    resultado = vlr1 / vlr2;
                    break;
            }

            tvValores.setText(String.valueOf(resultado));
            vlr1 = resultado;
        }
    }


    public void Limpa(View v) {
        resultado = 0;
        vlr1 = 0;
        vlr2 = 0;
        tvValores.setText("");
        operacao = ' ';
    }
}

