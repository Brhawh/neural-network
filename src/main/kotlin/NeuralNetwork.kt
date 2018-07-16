/**
 * Created by Benn on 05/07/2018.
 * Main neural net object.
 */
class NeuralNetwork(private val numInputNodes: Int,
                    private val numHiddenNodes: Int,
                    private val numOutputNodes: Int,
                    val learningRate: Double) {

    private val randomFloat = { index: Int -> (-1 + Math.random() * (2)).toFloat()}

    var weightsFromInputToHidden: Array<Array<Float>> = Array(numHiddenNodes) { Array(numInputNodes, randomFloat) }
    var weightsFromHiddenToOutput: Array<Array<Float>> = Array(numOutputNodes) { Array(numHiddenNodes, randomFloat) }

    fun printValues() {
        for(i in 0 until numHiddenNodes) {
            for (j in 0 until numInputNodes) {
                println("$i, $j: ${weightsFromInputToHidden[i][j]}")
            }
        }
    }

    fun train() {

    }

    fun query() {

    }
}