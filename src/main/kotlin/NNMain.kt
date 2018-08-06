/**
 * Created by Benn on 05/07/2018.
 */
fun main(args: Array<String>) {
    val nn = NeuralNetwork(3, 3, 3, 0.5)
    nn.printValues()

    val matrix = Matrix(1, 3, arrayOf( arrayOf(1f, 3f) ))

}