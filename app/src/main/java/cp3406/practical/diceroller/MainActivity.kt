package cp3406.practical.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(R.id.imageView)
            rollDice(R.id.imageView2)
        }

        // Roll dice on app start
        rollDice(R.id.imageView)
        rollDice(R.id.imageView2)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(@IdRes imageViewChoice: Int) {
        // Create new Dice object with x sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(imageViewChoice)
        // Change dice image based on die number
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        // Tell screen readers which number was rolled
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Allow the user to roll a dice and review the result on screen.
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}