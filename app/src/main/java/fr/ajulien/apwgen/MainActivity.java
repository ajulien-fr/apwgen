package fr.ajulien.apwgen;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) return;

            FirstFragment fragment = new FirstFragment();

            getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
