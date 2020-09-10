package kot3.generic1516

interface MyList<T> {

    fun get(index:Int):T
    fun add(element:T)
    fun remove(element:T)
    fun removeAt(index:Int)
    fun size():Int


}