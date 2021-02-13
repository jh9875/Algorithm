import java.util.ArrayList;
import java.util.List;

public class KMP {
	

	//단어의 위치는 0부터 text.length-1까지.
	//list는 text에 나타나는 word들의 시작 위치들.
	List<Integer> kmp(String text, String word) {
		List<Integer> ret =new ArrayList<>();
		int[] pi =getPartialMatch(word);
		int textLen =text.length(), wordLen =word.length();
		int begin =0, matched =0;

		while(begin <=textLen-wordLen) {
			if(matched <wordLen && text.charAt(begin +matched) ==word.charAt(matched)) {
				++matched;
				if(matched ==wordLen) ret.add(begin);
			}else {
				if(matched ==0) {
					++begin;
				}else {
					begin +=matched-pi[matched-1];
					matched =pi[matched-1];
				}
			}
		}

		return ret;
	}

	//word의 부분 일치 테이블.
	int[] getPartialMatch(String word) {
		int wordLen =word.length();
		int[] pi =new int[wordLen];
		int begin =1, matched =0;

		while(begin+matched <wordLen) {
			if(word.charAt(begin+matched) ==word.charAt(matched)) {
				++matched;
				pi[begin+matched-1] =matched;
			}else {
				if(matched ==0) {
					++begin;
				}else {
					begin +=matched-pi[matched-1];
					matched =pi[matched-1];
				}

			}
		}

		return pi;
	}
}
