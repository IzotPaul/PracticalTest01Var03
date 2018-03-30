package practicaltest01var03.eim.systems.cs.pub.ro.practicaltest01var03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private EditText studentName;
    private EditText className;
    private CheckBox studentCheck;
    private CheckBox classCheck;
    private ToggleButton toggleSecond;
    private Button displayButton;
    private TextView displayView;

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String studName = studentName.getText().toString();
            String clsName = className.getText().toString();
            String toDisplay = new String();

            if (studentCheck.isChecked())
                toDisplay += studName;
            toDisplay += ' ';
            if (classCheck.isChecked())
                toDisplay += clsName;

            displayView.setText(toDisplay);

            if (toggleSecond.isChecked()) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivitity.class);
                intent.putExtra("stud", studentName.getText().toString());
                intent.putExtra("class", className.getText().toString());
                startActivityForResult(intent, 1);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if (resultCode == -1)
                Toast.makeText(getApplicationContext(), "Activity returned with result: OK",
                        Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Activity returned with result: CANCEL",
                        Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        studentName = (EditText)findViewById(R.id.editText1);
        className = (EditText)findViewById(R.id.editText2);
        studentCheck = (CheckBox)findViewById(R.id.checkBox1);
        classCheck = (CheckBox)findViewById(R.id.checkBox2);
        displayButton = (Button)findViewById(R.id.button);
        displayButton.setOnClickListener(genericButtonClickListener);
        displayView = (TextView)findViewById(R.id.textView);
        toggleSecond = (ToggleButton)findViewById(R.id.toggleButton);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.STUDENT_EDIT_TEXT, studentName.getText().toString());
        savedInstanceState.putString(Constants.CLASS_EDIT_TEXT, className.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getString(Constants.STUDENT_EDIT_TEXT) != null) {
            studentName.setText(savedInstanceState.getString(Constants.STUDENT_EDIT_TEXT));
        }

        if (savedInstanceState.getString(Constants.CLASS_EDIT_TEXT) != null) {
            className.setText(savedInstanceState.getString(Constants.CLASS_EDIT_TEXT));
        }
    }
}
