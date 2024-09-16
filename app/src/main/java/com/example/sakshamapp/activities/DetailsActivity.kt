package com.example.sakshamapp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sakshamapp.R
import com.example.sakshamapp.dataclasses.DashboardItem

class DetailsActivity : AppCompatActivity() {
    private lateinit var property1TextView: TextView
    private lateinit var property2TextView: TextView
    private lateinit var descriptionTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        property1TextView = findViewById(R.id.property1)
        property2TextView = findViewById(R.id.property2)
        descriptionTextView = findViewById(R.id.description)

        val item: DashboardItem = intent.getSerializableExtra("ITEM") as DashboardItem?: return

        property1TextView.text = item.property1
        property2TextView.text = item.property2
        descriptionTextView.text = item.description
    }
}