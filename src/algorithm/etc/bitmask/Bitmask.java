

public class Bitmask {
	private int N;						//최대 값
	private int set;					//set의 범위는 N ~ 0

	public Bitmask(int N) {
		this.N =N;
		this.set =0;
	}

	public void setFull() {
		set =(1<<(N+1)) -1;				//N ~ 0 까지 모든 비트를 1로
	}
	public void setEmpty() {
		set =0;
	}
	public void add(int n) {
		set |=(1<<n);
	}
	public void remove(int n) {			//n 제거
		set &=~(1<<n);
	}
	public boolean check(int n) {		//n이 있다면 true
		if((set &(1<<n)) !=0)
			return true;
		return false;
	}
	public int getBitCount() {			//비트가 1인 총 수 출력
		return Integer.bitCount(set);
	}
}