package com.demo.kotlin14

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        run {
            val result = run {
                var str: String? = null
                if (str == null) {
                    str = "111"
                }
                str
            }
            Log.d("kotlin1.4", "result: ${result.substring(1)}")
        }

        run {
            val orderItem = OrderItem("", 11.5, 2)
            orderItem.oldField = 1001
            Log.d("kotlin1.4", "newField: ${orderItem.newField}")
            // 输出为1001
        }

        findViewById<View>(R.id.root_view).setOnClickListener {
            Log.d("kotlin1.3", "view的点击")
        }

        doAction {
            Log.d("kotlin1.4", "执行SAM接口事件")
        }

        f(1, b = 2, 3, d = 4)
        f(a = 4, 3, c = 2, 1)
        f(b = 2, c = 2, a = 2, d = 2)

        val order = arrayListOf(
            OrderItem("蛋糕", 15.5, 2),
            OrderItem("面包", 12.5, 4),
            OrderItem("酸奶", 8.5, 5),
        )
        val sum = order.sumOf {
            it.price * it.count
        }
        Log.d("kotlin1.4", "sum: $sum")
        // 输出每个商品的总价之和

        val minPrice = order.minOfOrNull {
            it.price
        }
        val maxCount = order.maxOfOrNull {
            it.count
        }
        Log.d("kotlin1.4", "minPrice: $minPrice, maxCount: $maxCount")
        // 输出集合里最低的价格和最大的数量

        val minPriceOrder = order.minByOrNull {
            it.price
        }
        val maxCountOrder = order.maxByOrNull {
            it.count
        }
        Log.d("kotlin1.4", "minPriceOrder: ${minPriceOrder?.name}, maxCountOrder: ${maxCountOrder?.name}")
        // 输出集合里价格最低的商品名和数量最大的商品名

    }

    private fun doAction(action: Action) = action.onClick()

    private fun f(a: Int, b: Int, c: Int, d: Int) {
        Log.d("kotlin1.4", "a: $a, b: $b, c: $c, d: $d")
    }

    private fun g(
        a: Int,
        b: Int,
        c: Int,
        d: Int,
    ) {
        Log.d("kotlin1.4", "a: $a, b: $b, c: $c, d: $d")
    }
}

class OrderItem(var name: String?, var price: Double, var count: Int) {
    var newField = 0

    @Deprecated("Use 'newField' instead", ReplaceWith("newField"))
    var oldField by this::newField
}

fun interface Action {
    fun onClick()
}
