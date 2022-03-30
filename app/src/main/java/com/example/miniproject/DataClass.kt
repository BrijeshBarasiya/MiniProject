package com.example.miniproject

class ItemModelClass (
    val itemId: String,
    val itemImage: String,
    val itemName: String,
    val itemPrice: String
)

class OrderedItemModelClass(
    val itemName: String,
    val itemPrice: String,
    val itemQty: String,
    val itemTotal: String
)

class OrderHistoryModelClass(
    val orderNumber: String,
    val orderStatus: String,
    val orderTotal: String,
    val items: List<OrderedItemModelClass>
)

val itemDataValues = listOf(
    ItemModelClass("1", "https://bookriot.com/wp-content/uploads/2022/02/stack-of-books-in-a-bookstore-1280x720.png", "Classmate Book", "35"),
    ItemModelClass("2", "https://images.theconversation.com/files/45159/original/rptgtpxd-1396254731.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=754&fit=clip", "Notepads", "60"),
    ItemModelClass("3", "https://static.scientificamerican.com/sciam/cache/file/1DDFE633-2B85-468D-B28D05ADAE7D1AD8_source.jpg?w=590&h=800&D80F3D79-4382-49FA-BE4B4D0C62A5C3ED", "Pencil Sharpener", "15"),
    ItemModelClass("4", "https://img.jakpost.net/c/2019/03/02/2019_03_02_66706_1551461528._large.jpg", "Pencil Case", "5"),
    ItemModelClass("5", "https://media.gq.com/photos/5ad64204c8be07604e8b5f2f/4:3/w_1776,h_1332,c_limit/21-books-GQ-April-2018-041718-3x2.jpg", "Eraser", "3"),
    ItemModelClass("6", "https://static01.nyt.com/images/2021/12/27/books/books-winner-promo/books-winner-promo-superJumbo.jpg", "Stapler", "50"),
    ItemModelClass("7", "https://pyxis.nymag.com/v1/imgs/1cc/b68/6613f73d72328f430c6e55e3de5d3acccf-24-parenting-books-1.rsquare.w700.jpg", "Pencil", "8"),
    ItemModelClass("8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDQv94YNTRzo25C54WNJA-5Y0NbvLEInybHg&usqp=CAU", "Whitener", "20"),
    ItemModelClass("9", "https://blog.hubspot.com/hubfs/books-every-aspiring-ceo-should-read.jpg", "Scissors", "45"),
    ItemModelClass("10", "https://assets.entrepreneur.com/content/3x2/2000/20190102161219-GettyImages-904000456.jpeg", "Ruler", "60"),
    ItemModelClass("11", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfQQWn0kMau0g_NC9XcPp1c6BEkbMfvdl9Sg&usqp=CAU", "Glitter", "78"),
    ItemModelClass("12", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbp1eApgn5f0S6iDV5QkNva6iCc_OWL-3cMg&usqp=CAU", "Document Holder", "25"),
    ItemModelClass("13", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHriVEHXxmU5tUguaVc-Ko2JXhJSAKjCi9ug&usqp=CAU", "Paper Clips", "30"),
    ItemModelClass("14", "https://leverageedu.com/blog/wp-content/uploads/2019/09/Importance-of-Books.jpg", "Tape", "10"),
    ItemModelClass("15", "https://www.thestar.com/content/dam/thestar/entertainment/books/opinion/2021/09/02/35-books-you-need-to-know-about-in-fall-2021/fall_reading_big_pic.jpg", "School Bags", "1500")
)

val orderHistoryValue = listOf(
    OrderHistoryModelClass("Order No.: 1", "Delivered:\n31/03/2022", "12000", listOf(
        OrderedItemModelClass("Pencil", "5", "50", "250"),
        OrderedItemModelClass("Glitter", "5", "50", "250"),
        OrderedItemModelClass("Stapler", "5", "50", "250"),
        OrderedItemModelClass("Notepads", "5", "50", "250"),
        OrderedItemModelClass("Pencil Sharpener", "5", "50", "250"),
        OrderedItemModelClass("Scissors", "5", "50", "250")
    )),

    OrderHistoryModelClass("Order No.: 2", "Pending:\n30/03/2022", "42000", listOf(
        OrderedItemModelClass("School Bags", "500", "100", "50000"),
        OrderedItemModelClass("Tape", "5", "50", "250"),
        OrderedItemModelClass("Paper Clips", "2", "500", "1000"),
        OrderedItemModelClass("Document Holder", "4", "10", "40"),
        OrderedItemModelClass("Scissors", "5", "50", "250")
    )),

    OrderHistoryModelClass("Order No.: 3", "Delivered:\n28/03/2022", "85000", listOf(
        OrderedItemModelClass("Pencil", "5", "50", "250"),
        OrderedItemModelClass("Glitter", "5", "50", "250"),
        OrderedItemModelClass("Stapler", "5", "50", "250"),
        OrderedItemModelClass("Notepads", "5", "50", "250"),
        OrderedItemModelClass("Pencil Sharpener", "5", "50", "250"),
        OrderedItemModelClass("Scissors", "5", "50", "250"),
        OrderedItemModelClass("Pencil", "5", "50", "250"),
        OrderedItemModelClass("Glitter", "5", "50", "250"),
        OrderedItemModelClass("Stapler", "5", "50", "250"),
        OrderedItemModelClass("Notepads", "5", "50", "250"),
        OrderedItemModelClass("Pencil Sharpener", "5", "50", "250"),
        OrderedItemModelClass("Scissors", "5", "50", "250"),
        OrderedItemModelClass("Pencil", "5", "50", "250"),
        OrderedItemModelClass("Glitter", "5", "50", "250"),
        OrderedItemModelClass("Stapler", "5", "50", "250"),
        OrderedItemModelClass("Notepads", "5", "50", "250"),
        OrderedItemModelClass("Pencil Sharpener", "5", "50", "250"),
        OrderedItemModelClass("Scissors", "5", "50", "250")
    )),
)