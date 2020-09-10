package kot

private var first: String? = null;
private var second: String? = "null";
private var third: String? = "";

fun main() {
    var result = (first?.length?:0) + (second?.length?:0) + (third?.length?:0);
    println(result)

}
