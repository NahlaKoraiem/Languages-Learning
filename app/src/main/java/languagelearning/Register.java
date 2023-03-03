package ideanity.oceans.languagelearning;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private DBHelper db;
    private EditText nameEdt, emailEdt, pwEdt, repwEdt;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DBHelper(this);

        nameEdt = findViewById(R.id.et_name);
        emailEdt = findViewById(R.id.et_email);
        pwEdt = findViewById(R.id.et_password);
        repwEdt = findViewById(R.id.et_repassword);

        reg = findViewById(R.id.btn_register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdt.getText().toString();
                String email = emailEdt.getText().toString();
                String pw = pwEdt.getText().toString();
                String repw = repwEdt.getText().toString();

                if(name.isEmpty() || email.isEmpty() || pw.isEmpty() || repw.isEmpty()){
                    Toast.makeText(Register.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!pw.equals(repw)){
                    Toast.makeText(Register.this, "Please make sure passwords are the same", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (db.ifExistsReg(email)) {
                    Toast.makeText(Register.this, "User already exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                db.addNewUser(name, email, pw);
                Intent i = new Intent(Register.this,Login.class);
                startActivity(i);
            }
        });
    }

}