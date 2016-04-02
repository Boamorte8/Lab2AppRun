package lab2apprun.gr11.compumovil.udea.edu.co.lab2apprun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textUsuario;
    EditText textContraseña;

    DataBaseManager manager = new DataBaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textUsuario = (EditText) findViewById(R.id.UsuarioText);
        textContraseña = (EditText) findViewById(R.id.PasswordText);

        manager.insertarCorredor("Esteban Salazar", "estebans", "esteban");
        manager.insertarCorredor("Catalina Osorno", "cataosorno", "catalina");
        manager.insertarCorredor("Francy Ramirez", "francyr", "francy");
        manager.insertarCorredor("Jesus Arroyave", "jesusa", "jesus");

    }

    public void Loguear(View v){

        String user = String.valueOf(textUsuario.getText());
        String pass = String.valueOf(textContraseña.getText());

        if (manager.loguearUsuario(user, pass)) {
            Intent ingresar = new Intent(this, EventosActivity.class);
            startActivity(ingresar);
        } else {
            Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
        }

    }

    public void IrARegistro(View v){
        Intent irRegistro = new Intent(this, RegistroActivity.class);
        startActivity(irRegistro);
    }
}
