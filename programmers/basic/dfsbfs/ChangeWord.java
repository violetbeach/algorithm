package basic.dfsbfs;

public class ChangeWord {
	
	public int solution(String begin, String target, String[] words) {
        
        int answer = recursive(begin, target, words, -1, 0);
        
        if(answer == Integer.MAX_VALUE) return 0;
        
        return answer;
    }
    
    public int recursive(String begin, String target, String[] words, int index, int count){
        
        if(begin.equals(target)) {
        	System.out.println("aa");
            return count;
        }
        
        if(index + 1 == words.length) {
            return Integer.MAX_VALUE;
        } 
        
        int a = recursive(begin, target, words, index + 1, count);
        
        if(canChange(begin, words[index+1])) {
        	int b = recursive(words[index+1], target, words, index + 1, count + 1);
        	return Math.min(a, b);
        }
        
        return a;
        
    }
    
    public boolean canChange(String from, String to){
        int count = 0;
        for(int i=0; i<from.length(); i++){
            if(from.charAt(i) != to.charAt(i)) count++;   
        }
        return count == 1 ? true : false; 
    }
    
    public static void main(String[] args) {
    	ChangeWord a = new ChangeWord();
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(a.solution("hit", "cog", words));
	}
}