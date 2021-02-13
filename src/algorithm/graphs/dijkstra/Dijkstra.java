import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
	
	class Edge {
		int index;
		int cost;
		Edge(int index, int cost) {
			this.index =index;
			this.cost =cost;
		}
	}

	private int N;
	private int[] dist;
	// private List<Integer>[] graph;					//리스트배열 그래프 (가중치가 1인 경우.)
	private List<Edge>[] graph;							//배열 i번째 연결 노드들
	// private int[][] graph;							//2차원 배열 그래프

	public Dijkstra(int N) {
		this.N =N;
		dist =new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);			//처음에 모든 거리값을 무한으로 설정.

		graph =new ArrayList[N];
		for(int i =0; i <N; ++i)						//그래프 초기화
			graph[i] =new ArrayList<>();
	}

	public void addEdge(int u, int v, int w) {
		graph[u].add(new Edge(v, w));					//노드 u에서 노트 v 까지 가중치가 w인 선 추가.
	}

	public void search(int start) {
		PriorityQueue<Edge> pq =new PriorityQueue<>();

		dist[start] =0;
		pq.add(new Edge(start, 0));						//시작 위치, 거리는 0으로

		while(!pq.isEmpty()) {
			int here =pq.peek().index;
			int cost =pq.peek().cost;
			pq.poll();

			if(dist[here] <cost) continue;				//현재 위치가 기록된 위치보다 길다면 패스.

			for(Edge e : graph[here]) {
				int there =e.index;
				int nextCost =e.cost;

				if(dist[there] >cost +nextCost) {
					dist[there] =cost +nextCost;
					pq.add(new Edge(there, cost +nextCost));
				}
			}
		}
	}
}
