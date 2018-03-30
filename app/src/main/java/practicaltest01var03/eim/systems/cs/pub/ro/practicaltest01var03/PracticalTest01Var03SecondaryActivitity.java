package practicaltest01var03.eim.systems.cs.pub.ro.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivitity extends AppCompatActivity {

    private Button okButton;
    private TextView studentName;
    private Button cancelButton;
    private TextView className;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button2:
                    setResult(RESULT_OK, null);
                    finish();
                    break;
                case R.id.button3:
                    setResult(RESULT_CANCELED, null);
                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary_activitity);

        okButton = (Button)findViewById(R.id.button2);
        cancelButton = (Button)findViewById(R.id.button3);
        studentName = findViewById(R.id.textView2);
        className = findViewById(R.id.textView3);


        okButton.setOnClickListener(buttonClickListener);
        cancelButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        String stud = intent.getStringExtra("stud");
        String clss = intent.getStringExtra("class");

        studentName.setText(stud);
        className.setText(clss);
    }
}
