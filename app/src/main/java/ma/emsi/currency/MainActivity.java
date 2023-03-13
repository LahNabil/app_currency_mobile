package ma.emsi.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText amount;
    Spinner from;
    Spinner to;
    Button convert;
    TextView res;
    ArrayAdapter<String> nodel;
    String[] currencies={"MAD","USD","EUR"};
    double[][] exchange={
        {1,0.096,0.09},
        {10.41,1,0.93},
        {11.15,1.07,1}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nodel=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,currencies);
        amount=findViewById(R.id.amount);
        from=findViewById(R.id.from);
        to=findViewById(R.id.to);
        convert=findViewById(R.id.btn);
        res=findViewById(R.id.res);
        from.setAdapter(nodel);
        to.setAdapter(nodel);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rslt = Integer.parseInt(amount.getText().toString());
                int f = Integer.parseInt(from.getSelectedItemId()+"");
                int t = Integer.parseInt(to.getSelectedItemId()+"");
                double cal = rslt*exchange[f][t];
                res.setText(cal+"");

            }
        });

    }
}