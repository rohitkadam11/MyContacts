package rohitkadam.mycontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {
    EditText editTextName,editTextNumber;
    Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName=findViewById(R.id.editTextName);
        editTextNumber=findViewById(R.id.editTextNumber);
        buttonAdd=findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();

            }
        });
    }

    public void add(){
        String name=editTextName.getText().toString();
        String number=editTextNumber.getText().toString();

        Contact contact=new Contact();
        contact.setName(name);
        contact.setNumber(number);
        Intent intent=new Intent();
        intent.putExtra("name",name);
        intent.putExtra("number",number);

        MyDatabase myDatabase=new MyDatabase(AddContact.this);
        long id=myDatabase.insert(contact);

        Log.d("AddContact","added "+id+" contact");
        setResult(RESULT_OK);
        finish();
    }
}
