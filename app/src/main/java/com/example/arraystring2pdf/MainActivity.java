package com.example.arraystring2pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("This is line 1 of the PDF file.");
        stringArrayList.add("This is line 2 of the PDF file.");
        stringArrayList.add("This is line 3 of the PDF file.");

        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download";

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPDF(stringArrayList, rootPath+"/file.pdf");

            }
        });


    }

    private void createPDF(ArrayList<String> stringArrayList, String filePath) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            for (String string : stringArrayList) {
                document.add(new Paragraph(string));
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}