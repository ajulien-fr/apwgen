package fr.ajulien.apwgen;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        NumberPicker np;

        np = view.findViewById(R.id.numberPicker_number);
        np.setMinValue(1);
        np.setMaxValue(100);

        np = view.findViewById(R.id.numberPicker_length);
        np.setMinValue(1);
        np.setMaxValue(100);

        FloatingActionButton button = view.findViewById(R.id.button_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewButtonClicked();
            }
        });

        return view;
    }

    private void onViewButtonClicked() {
        EditText editText = getView().findViewById(R.id.editText_account);

        String account = editText.getText().toString().trim();

        if (account.isEmpty()) return;

        NumberPicker np;

        np = getView().findViewById(R.id.numberPicker_number);
        int number = np.getValue();

        np = getView().findViewById(R.id.numberPicker_length);
        int length = np.getValue();

        Bundle args = new Bundle();
        args.putString("uri", getArguments().getString("uri"));
        args.putString("account", account);
        args.putInt("number", number);
        args.putInt("length", length);

        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
