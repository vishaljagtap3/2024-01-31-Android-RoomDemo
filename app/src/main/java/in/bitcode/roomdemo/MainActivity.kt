package `in`.bitcode.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productsDatabase = Room.databaseBuilder(
            this,
            ProductsDatabase::class.java,
            "db_products"
        ).allowMainThreadQueries()
            .build()


        val productDao = productsDatabase.getProductDao()

        /*productDao.insert(
            Product(101, "Demo 01", 1001)
        )
        productDao.insert(
            Product(102, "Demo 02", 1002)
        )*/

        var products = productDao.getProducts()
        for (product in products) {
            mt(product.toString())
        }

        mt("----------------------")

        productDao.update(
            Product(
                102,
                "New Title",
                8989
            )
        )
        products = productDao.getProducts()
        for (product in products) {
            mt(product.toString())
        }

        mt("----------------------")

        productDao.delete(
            Product(
                102,
                "New Title",
                8989
            )
        )
        products = productDao.getProducts()
        for (product in products) {
            mt(product.toString())
        }

    }

    private fun mt(text: String) {
        Log.e("tag", text)
    }
}