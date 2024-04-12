package `in`.bitcode.roomdemo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getProducts() : List<Product>

    @Insert
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)

    @Update
    fun update(product: Product)

    @Query("delete from products where id = :id")
    fun deleteById(id : Int) : Int
}

