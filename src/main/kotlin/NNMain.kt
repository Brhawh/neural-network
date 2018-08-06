/**
 * Created by Benn on 05/07/2018.
 */
fun main(args: Array<String>) {
    val nn = NeuralNetwork(3, 3, 3, 0.5)
    nn.printValues()

    val matrix = Matrix(4, 2, arrayOf(
            arrayOf(1f, 6f),
            arrayOf(1f, 3f),
            arrayOf(1f, 3f),
            arrayOf(1f, 3f) ))
    val matrix2 = Matrix(2, 2, arrayOf(
            arrayOf(2f, 4f),
            arrayOf(3f, 2f) ))

    val product = matrix.dotProduct(matrix2)
    product.printValues()

}