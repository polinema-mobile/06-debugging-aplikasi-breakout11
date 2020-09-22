package id.putraprima.mobile06siplecalcsolution

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var multiplyBtn: Button
    private lateinit var plusBtn: Button
    private lateinit var minusBtn: Button
    private lateinit var divideBtn: Button
    private lateinit var resultTxt: TextView
    private lateinit var number1Edt: EditText
    private lateinit var number2Edt: EditText
    private var num1 = 0
    private var num2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        multiplyBtn = findViewById(R.id.button_kali)
        divideBtn = findViewById(R.id.button_bagi)
        minusBtn = findViewById(R.id.button_kurang)
        plusBtn = findViewById(R.id.button_tambah)
        resultTxt = findViewById(R.id.text_hasil)
        number2Edt = findViewById(R.id.edit_text_angka_kedua)
        number1Edt = findViewById(R.id.edit_text_angka_pertama)

        plusBtn.setOnClickListener {
            getAngkaMasukkan()
            resultTxt.text = "%d".format(add(num1, num2))
        }

        minusBtn.setOnClickListener {
            getAngkaMasukkan()
            resultTxt.text = "%d".format(min(num1, num2))
        }

        //TODO 02 Buatlah kode program untuk menambahkan event klik dari tombol kali dan tombol bagi
        multiplyBtn.setOnClickListener {
            getAngkaMasukkan()
            resultTxt.text = "%d".format(multiply(num1, num2))
        }

        divideBtn.setOnClickListener {
            getAngkaMasukkan()
            val tmp: Float? = divide(num1, num2)
            val result: String = if (tmp?.isNaN()!! || tmp.isInfinite()) {
                "tidak bisa dibagi 0"
            } else {
                tmp.toString()
            }
            resultTxt.text = result
        }
    }

    //TODO 03 Gunakanlah Log Cat Untuk memperbaiki kesalahan program

    //TODO 04 Gunakanlah Debugger untuk mencari kesalahan program (program berjalan dengan baik namun hasilnya salah)

    fun getAngkaMasukkan() {
        //TODO 05 Buatlah Validasi input agar masukan yang di isi oleh user tidak membuat program Force Close
        if (number1Edt.text.toString().isEmpty() || number2Edt.text.toString().isEmpty()) {
            Toast.makeText(applicationContext, "Input harus diisi", Toast.LENGTH_SHORT).show()
        } else {
            //TODO 01 Buatlah kode program untuk mengambil nilai input dari edit text
            num1 = number1Edt.text.toString().toInt()
            num2 = number2Edt.text.toString().toInt()
        }
    }

    // Function
    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun min(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    fun divide(num1: Int, num2: Int): Float {
        return num1.toFloat() / num2.toFloat()
    }

    fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}