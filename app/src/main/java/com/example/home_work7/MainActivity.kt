package com.example.home_work7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home_work7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var carAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Список автомобилей
        val cars = listOf(
            Car("Tesla Model S", "https://th.bing.com/th/id/R.b7aa4b44a32094217892a4db1654d3fd?rik=wbtk6tgWLystOA&riu=http%3a%2f%2fs1.paultan.org%2fimage%2f2015%2f04%2fTesla-Model-S-Blue.jpg&ehk=D7RbQJbYrcYhtnoSFnfQcJUPQ2tbba%2f1IZkxlVArIJc%3d&risl=&pid=ImgRaw&r=0", "+996 123 456 789"),
            Car("BMW M3", "https://th.bing.com/th/id/OIP.wU5zyA84dEeU6GofDrYoZwAAAA?w=474&h=266&rs=1&pid=ImgDetMain", "+9876543210"),
            Car("Audi R8", "https://th.bing.com/th/id/OIP.PSnQwKYW14D0eoDxMIHsawHaEK?rs=1&pid=ImgDetMain", "+1122334455")
        )

        // Инициализация адаптера
        carAdapter = CarAdapter(cars)

        // Установка адаптера в RecyclerView
        binding.recyclerViewCars.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = carAdapter
        }
    }
}
