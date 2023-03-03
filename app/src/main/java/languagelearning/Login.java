package ideanity.oceans.languagelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private DBHelper db;
    private EditText emailEdt, pwEdt;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBHelper(this);

        emailEdt = findViewById(R.id.et_email);
        pwEdt = findViewById(R.id.et_password);

        log = findViewById(R.id.btn_login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdt.getText().toString();
                String pw = pwEdt.getText().toString();
                if (db.ifExistsLog(email, pw)) {
                    Intent i = new Intent(Login.this, MainActivity2.class);
                    String name = db.getName(email);
                    i.putExtra("userauth", name);
                    i.putExtra("email", email);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}