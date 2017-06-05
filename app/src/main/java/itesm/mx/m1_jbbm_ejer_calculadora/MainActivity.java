package itesm.mx.m1_jbbm_ejer_calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etOperando1, etOperando2;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnLimpiar;
    ImageButton btnInfo;
    TextView tvResultado;

    Intent intent;

    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;
        etOperando1 = (EditText)findViewById(R.id.edit_Operando1);
        etOperando2 = (EditText)findViewById(R.id.edit_Operando2);

        btnSumar = (Button)findViewById(R.id.button_sumar);
        btnRestar = (Button)findViewById(R.id.button_restar);
        btnMultiplicar = (Button)findViewById(R.id.button_multiplicar);
        btnDividir = (Button)findViewById(R.id.button_dividir);
        btnLimpiar = (Button)findViewById(R.id.button_limpiar);
        btnInfo = (ImageButton)findViewById(R.id.image_info);
        tvResultado = (TextView)findViewById(R.id.text_resultado);

        btnLimpiar.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnInfo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_sumar:
                tvResultado.setText(suma() + "");
                contador++;
                break;
            case  R.id.button_restar:
                tvResultado.setText(resta() + "");
                contador++;
                break;
            case R.id.button_multiplicar:
                tvResultado.setText(multiplicacion() + "");
                contador++;
                break;
            case R.id.button_dividir:
                Integer dato = divisiion();
                tvResultado.setText((dato == null) ? "ERROR" : dato.toString());
                contador++;
                break;
            case R.id.button_limpiar:
                etOperando2.setText("");
                etOperando1.setText("");
                tvResultado.setText("");
                break;
            case R.id.image_info:
                showInfo();
                break;
        }
    }

    private int getNumber(EditText et){
        int result;

        try{
            String dato = et.getText().toString();
            result = (dato.isEmpty()) ? 0 : Integer.parseInt(dato);
        }catch (Exception e){
            result = 0;
        }
        return  result;
    }

    private int suma(){
        return  getNumber(etOperando1) + getNumber(etOperando2);
    }

    private int resta(){
        return  getNumber(etOperando1) - getNumber(etOperando2);
    }

    private int multiplicacion(){
        return  getNumber(etOperando1) * getNumber(etOperando2);
    }

    private Integer divisiion(){
        int denominador = getNumber(etOperando2);
        return  (denominador == 0) ? null : getNumber(etOperando1) / denominador;
    }

    private void showInfo(){
        intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra("contador", contador  + "");
        startActivity(intent);
    }

}
