package com.example.miniproject

class Data {

    companion object GetData {
        fun orderedItemData(): ArrayList<Item> {
            val orderedItemList: ArrayList<Item> = ArrayList()
            for (i in 1..5) {
                orderedItemList.add(Item(R.drawable.image, "Pen", "₹20"))
            }
            for (i in 1..5) {
                orderedItemList.add(Item(R.drawable.imag2, "Books", "₹120"))
            }
            return orderedItemList
        }

    }

}