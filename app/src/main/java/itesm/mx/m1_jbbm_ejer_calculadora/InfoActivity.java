package itesm.mx.m1_jbbm_ejer_calculadora;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoActivity extends AppCompatActivity {

    TextView tvContador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Establecer fondo de pantalla
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.background), size.x, size.y, true);
        RelativeLayout layout =(RelativeLayout)findViewById(R.id.activity_info);
        layout.setBackground(new BitmapDrawable(bmp));
        //final fondo de pantalla

        tvContador = (TextView)findViewById(R.id.text_contador);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            tvContador.setText("antidad de operaciones: " + bundle.getString("contador"));
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
