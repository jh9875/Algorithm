import java.util.Arrays;

public class FloydWashall {
	private int N;
	private int[][] adj;

	public FloyWashall(int N) {
		this.N = N;
		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
			adj[i][i] = 0;
		}
	}

	public void add(int u, int v, int w) {
		adj[u][v] = w;
		adj[v][u] = w;
	}

	public void findShortestDistance() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
	}

	public int getDistance(int start, int end) {
		return adj[start][end];
	}
}
