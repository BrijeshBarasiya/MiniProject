package Dashboard

data class ItemDetails (
    val itemID: Int? = null,
    val itemName: String? = null,
    val itemPrice: Int? = null,
    val itemQty: Int? = null,
    val itemTotal: Float? = null
)

data class OrderDetails (
    val orderID: Int? = null,
    val orderDate: String? = null,
    val orderStatus: String? = null,
    val orderTotal: Float? = null,
    val orderItems: List<ItemDetails>? = null
)

data class UserDetails(
    val userID: Int? = null,
    val userName: String? = null,
    val userEmail: String? = null,
    val userPassword: String? = null,
    val userOrders: ArrayList<OrderDetails>? = null
)