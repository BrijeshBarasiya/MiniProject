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

        fun categoryData(): ArrayList<Category> {
            val categoryList: ArrayList<Category> = ArrayList()
            categoryList.add(Category(R.drawable.image, "Art & crafts"))
            categoryList.add(Category(R.drawable.image, "Notebook & Diaries"))
            categoryList.add(Category(R.drawable.image, "Files & Folders"))
            categoryList.add(Category(R.drawable.image, "Fancy Stationary"))
            categoryList.add(Category(R.drawable.image, "Books & Novel"))
            categoryList.add(Category(R.drawable.image, "School Stationary"))
            categoryList.add(Category(R.drawable.image, "Pens"))
            return categoryList
        }
    }

}