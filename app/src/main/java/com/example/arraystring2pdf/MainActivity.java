package com.example.arraystring2pdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String rootPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);  // to disable NIGHT MODE
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Arraylist
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("This is line 1 of the PDF file.");
        stringArrayList.add("This is line 2 of the PDF file.");
        stringArrayList.add("This is line 3 of the PDF file.");

        // File Path to save PDF file
        rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download";

        // You can also create no. of file by generating unique name everytime or go with Custom Name
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPDF(stringArrayList, rootPath+"/file.pdf");

            }
        });


    }

    // Function to create PDF
    private void createPDF(ArrayList<String> stringArrayList, String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            for (String string : stringArrayList) {
                document.add(new Paragraph(string));
            }
            document.close();
            Toast.makeText(this, "PDF Created at "+ rootPath, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}