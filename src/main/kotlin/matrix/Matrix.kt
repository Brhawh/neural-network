class Matrix(private val numOfRows: Int, private val numOfCols: Int, private val rowsOfValues: Array<Array<Float>>) {

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

    fun dotProduct(multiple: Matrix): Matrix {
        if (numOfCols != multiple.numOfRows) {
            throw ArithmeticException("The number of cols in $this does not equal the number of rows in $multiple, therefor the dot product can't be calculated.")
        }

        val results: MutableList<Array<Float>> = mutableListOf()
        for (rowNum in 0 until numOfRows) {
            val rowToAdd = mutableListOf<Float>()
            for (colNum in 0 until multiple.numOfCols) {
                rowToAdd.add(colNum, dotProductAtIndex(rowNum, colNum, multiple))
            }
            results.add(rowNum, rowToAdd.toTypedArray())
        }

        return Matrix(numOfRows, multiple.numOfCols, results.toTypedArray())
    }

    private fun dotProductAtIndex(row: Int, col: Int, multiple: Matrix): Float {
        val rowFromMatrix = rowsOfValues[row]
        val colFromMultiple = FloatArray(multiple.numOfRows) {0f}
        for (values in 0 until multiple.numOfRows) {
            colFromMultiple[values] = multiple.rowsOfValues[values][col]
        }

        var result = 0f

        for (value in 0 until rowFromMatrix.size) {
            result += rowFromMatrix[value] * colFromMultiple[value]
        }

        return result
    }

    fun printValues() {
        rowsOfValues.forEach {
            it.forEach { print("$it  ") }
            println()
        }
    }


}