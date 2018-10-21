package com.example.ubnt.fragviewapp

class Item(Name: String, Image: Int) {

    var name: String
        internal set
    var image: Int = 0
        internal set

    init {
        this.image = Image
        this.name = Name
    }

    override fun toString(): String {
        return name
    }

    override fun equals(obj: Any?): Boolean {
        return name == obj!!.toString()
    }
}