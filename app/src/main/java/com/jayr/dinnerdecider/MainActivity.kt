package com.jayr.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //Declaring the Collection
    var drinksCollection = arrayListOf("Water", "Processed Juice", "Pure FruitJuice", "Vegetable Juice", "Soda", "Chicken Soup", "Dawa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        New Drink to List Button
        - Declare & find its ID
        - Declare Edit text widget
        - Add Item to List upon Click
        - Print out new List Details
        - Clear Text Input Field once Successfully Added to the list
         */
        var addDrinkButton = findViewById<Button>(R.id.addDrinkButton)
        var addDrinkEditText = findViewById<EditText>(R.id.editTextDrinkName)
        addDrinkButton.setOnClickListener {
            var newDrink = addDrinkEditText.text.toString()
            drinksCollection.add(newDrink)
            println(" Drink Collection :$drinksCollection")
            addDrinkEditText.text.clear()
            Toast.makeText(applicationContext , "$newDrink Added to list", Toast.LENGTH_SHORT).show()
        }

            /*
        Decide new Selection
        - Randomly Select new Drink
        - Display Selected new Drink on the UI - textview Widget
        - Clear Text Input Field once Successfully Added to the list
         */
            var bestChoiceText = findViewById<TextView>(R.id.bestChoiceDrink)
            bestChoiceText.text = drinksCollection[0]
            var decideDrinkButton = findViewById<Button>(R.id.decideButton)
            decideDrinkButton.setOnClickListener {
                var newRandomPosition = Random.nextInt(drinksCollection.size)
                bestChoiceText.text = drinksCollection[newRandomPosition]
            }

        }
    }