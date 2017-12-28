package br.verifica.com;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by gilsonjuniorpro on 28/12/17.
 */

public class MainActivity extends AppCompatActivity {

    String pacoteApp;
    EditText edPacote;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPacote = findViewById(R.id.edPacote);
        tvResultado = findViewById(R.id.tvResultado);

        Button btVerificar = findViewById(R.id.btVerificar);
        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pacoteApp = edPacote.getText().toString();

                if(pacoteApp.length() > 0 && verificaAppInstalado(pacoteApp))
                    tvResultado.setText("O App está instalado!");
                else
                    tvResultado.setText("O App não está instalado!");
            }
        });
    }

    private boolean verificaAppInstalado(String uri) {
        try {
            PackageManager pm = getPackageManager();
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        }catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
