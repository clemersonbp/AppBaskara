package com.example.appbaskara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtValorA,edtValorB,edtValorC;
    private Button btnCalcular,btnLimpar,btnPassarDadosProximaTela;
    private TextView txtResultado;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValorA=(EditText)findViewById(R.id.edtValorA);
        edtValorB=(EditText)findViewById(R.id.edtValorB);
        edtValorC=(EditText)findViewById(R.id.edtValorC);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnLimpar=(Button)findViewById(R.id.btnLimpar);
        btnPassarDadosProximaTela=(Button)findViewById(R.id.btnPassarDadosProximaTela);
        txtResultado=(TextView)findViewById(R.id.txtResultado);
        res=getResources();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b,c,delta,x1,x2;
                x1=0;
                x2=0;
                try
                {
                    a = Float.parseFloat(edtValorA.getText().toString());
                    b = Float.parseFloat(edtValorB.getText().toString());
                    c = Float.parseFloat(edtValorC.getText().toString());
                    delta = (b*b) - (4*a*c);
                    if (delta < 0)
                        txtResultado.setText(String.format(res.getString(R.string.raizes_reais)));
                    else
                    {
                        delta = (float)(Math.sqrt(delta));
                        x1 = (-b + delta) / (2*a);
                        x2 = (-b - delta) / (2*a);
                        txtResultado.setText(String.format(res.getString(R.string.x1)) + " = " + x1 + "\n" +
                                String.format(res.getString(R.string.x2)) + " = " + x2);
                    }
                }catch (Exception e)
                {
                    txtResultado.setText(String.format(res.getString(R.string.erro)));
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtValorA.setText("");
                edtValorB.setText("");
                edtValorC.setText("");
                txtResultado.setText(String.format(res.getString(R.string.resultado)));
            }
        });

        btnPassarDadosProximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviaDados = new Intent(MainActivity.this, Dados.class);
                String dados = String.format(res.getString(R.string.valor_a)) + " " + edtValorA.getText().toString() + "\n" +
                        String.format(res.getString(R.string.valor_b)) + " " + edtValorB.getText().toString() + "\n" +
                        String.format(res.getString(R.string.valor_c)) + " " + edtValorC.getText().toString() + "\n" +
                        txtResultado.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("dados", dados);
                enviaDados.putExtras(bundle);
                startActivity(enviaDados);
            }
        });
    }
}
