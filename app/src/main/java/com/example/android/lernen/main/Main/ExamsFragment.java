package com.example.android.lernen.main.Main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.lernen.R;

/**
 * Created by alfredchang on 2017-02-20.
 */

public class ExamsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exams, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDialog();
            }
        });

        return rootView;
    }

    public void startDialog() {
        // Array to store each TextView that will be filled with exams
        final TextView[] exams = new TextView[4];

        final Dialog examDialog = new Dialog(getActivity());
        examDialog.setContentView(R.layout.fragment_create_exam);

        // CreateExamFragment stuff
        // Variables made final due to access in inner class
        final EditText examName = (EditText) examDialog.findViewById(R.id.exam_name);
        final EditText examTime = (EditText) examDialog.findViewById(R.id.exam_time);
        final EditText examLocation = (EditText) examDialog.findViewById(R.id.exam_location);
        final Button addExamButton = (Button) examDialog.findViewById(R.id.add_exam_button);

        // ExamFragment stuff
        TextView firstExam = (TextView) getActivity().findViewById(R.id.firstExam);
        TextView secondExam = (TextView) getActivity().findViewById(R.id.secondExam);
        TextView thirdExam = (TextView) getActivity().findViewById(R.id.thirdExam);
        TextView fourthExam = (TextView) getActivity().findViewById(R.id.fourthExam);

        // Populate TextViews manually
        exams[0] = firstExam;
        exams[1] = secondExam;
        exams[2] = thirdExam;
        exams[3] = fourthExam;

        addExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (examName != null && examTime != null && examLocation != null) {
                    // Insert exam into TextView
                    for (int i = 0; i < exams.length; i++) {
                        if (exams[i] == null || exams[i].getText().equals("")) {
                            exams[i].setText(examName.getText().toString() + "\n" + examTime.getText().toString()
                                    + "\n" + examLocation.getText().toString());
                            break;
                        }
                        if (i >= 5) {
                            Toast.makeText(getActivity(), "You are only allowed at max 6 exams!", Toast.LENGTH_LONG).show();
                        }
                        examDialog.dismiss();
                    }
                }
            }
        });

        examDialog.show();
    }
}
