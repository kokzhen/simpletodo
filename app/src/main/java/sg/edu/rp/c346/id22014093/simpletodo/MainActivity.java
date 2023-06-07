package sg.edu.rp.c346.id22014093.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTodo;
    Button btnAdd;
    Button btnClear;
    ListView lvTodo;

    ArrayList<String> alTodo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTodo = findViewById(R.id.editTextText);
        btnAdd = findViewById(R.id.button);
        btnClear = findViewById(R.id.button2);
        lvTodo = findViewById(R.id.listView);
        ArrayAdapter aAdapterTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTodo);
        lvTodo.setAdapter(aAdapterTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editTextTodo.getText().toString();
                alTodo.add(newTask);
                editTextTodo.setText("");
                aAdapterTask.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                aAdapterTask.notifyDataSetChanged();
            }
        });
    }

}