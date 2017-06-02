package io.imagineer.imagineertalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private EditText mMsgText;
    private Button mSendButton;

    private DatabaseReference mFirebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mListView = (ListView) findViewById(R.id.listView);
        mMsgText = (EditText) findViewById(R.id.msgText);
        mSendButton = (Button) findViewById(R.id.sendButton);

        String[] samples = {
                "test1",
                "test2",
                "test3",
        };

        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, samples));

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message("Marco", mMsgText.getText().toString());
                mFirebaseDatabaseReference.child("messages").push().setValue(message);
                mMsgText.setText("");
            }
        });
    }
}
