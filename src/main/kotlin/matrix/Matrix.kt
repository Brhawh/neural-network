class Matrix(private val numOfRows: Int, private val numOfCols: Int, rowsOfValues: Array<Array<Float>>) {

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

    fun dotProduct(multiple: Matrix) {
        if (numOfRows != multiple.numOfCols) {
            throw ArithmeticException("The number of rows in $this does not equal the number of columns in $multiple, therefor the dot product can't be calculated.")
        }

        for (rowNum in 0..numOfRows) {
            
        }
    }


}