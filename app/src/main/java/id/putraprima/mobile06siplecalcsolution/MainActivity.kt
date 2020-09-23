package id.putraprima.mobile06siplecalcsolution

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.putraprima.mobile06siplecalcsolution.Calculation.add
import id.putraprima.mobile06siplecalcsolution.Calculation.divide
import id.putraprima.mobile06siplecalcsolution.Calculation.min
import id.putraprima.mobile06siplecalcsolution.Calculation.multiply
import id.putraprima.mobile06siplecalcsolution.Calculation.zeroInput

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
            if (zeroInput(num1, num2))
                resultTxt.text = "%.2f".format(divide(num1, num2))
            else
                resultTxt.text = "Can't Divide By Zero"
        }
    }

    //TODO 03 Gunakanlah Log Cat Untuk memperbaiki kesalahan program

    //TODO 04 Gunakanlah Debugger untuk mencari kesalahan program (program berjalan dengan baik namun hasilnya salah)

    fun getAngkaMasukkan() {
        val n1: String = number1Edt.text.toString()
        val n2: String = number2Edt.text.toString()
        //TODO 05 Buatlah Validasi input agar masukan yang di isi oleh user tidak membuat program Force Close
        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(applicationContext, "Perhatikan Input, kosong", Toast.LENGTH_SHORT).show()
        } else if((n1 == "-" || n2 == "-") || (n1 == "+" || n2 == "+")){
            Toast.makeText(applicationContext, "Perhatikan Input, angka tidak ada", Toast.LENGTH_SHORT).show()
        } else {
            //TODO 01 Buatlah kode program untuk mengambil nilai input dari edit text
            num1 = n1.toInt()
            num2 = n2.toInt()
        }
    }
}