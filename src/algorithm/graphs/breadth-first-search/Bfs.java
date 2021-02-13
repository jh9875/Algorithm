import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
	private int N;
	private boolean[] visited;
	private List<Integer>[] graph;			//리스트배열 그래프
	// private int[][] graph;				//2차원 배열 그래프

	public Bfs(int N) {
		this.N =N;
		visited =new boolean[N];

		graph =new ArrayList[N];
		for(int i =0; i <N; ++i)			//그래프 초기화
			graph[i] =new ArrayList<>();
	}

	public void addEdge(int u, int v) {		//그래프에 노드 u와 v 관계 추가
		graph[u].add(v);
		graph[v].add(u);					//양방향 그래프인 경우
	}

	public void search(int start) {
		Queue<Integer> queue =new LinkedList<>();
		
		queue.add(start);					//시작위치 queue에 추가
		visited[start] =true;

		while(!queue.isEmpty()) {
			int here =queue.poll();

			for(int next : graph[here]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] =true;
				}
			}
		}
	}
}
