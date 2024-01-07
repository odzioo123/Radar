import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Clasterer {
    private List<List<int[]>> clusters;
    public Clasterer(int[][] bitmap) {
        this.clusters = extractClusters(bitmap);
    }

    public List<List<int[]>> getClusters() {
        return clusters;
    }

    private static List<List<int[]>> extractClusters(int[][] binaryBitmap)
    {
        int rows = binaryBitmap.length;
        int cols = binaryBitmap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<List<int[]>> clusters = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (binaryBitmap[row][col] == 1 && !visited[row][col]) {
                    List<int[]> cluster = new ArrayList<>();
                    dfs(binaryBitmap, row, col, visited, cluster);
                    clusters.add(cluster);
                }
            }
        }

        return clusters;
    }

    private static void dfs(int[][] binaryBitmap, int startRow, int startCol, boolean[][] visited, List<int[]> cluster) {
        int rows = binaryBitmap.length;
        int cols = binaryBitmap[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startRow, startCol});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            if (row < 0 || row >= rows || col < 0 || col >= cols || binaryBitmap[row][col] == 0 || visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            cluster.add(new int[]{row, col});

            // Add neighbors to the stack
            stack.push(new int[]{row - 1, col}); // Up
            stack.push(new int[]{row + 1, col}); // Down
            stack.push(new int[]{row, col - 1}); // Left
            stack.push(new int[]{row, col + 1}); // Right
        }
    }

    public void printClusters()
    {
        for (int i = 0; i < this.clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ":");
            for (int[] pixel : this.clusters.get(i)) {
                System.out.println("(" + pixel[0] + ", " + pixel[1] + ")");
            }
            System.out.println();
        }
    }

    public void swapXY()
    {
        for (var cluster: this.clusters)
        {
                for(int[] inti : cluster)
                {
                    int temp = inti[0];
                    inti[0] = inti[1];
                    inti[1] = temp;
                }
        }
    }
}
