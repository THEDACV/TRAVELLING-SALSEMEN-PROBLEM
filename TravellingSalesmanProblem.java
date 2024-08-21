public class TravellingSalesmanProblem {
    private static int numberOfNodes = 4;
    private static int[][] adjacencyMatrix = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
    };
    private static int[] tour;
    private static int tourCost = 0;

    public static void main(String[] args) {
        tour = new int[numberOfNodes + 1];

        nearestNeighbor();

        System.out.print("The tour is: ");
        for (int i = 0; i <= numberOfNodes; i++) {
            System.out.print(tour[i] + " ");
        }
        System.out.println("\nThe tour cost is: " + tourCost);
    }

    private static void nearestNeighbor() {
        boolean[] visited = new boolean[numberOfNodes];
        int currentNode = 0;
        tour[0] = tour[numberOfNodes] = currentNode;
        visited[currentNode] = true;

        for (int i = 1; i < numberOfNodes; i++) {
            int minDistance = Integer.MAX_VALUE;
            int nearestNode = 0;

            for (int j = 0; j < numberOfNodes; j++) {
                if (!visited[j] && adjacencyMatrix[currentNode][j] < minDistance) {
                    minDistance = adjacencyMatrix[currentNode][j];
                    nearestNode = j;
                }
            }

            tour[i] = nearestNode;
            visited[nearestNode] = true;
            tourCost += minDistance;
            currentNode = nearestNode;
        }

        tourCost += adjacencyMatrix[currentNode][tour[0]];
    }
}