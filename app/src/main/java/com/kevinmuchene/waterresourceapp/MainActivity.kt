package com.kevinmuchene.waterresourceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var resourceName: EditText;
    private lateinit var resourceLocation: EditText;
    private lateinit var resourceType: EditText;
    private lateinit var addButton: Button;
    private lateinit var tableLayout: TableLayout;

    data class ResourceType(
        val resName: String,
        val resLocation: String,
        val type: String
    );


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         resourceName = findViewById(R.id.resourceName);
         resourceLocation = findViewById(R.id.location)
        resourceType = findViewById(R.id.type);
        addButton = findViewById(R.id.addBtn)
        tableLayout = findViewById(R.id.tableLayout);

        addButton.setOnClickListener {
            getWaterResourceDetails();
        }
    }

    private fun getWaterResourceDetails() {

        val nameText = resourceName.text.toString().trim()
        val locationText = resourceLocation.text.toString().trim()
        val typeText = resourceType.text.toString().trim()


        if (nameText.isEmpty() || locationText.isEmpty() || typeText.isEmpty()) {

            Toast.makeText(this, "All fields are required.", Toast.LENGTH_SHORT).show()
            return
        }


        val resource = ResourceType(nameText, locationText, typeText)


        addResourceToTable(resource)

        resourceName.text.clear()
        resourceLocation.text.clear()
        resourceType.text.clear()
    }


    private fun addResourceToTable(resource: ResourceType) {
        val tableRow = TableRow(this).apply {
            layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        }

        val nameTextView = TextView(this).apply {
            text = resource.resName
        }

        val locationTextView = TextView(this).apply {
            text = resource.resLocation
        }

        val typeTextView = TextView(this).apply {
            text = resource.type
        }


        tableRow.addView(nameTextView)
        tableRow.addView(locationTextView)
        tableRow.addView(typeTextView)
        tableLayout.addView(tableRow)
    }



}