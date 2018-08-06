class Matrix(val numOfRows: Int, val numOfCols: Int, val rowsOfValues: Array<Array<Float>>) {

    init {
        if (rowsOfValues.size != numOfRows) {
            throw InstantiationException("The number of rows specified doesn't match the number of rows supplied. numOfRows: $numOfRows, number of supplied rows: ${rowsOfValues.size}")
        }
        rowsOfValues.forEach {
            if (it.size != numOfCols) {
                throw InstantiationException("The number of columns specified doesn't match the number of columns supplied. numOfCols: $numOfCols, number of supplied columns: ${it.size}")
            }
        }
    }

    fun printValues() {
        rowsOfValues.forEach {
            it.forEach { print("$it  ") }
            println()
        }
    }
}

fun dotProduct(first: Matrix, second: Matrix ): Matrix {
    if (first.numOfCols != second.numOfRows) {
        throw ArithmeticException("The number of cols in $first does not equal the number of rows in $second, therefor the dot product can't be calculated.")
    }

    val results: MutableList<Array<Float>> = mutableListOf()
    for (rowNum in 0 until first.numOfRows) {
        val rowToAdd = mutableListOf<Float>()
        for (colNum in 0 until second.numOfCols) {
            rowToAdd.add(colNum, dotProductAtIndex(rowNum, colNum, first, second))
        }
        results.add(rowNum, rowToAdd.toTypedArray())
    }

    return Matrix(first.numOfRows, second.numOfCols, results.toTypedArray())
}

private fun dotProductAtIndex(row: Int, col: Int, first: Matrix, second: Matrix): Float {
    val rowFromMatrix = first.rowsOfValues[row]
    val colFromMultiple = FloatArray(second.numOfRows) {0f}
    for (values in 0 until second.numOfRows) {
        colFromMultiple[values] = second.rowsOfValues[values][col]
    }

    var result = 0f

    for (value in 0 until rowFromMatrix.size) {
        result += rowFromMatrix[value] * colFromMultiple[value]
    }

    return result
}