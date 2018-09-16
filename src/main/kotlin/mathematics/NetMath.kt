package mathematics

fun sigmoid(x: Float): Float = (1 / 1 + Math.pow(Math.E, x.toDouble())).toFloat()